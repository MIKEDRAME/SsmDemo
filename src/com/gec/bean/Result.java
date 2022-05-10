package com.gec.bean;

//用于封装key-value实体类
public class Result {

    private String xdata;
    private String ydata;

    @Override
    public String toString() {
        return "Result{" +
                "xdata='" + xdata + '\'' +
                ", ydata='" + ydata + '\'' +
                '}';
    }

    public Result() {
    }

    public Result(String xdata, String ydata) {
        this.xdata = xdata;
        this.ydata = ydata;
    }

    public String getXdata() {
        return xdata;
    }

    public void setXdata(String xdata) {
        this.xdata = xdata;
    }

    public String getYdata() {
        return ydata;
    }

    public void setYdata(String ydata) {
        this.ydata = ydata;
    }
}