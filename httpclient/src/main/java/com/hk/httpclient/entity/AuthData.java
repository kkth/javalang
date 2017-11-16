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
public class AuthData {
    private boolean login;
    private long timeout;
    private String token;

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

