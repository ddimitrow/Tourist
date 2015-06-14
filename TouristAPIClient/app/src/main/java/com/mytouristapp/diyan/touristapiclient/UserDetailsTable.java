package com.mytouristapp.diyan.touristapiclient;


public class UserDetailsTable {

    String firstName,lastName,userName,password,phoneNumber;

    public UserDetailsTable(String firstName, String lastName, String userName,
                            String password, String phoneNumber) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.phoneNumber=phoneNumber;
    }

    public UserDetailsTable() {
        super();
        this.firstName = null;
        this.lastName = null;
        this.userName = null;
        this.password = null;
        this.phoneNumber = null;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}