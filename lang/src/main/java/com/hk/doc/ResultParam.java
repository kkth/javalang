package com.hk.doc;

/**
 * Created by kunhe on 5/17/17.
 */
public class ResultParam {
    private String name;
    private int id;

    /**
     * @param name
     * @param id
     */
    public ResultParam(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
