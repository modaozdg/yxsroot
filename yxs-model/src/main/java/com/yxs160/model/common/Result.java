package com.yxs160.model.common;

import java.io.Serializable;
import java.util.List;

/**
 * 结果返回
 */
public class Result<T> implements Serializable{

    private static final long serialVersionUID = 5459591211992830881L;
    /**
     * 状态码
     */
    private int code = 0;

    private String msg = "";

    private int count;

    private List<T> data;

    public Result(){

    }
    public Result(String msg){
        this.code = 0;
        this.msg = msg;
    }
    public Result(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
