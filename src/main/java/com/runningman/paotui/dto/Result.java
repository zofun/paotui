package com.runningman.paotui.dto;

import lombok.Getter;

/**
 * @author TCW
 * 统一的返回格式
 */
@Getter
public class Result {

    /**
     * 状态码
     */
    private int code;

    /**
     * 附加信息
     */
    private String message;


    /**
     * 数据
     */
    private Object data;

    /**
     * 数量
     */
    private int count;

    private Result setResult(int code, String message, Object data, int count) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.count = count;
        return this;
    }

    public Result success() {
        return setResult(200, "Success", null,0);
    }

    public Result success(Object data) {
        return setResult(200, "Success", data, 0);
    }
    public Result success(String message,int code) {
        return setResult(code, message, null, 0);
    }
    public Result success(String message,int code,Object data) {
        return setResult(code, message, data, 0);
    }

    public Result success(String message,int code,Object data,int count){
        return setResult(code,message,data,count);
    }

    public Result fail(Object data, String message) {
        return setResult(400, message, data, 0);
    }

    public Result fail(Object data, String message, int code) {
        return setResult(code, message, data, 0);
    }

    public Result fail(String message, int code) {
        return setResult(code, message, null, 0);
    }
}
