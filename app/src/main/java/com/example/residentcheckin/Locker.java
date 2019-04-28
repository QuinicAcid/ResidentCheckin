package com.example.residentcheckin;

public class Locker {

    private int lockerID;               //NOT null

    private String locker_description;  //null



    public Locker()

    {

        locker_description = "";

    }



    public Locker (int lID)

    {

        lockerID = lID;

        locker_description = "";

    }



    public int getLockerID() {

        return lockerID;

    }



    public void setLockerID(int lockerID) {

        this.lockerID = lockerID;

    }



    public String getLocker_description() {

        return locker_description;

    }



    public void setLocker_description(String locker_description) {

        this.locker_description = locker_description;

    }





}