package com.hk.httpclient.entity;

/**
 * Created by kunhe on 9/13/17.
 */

/*
{
  "msg": "OK",
  "data": {
    "login": true,
    "timeout": 18000,
    "token": "4d6017fe231f4ae787d33d33e0dc9c1e-td_586@tendcloud.com"
  },
  "status": 200
}
 */
public class SDMKEntity<T> {
    private String msg;
    private int status;//Optional
    private int code;//Optional
    private String seq;//Optional
    private T data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }
}
