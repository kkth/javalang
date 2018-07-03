package com.hk.json.enttiy;

/**
 * Created by kunhe on 7/10/17.
 */
public class MyType {
    private int intVal;
    private String strVal;
    private double dVal;

    public MyType(int intVal, String strVal, double dVal) {
        this.intVal = intVal;
        this.strVal = strVal;
        this.dVal = dVal;
    }

    public int getIntVal() {
        return intVal;
    }

    public void setIntVal(int intVal) {
        this.intVal = intVal;
    }

    public String getStrVal() {
        return strVal;
    }

    public void setStrVal(String strVal) {
        this.strVal = strVal;
    }

    public double getdVal() {
        return dVal;
    }

    public void setdVal(double dVal) {
        this.dVal = dVal;
    }
}
