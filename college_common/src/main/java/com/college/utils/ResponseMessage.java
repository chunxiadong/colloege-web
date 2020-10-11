package com.college.utils;
//消息回应
public class ResponseMessage<T> {
    private int code;
    private T data;
    private String msg;

    public ResponseMessage Success(){
        ResponseMessage<Object> responseMessage = new ResponseMessage<>();
        responseMessage.setCode(1000);
        responseMessage.setMsg("success");
        return responseMessage;
    }
    public ResponseMessage False(){
        ResponseMessage<Object> responseMessage = new ResponseMessage<>();
        responseMessage.setCode(1001);
        responseMessage.setMsg("false");
        return responseMessage;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
