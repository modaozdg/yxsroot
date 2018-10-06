/**

 @Name：layuiAdmin 内容系统
 @Author：star1029
 @Site：http://www.layui.com/admin/
 @License：LPPL
    
 */


layui.define(['table', 'form'], function(exports){
  var $ = layui.$
  ,table = layui.table
  ,form = layui.form;

  //文章管理
  table.render({
    elem: '#article-list'
    ,url: '/article/list-data' //模拟接口
      ,method:'post'
    ,cols: [[
      {type: 'checkbox', fixed: 'left'}
      ,{field: 'id', width: 100, title: '文章ID', align:'center'}
      ,{field: 'title', title: '文章标题',align:'center'}
      ,{field: 'source', title: '来源', minWidth: 100,align:'center'}
      ,{field: 'createTime', title: '上传时间', align: 'center'}
      ,{field: 'status', title: '发布状态', minWidth: 80, align: 'center',templet:function (d) {
                  return '<input type="checkbox" lay-verify="required" lay-filter="status" name="status" lay-skin="switch" lay-text="已发布|待修改">';
              }}
      ,{title: '操作', minWidth: 150, align: 'center', fixed: 'right', toolbar: '#table-content-list'}
    ]]
    ,page: true
    ,limit: 10
    ,limits: [10, 15, 20, 25, 30]
  });
  
  //监听工具条
  table.on('tool(article-list)', function(obj){
    var data = obj.data;
    if(obj.event === 'del'){
      layer.confirm('确定删除此文章？', function(index){
        obj.del();
        layer.close(index);
      });
    } else if(obj.event === 'edit'){
      layer.open({
        type: 2
        ,title: '编辑文章'
        ,content: '/article/to-edit?id='+ data.id
        ,maxmin: true
        ,area: ['550px', '550px']
        ,btn: ['确定', '取消']
        ,yes: function(index, layero){
          var iframeWindow = window['layui-layer-iframe'+ index]
          ,submit = layero.find('iframe').contents().find("#article-edit");

          //监听提交
          iframeWindow.layui.form.on('submit(article-edit)', function(data){
            var field = data.field; //获取提交的字段
            
            //提交 Ajax 成功后，静态更新表格中的数据
            //$.ajax({});
            $.ajax({
               url:'/article/save-edit'
               ,type:'post'
               ,data:data.field
               ,success:function(res){
                    obj.update({
                        title: field.title
                        ,source: field.source
                    }); //数据更新
                }
            });

            
            form.render();
            layer.close(index); //关闭弹层
          });  
          
          submit.click();
        }
      });
    }
  });

 

  exports('article', {})
});