package com.gec.bean;

import java.util.Date;

public class UserFundProduct {
    private Integer id;

    private Integer userid;

    private Integer fundid;

    private String starttime;

    private String endtime;

    private Integer status;

    //
    private User user;
    private FundProduct fundproduct;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public FundProduct getFundproduct() {
        return fundproduct;
    }

    public void setFundproduct(FundProduct fundproduct) {
        this.fundproduct = fundproduct;
    }



    //
    @Override
    public String toString() {
        return "UserFundProduct{" +
                "id=" + id +
                ", userid=" + userid +
                ", fundid=" + fundid +
                ", starttime='" + starttime + '\'' +
                ", endtime='" + endtime + '\'' +
                ", status=" + status +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getFundid() {
        return fundid;
    }

    public void setFundid(Integer fundid) {
        this.fundid = fundid;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}