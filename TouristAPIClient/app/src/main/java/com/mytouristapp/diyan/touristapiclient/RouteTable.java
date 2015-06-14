package com.mytouristapp.diyan.touristapiclient;


public class RouteTable {

    String startPoint,endPoint,date,time,ownerName,phoneNumber;

    public RouteTable(String startPoint, String endPoint, String date, String time, String ownerName, String phoneNumber) {
        super();
        this.startPoint=startPoint;
        this.endPoint = endPoint;
        this.date=date;
        this.time=time;
        this.ownerName=ownerName;
        this.phoneNumber=phoneNumber;
    }

    public RouteTable() {
        super();
        this.startPoint=null;
        this.endPoint = null;
        this.date=null;
        this.time=null;
        this.ownerName=null;
        this.phoneNumber=null;
    }

    public String getStartPoint() {
        return this.startPoint ;
    }
    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }
    public String getEndPoint() {
        return this.endPoint ;
    }
    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }
    public String getDate() {
        return this.date ;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getTime() {
        return this.time ;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getOwnerName() {
        return this.ownerName;
    }
    public void setOwnerName(String ownerName ) {
        this.ownerName = ownerName;
    }
    public String getPhoneNumber() {
        return this.phoneNumber ;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}