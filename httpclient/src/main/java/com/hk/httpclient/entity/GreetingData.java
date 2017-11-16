package com.hk.httpclient.entity;

/**
 * Created by kunhe on 9/13/17.
 */

/*
{
  "code": 2001,
  "msg": "OK",
  "data": {
    "name": "Congratunations! n DMK example server is deployed.",
    "timeStamp": "You name is kun. Current server time:Wed Sep 13 12:14:52 CST 2017"
    },
    "seq": "134ee6ac6fd34a9cb4dde92547f60b40"
    }
 */
public class GreetingData {
    private String name;
    private String timestamp;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
