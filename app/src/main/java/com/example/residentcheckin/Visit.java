package com.example.residentcheckin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Visit {

    private int visitID;                //NOT null

    private int residentID;             //NOT null

    private int bedID;                  //NOT null

    private String date_CheckIn;        //NOT null



    public Visit()

    {

        date_CheckIn = "";

        residentID = -1;

        bedID = -1;

    }





    //Constructor with resident ID with bed ID already chosen

    public Visit(int residentID, int bedID, String date_CheckIn, String date_CheckOut, String refer_other_org, String relationship_head, String disability_con, String disabilityType, String disability_longT, String disability_dep, String recieve_disab, String insurance_con, String insuranceType, String homeless_history, String length_stay_prior, String homeless_start, int numOfTimes_homeless, String house_status, String last_zip, String coc_code, String NC_county_serv, String residentCounty, String residentCity, String shelter_cat, String recieving_income, String source_income, String source_nonIncome_name, String form_sharingPlan)

    {

        this.residentID = residentID;

        this.bedID = bedID;

        this.date_CheckIn = date_CheckIn;

    }



    // constructor w/ everything but bed

    public Visit(int residentID, String date_CheckIn, String date_CheckOut, String refer_other_org, String relationship_head, String disability_con, String disabilityType, String disability_longT, String disability_dep, String recieve_disab, String insurance_con, String insuranceType, String homeless_history, String length_stay_prior, String homeless_start, int numOfTimes_homeless, String house_status, String last_zip, String coc_code, String NC_county_serv, String residentCounty, String residentCity, String shelter_cat, String recieving_income, String source_income, String source_nonIncome_name, String form_sharingPlan)

    {

        this.residentID = residentID;

        this.date_CheckIn = date_CheckIn;

    }







    public int getVisitID() {

        return visitID;

    }



    public void setVisitID(int visitID) {

        this.visitID = visitID;

    }



    public String getDate_CheckIn() {

        return date_CheckIn;

    }



    public void setDate_CheckIn(String date_CheckIn) {

        this.date_CheckIn = date_CheckIn;

    }



    public int getResidentID() {

        return residentID;

    }



    public int getBedID() {

        return bedID;

    }



    public void setResidentID(int residentID) {

        this.residentID = residentID;

    }



    public void setBedID(int bedID) {

        this.bedID = bedID;

    }





//Validation

    public boolean isDateValid(String date)

    {

        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

        format.setLenient(false);

        try

        {

            Date dateForm = format.parse(date);

        }

        catch(ParseException e)

        {

            return false;

        }

        return true;



    }



    public boolean ValidateYesOrNo(String str)

    {

        if(str.equals("Y") || str.equals("N"))

        {

            return true;

        }



        return false;

    }



    public boolean NotNullIsFilled(String str)

    {

        if(str != null && !str.isEmpty())

        {

            return true;

        }

        return false;

    }

}
