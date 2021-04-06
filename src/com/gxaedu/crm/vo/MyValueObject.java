package com.gxaedu.crm.vo;

import com.gxaedu.crm.pojo.HelloSQL;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: thinknovo
 * Date: 2020/02/18
 * Description:
 * Version: V1.0
 */
public class MyValueObject {
    private int myid;
    private List<HelloSQL> helloSQLList;

    public int getMyid() {
        return myid;
    }

    public void setMyid(int myid) {
        this.myid = myid;
    }

    public List<HelloSQL> getHelloSQLList() {
        return helloSQLList;
    }

    public void setHelloSQLList(List<HelloSQL> helloSQLList) {
        this.helloSQLList = helloSQLList;
    }
}

