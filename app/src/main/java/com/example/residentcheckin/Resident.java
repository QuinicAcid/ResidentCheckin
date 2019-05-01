package com.example.residentcheckin;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Lupe
 */
public class Resident {

    final String myDBURL = "jdbc:jtds:sqlserver://SQL5008.site4now.net/DB_A47087_smgroup;user=DB_A47087_smgroup_admin;password=ftccgroup1";


    private int residentID;     //NOT null
    private String firstName;   //NOT null
    private String lastName;    //NOT null
    private String addressLn1;  //null
    private String addressLn2;  //null
    private String city;        //null
    private String state;       //null
    private String zip;         //null
    private String phone;       //null
    private String phoneAlt;    //null
    private String res_email;   //null
    private java.sql.Date birthDate;   //null
    private String socialSN;    //NOT null
    private String gender;      //NOT null
    private String emContPhone; //null
    private String emContName;  //null
    private String usVet;       //NOT null
    private String race;        //NOT null
    private String ethnicity;   //NOT null
    private String disability_con;      //NOT null
    private String disabilityType;      //NOT null
    private String insurance_con;       //NOT null
    private String insuranceType;       //NOT null
    private String homeless_history;    //NOT null
    private String length_stay_prior;   //NOT null
    private java.sql.Date homeless_start;      //null
    private String numOfTimes_homeless;    //NOT null
    private String house_status;        //NOT null
    private String last_zip;            //null
    private String coc_code;            //null
    private String NC_county_serv;      //null
    private String residentCounty;      //null
    private String residentCity;        //null
    private int length_stay_current;  // NOT null

    public Resident() {
        firstName = "";
        lastName = "";
        addressLn1 = "";
        addressLn2 = "";
        city = "";
        state = "";
        zip = "";
        phone = "";
        phoneAlt = "";
        res_email = "";
        birthDate = null;
        socialSN = "";
        gender = "";
        emContPhone = "";
        usVet = "";
        race = "";
        ethnicity = "";
    }

    // constructor to get resident information from the DB and store as a new instance of a resident
    public Resident(int rID) {
        String url = "jdbc:jtds:sqlserver://SQL5008.site4now.net/DB_A47087_smgroup";
        String user = "DB_A47087_smgroup_admin";
        String pass = "ftccgroup1";

        residentID = rID;

        try {
            System.out.println("################# Before Connection #################");
            Class.forName("net.sourceforge.jtds.jdbc.Driver");

            System.out.println("################# Before getConnection #################");
            Connection conn = DriverManager.getConnection("jdbc:jtds:sqlserver://SQL5008.site4now.net/DB_A47087_smgroup", user, pass);


            System.out.println("################# Connection created, no statement created #################");
            String sql = "SELECT * FROM [dbo].[Resident] WHERE [Resident_ID] = " + residentID;
            Statement statement = conn.createStatement();
            System.out.println("################# Statement created, not executed #################");
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("################# Executed Query #################");
            rs.next();
            lastName = rs.getString("Last_Name");
            firstName = rs.getString("First_Name");
            addressLn1 = rs.getString("Address");
            addressLn2 = rs.getString("AddressLine2");
            city = rs.getString("City");
            state = rs.getString("State");
            zip = rs.getString("Zip_Code");
            phone = rs.getString("Phone");
            birthDate = rs.getDate("Birth_Date");
            socialSN = rs.getString("SSN");
            gender = rs.getString("Gender");
            phoneAlt = rs.getString("Phone_Alternate");
            res_email = rs.getString("Email");
            emContPhone = rs.getString("Emergency_Contact_Phone");
            emContName = rs.getString("Emergency_Contact_Name");
            usVet = rs.getString("US_Military_Veteran_Status");
            race = rs.getString("Race");
            ethnicity = rs.getString("Ethnicity");
            length_stay_current = rs.getInt("Current_Length_Of_Stay");
            disability_con = rs.getString("Does_Client_Have_a_Disabling_Condition");
            disabilityType = rs.getString("Disability_Type");
            insurance_con = rs.getString("Are_You_Covered_By_Insurance");
            insuranceType = rs.getString("Health_Insurance_Type");
            homeless_history = rs.getString("Homeless_History_Type");
            length_stay_prior = rs.getString("Length_Of_Stay_In_Prior_Living_Situation");
            homeless_start = rs.getDate("Homeless_Start_Date");
            house_status = rs.getString("Housing_Status");
            last_zip = rs.getString("Last_know_Zip_Code");
            coc_code = rs.getString("COC_Code");
            NC_county_serv = rs.getString("NC_County_Of_Service");
            residentCounty = rs.getString("County_Of_Residence");
            residentCity = rs.getString("City_Of_Residence");
            numOfTimes_homeless = rs.getString("Number_Of_Times_Homelss");

            System.out.print("Connected and got data");
        } catch (Exception e) {
            System.out.println(e.getMessage() + "Failed to make connection");
        }
    }

    // constructor when we have all the relevant information about a resident
    public Resident(int residentID, String firstName, String lastName, String addressLn1, String addressLn2, String city, String state, String zip, String phone, String phoneAlt, String res_email, java.sql.Date birthDate, String socialSN, String gender, String emContPhone, String emContName, String usVet, String race, String ethnicity, String disability_con, String disabilityType, String insurance_con, String insuranceType, String homeless_history, String length_stay_prior, java.sql.Date homeless_start, String numOfTimes_homeless, String house_status, String last_zip, String coc_code, String NC_county_serv, String residentCounty, String residentCity, int length_stay_current) {
        this.residentID = residentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressLn1 = addressLn1;
        this.addressLn2 = addressLn2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.phoneAlt = phoneAlt;
        this.res_email = res_email;
        this.birthDate = birthDate;
        this.socialSN = socialSN;
        this.gender = gender;
        this.emContPhone = emContPhone;
        this.emContName = emContName;
        this.usVet = usVet;
        this.race = race;
        this.ethnicity = ethnicity;
        this.disability_con = disability_con;
        this.disabilityType = disabilityType;
        this.insurance_con = insurance_con;
        this.insuranceType = insuranceType;
        this.homeless_history = homeless_history;
        this.length_stay_prior = length_stay_prior;
        this.homeless_start = homeless_start;
        this.numOfTimes_homeless = numOfTimes_homeless;
        this.house_status = house_status;
        this.last_zip = last_zip;
        this.coc_code = coc_code;
        this.NC_county_serv = NC_county_serv;
        this.residentCounty = residentCounty;
        this.residentCity = residentCity;
        this.length_stay_current = length_stay_current;
    }

    public int getResidentID() {
        return residentID;
    }

    public void setResidentID(int residentID) {
        this.residentID = residentID;
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

    public String getAddressLn1() {
        return addressLn1;
    }

    public void setAddressLn1(String addressLn1) {
        this.addressLn1 = addressLn1;
    }

    public String getAddressLn2() {
        return addressLn2;
    }

    public void setAddressLn2(String addressLn2) {
        this.addressLn2 = addressLn2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoneAlt() {
        return phoneAlt;
    }

    public void setPhoneAlt(String phoneAlt) {
        this.phoneAlt = phoneAlt;
    }

    public String getRes_email() {
        return res_email;
    }

    public void setRes_email(String res_email) {
        this.res_email = res_email;
    }

    public String getSocialSN() {
        return socialSN;
    }

    public void setSocialSN(String socialSN) {
        this.socialSN = socialSN;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmContPhone() {
        return emContPhone;
    }

    public void setEmContPhone(String emContPhone) {
        this.emContPhone = emContPhone;
    }

    public String getEmContName() {
        return emContName;
    }

    public void setEmContName(String emContName) {
        this.emContName = emContName;
    }

    public String getUsVet() {
        return usVet;
    }

    public void setUsVet(String usVet) {
        this.usVet = usVet;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getDisability_con() {
        return disability_con;
    }

    public String getDisabilityType() {
        return disabilityType;
    }

    public String getInsurance_con() {
        return insurance_con;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public String getHomeless_history() {
        return homeless_history;
    }

    public String getLength_stay_prior() {
        return length_stay_prior;
    }

    public String getNumOfTimes_homeless() {
        return numOfTimes_homeless;
    }

    public String getHouse_status() {
        return house_status;
    }

    public String getLast_zip() {
        return last_zip;
    }

    public String getCoc_code() {
        return coc_code;
    }

    public String getNC_county_serv() {
        return NC_county_serv;
    }

    public String getResidentCounty() {
        return residentCounty;
    }

    public String getResidentCity() {
        return residentCity;
    }

    public void setDisability_con(String disability_con) {
        this.disability_con = disability_con;
    }

    public void setDisabilityType(String disabilityType) {
        this.disabilityType = disabilityType;
    }

    public void setInsurance_con(String insurance_con) {
        this.insurance_con = insurance_con;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public void setHomeless_history(String homeless_history) {
        this.homeless_history = homeless_history;
    }

    public void setLength_stay_prior(String length_stay_prior) {
        this.length_stay_prior = length_stay_prior;
    }

    public java.sql.Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(java.sql.Date birthDate) {
        this.birthDate = birthDate;
    }

    public java.sql.Date getHomeless_start() {
        return homeless_start;
    }

    public void setHomeless_start(java.sql.Date homeless_start) {
        this.homeless_start = homeless_start;
    }

    public void setNumOfTimes_homeless(String numOfTimes_homeless) {
        this.numOfTimes_homeless = numOfTimes_homeless;
    }

    public void setHouse_status(String house_status) {
        this.house_status = house_status;
    }

    public void setLast_zip(String last_zip) {
        this.last_zip = last_zip;
    }

    public void setCoc_code(String coc_code) {
        this.coc_code = coc_code;
    }

    public void setNC_county_serv(String NC_county_serv) {
        this.NC_county_serv = NC_county_serv;
    }

    public void setResidentCounty(String residentCounty) {
        this.residentCounty = residentCounty;
    }

    public void setResidentCity(String residentCity) {
        this.residentCity = residentCity;
    }

    public int getLength_stay_current() {
        return length_stay_current;
    }

    public void setLength_stay_current(int length_stay_current) {
        this.length_stay_current = length_stay_current;
    }

    //Vaidation of data
    public boolean isFirstNameValid(String name) {
        return name.matches("[A-Z][a-zA-Z]*");
    }

    public boolean isLastNameValid(String name) {
        return name.matches("[a-zA-Z]+([ '-][a-zA-Z]+)*");
    }

    public boolean isAddressValid(String add) {
        if (add.equals("")) {
            return true;
        }
        return add.matches("\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
    }

    public boolean isStateValid(String state) {
        if (state.equals("")) {
            return true;
        }
        //two letter only
        return state.matches("[A-Z][A-Z]");
    }

    public boolean isZipValid(String zip) {
        if (zip.equals("")) {
            return true;
        }
        return zip.matches("\\d{4}-\\d{5}|\\d{5}");
    }

    public boolean isFullNameValid(String fullN) {
        if (fullN.equals("")) {
            return true;
        }
        return fullN.matches("[a-zA-Z\\\\s]*");
    }

    public boolean isEmailValid(String email) {
        if (email.equals("")) {
            return true;
        }
        return email.matches("^(.+)@(.+)$");
    }

    public boolean isDateValid(String dateField) {
        DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        if (dateField.equals("")) {
            return true;
        } else {
            try {
                format.parse(dateField);
                return true;
            } catch (ParseException e) {
                return false;
            }
        }
    }

    public boolean isSSNValid(String ssn) {
        return (ssn.matches("\\d{3}-\\d{2}-\\d{4}") || ssn.equals("0") || ssn.equals("1"));
    }

    public boolean isGenderValid(String gen) {
        // ensure only males are considered valid
        return gen.equals("MA");
    }

    // save the resident to the DB
    public void AddNewResident(Connection conn, String fName, String lName, String add, String add2, String c, String st, String zp, String phne, String phneAlt, String email, String bDate, String ssn, String gen, String emergencyP, String emergencyN, String vet, String r, String eth, String dcon, String ins, String hlstat, String len, String hlDate, String timesh, String houstat, String lzip, String coc, String counts, String countr, String cityr) {
        String error = "The following fields contain an error: ";
        int errorCount = 0;

        // check for invalid gender - if not male, refer to another shelter
        if (isGenderValid(gen)) {
            gender = gen;

            if (isFirstNameValid(fName)) {
                firstName = fName;
            } else {
                error += "\nFirst Name";
                errorCount++;
            }
            if (isLastNameValid(lName)) {
                lastName = lName;
            } else {
                error += "\nLast Name";
                errorCount++;
            }
            if (isAddressValid(add)) {
                addressLn1 = add;
            } else {
                error += "\nAddress Line 1";
                errorCount++;
            }
            addressLn2 = add2;
            city = c;
            if (isStateValid(st)) {
                state = st;
            } else {
                error += "\nState";
                errorCount++;
            }
            if (isZipValid(zp)) {
                zip = zp;
            } else {
                error += "\nZip Code";
                errorCount++;
            }
            if (phne.equals("")) {
                phone = "";
            } else {
                phne = phne.replaceAll("[^0-9]", "");
                phone = phne;
            }
            if (phneAlt.equals("")) {
                phoneAlt = "";
            } else {
                phneAlt = phneAlt.replaceAll("[^0-9]", "");
                phoneAlt = phneAlt;
            }
            if (isEmailValid(email)) {
                res_email = email;
            } else {
                error += "\nEmail Address - Resident";
                errorCount++;
            }
            if (bDate.equals("Client doesn't know")) {
                bDate = "01/01/1900";
            } else if (bDate.equals("Client refused")) {
                bDate = "01/01/1901";
            }
            if (isDateValid(bDate)) {
                if (bDate.equals("")) {
                    birthDate = null;
                } else {
                    try {
                        SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
                        java.util.Date date = sdf1.parse(bDate);
                        birthDate = new java.sql.Date(date.getTime());
                    } catch (ParseException pe) {
                        System.out.println("Parse Exception at Birth Date: " + pe);
                    }
                }
            } else {
                error += "\nDate of Birth";
                errorCount++;
            }
            if (isSSNValid(ssn)) {
                if (ssn.equals("")) {
                    socialSN = "";
                } else {
                    socialSN = ssn.replaceAll("-", "");
                }
            } else {
                error += "\nSSN";
                errorCount++;
            }

            if (emergencyP.equals("")) {
                emContPhone = "";
            } else {
                emergencyP = emergencyP.replaceAll("[^0-9]", "");
                emContPhone = emergencyP;
            }
            if (isFullNameValid(emergencyN)) {
                emContName = emergencyN;
            } else {
                error += "\nName - Emergency Contact";
                errorCount++;
            }
            usVet = vet;
            race = r;
            ethnicity = eth;
            disability_con = dcon;
            insurance_con = ins;
            homeless_history = hlstat;
            length_stay_prior = len;

            if (isDateValid(hlDate)) {
                if (hlDate.equals("")) {
                    homeless_start = null;
                } else {
                    try {
                        SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
                        java.util.Date date = sdf1.parse(hlDate);
                        homeless_start = new java.sql.Date(date.getTime());
                    } catch (ParseException pe) {
                        System.out.println("Parse Exception at Homeless Start Date: " + pe);
                    }
                }
            } else {
                error += "\nHomelessness Start Date";
                errorCount++;
            }
            numOfTimes_homeless = timesh;
            house_status = houstat;
            if (isZipValid(lzip)) {
                last_zip = lzip;
            } else {
                error += "\nLast Known Zip Code";
                errorCount++;
            }
            coc_code = coc;
            if (isFullNameValid(counts)) {
                NC_county_serv = counts;
            } else {
                error += "\nNC County of Service";
                errorCount++;
            }
            if (isFullNameValid(countr)) {
                residentCounty = countr;
            } else {
                error += "\nCounty of Residence";
                errorCount++;
            }
            if (isFullNameValid(cityr)) {
                residentCity = cityr;
            } else {
                error += "\nCity of Residence";
                errorCount++;
            }
            String message = lastName + ", " + firstName + ", " + addressLn1 + ", " + addressLn2 + ", " + city + ", " + state + ", " + zip + ", " + phone + ", " + birthDate + ", " + socialSN + ", " + gender + ", " + phoneAlt + ", " + res_email + ", " + emContPhone + ", " + emContName + ", " + usVet + ", " + race + ", " + ethnicity + ", " + 0 + ", " + disability_con + ", " + "NULL" + ", " + insurance_con + ", " + "NULL" + ", " + homeless_history + ", " + length_stay_prior + ", " + homeless_start + ", " + house_status + ", " + last_zip + ", " + coc_code + ", " + NC_county_serv + ", " + residentCounty + ", " + residentCity + ", " +  numOfTimes_homeless;
            String nullValues = "Null Fields are: ";
            //TestOptionPane11 dbg = new TestOptionPane11(message);
            if (errorCount == 0) {
                try {
                    PreparedStatement ps = conn.prepareStatement("INSERT INTO [dbo].[Resident](Last_Name,First_Name,Address,AddressLine2,City,State,Zip_Code,Phone,Birth_Date,SSN,Gender,Phone_Alternate,Email,Emergency_Contact_Phone,Emergency_Contact_Name,US_Military_Veteran_Status,Race,Ethnicity,Current_Length_Of_Stay,Does_Client_Have_a_Disabling_Condition,Disability_Type,Are_You_Covered_By_Insurance,Health_Insurance_Type,Homeless_History_Type,Length_Of_Stay_In_Prior_Living_Situation,Homeless_Start_Date,Housing_Status,Last_know_Zip_Code,COC_Code,NC_County_Of_Service,County_Of_Residence,City_Of_Residence,Number_Of_Times_Homelss) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, lastName); // Last_Name
                    ps.setString(2, firstName); // First_Name
                    if (addressLn1.equals("")) {
                        ps.setNull(3, java.sql.Types.VARCHAR);
                        nullValues += "\nAddress Line 1";
                    } else {
                        ps.setString(3, addressLn1); // Address
                    }
                    if (addressLn2.equals("")) {
                        ps.setNull(4, java.sql.Types.VARCHAR);
                        nullValues += "\nAddress Line 2";
                    } else {
                        ps.setString(4, addressLn2); // AddressLine2
                    }
                    if (city.equals("")) {
                        ps.setNull(5, java.sql.Types.VARCHAR);
                        nullValues += "\nCity";
                    } else {
                        ps.setString(5, city); // City
                    }
                    if (state.equals("")) {
                        ps.setNull(6, java.sql.Types.CHAR);
                        nullValues += "\nState";
                    } else {
                        ps.setString(6, state); // State
                    }
                    if (zip.equals("")) {
                        ps.setNull(7, java.sql.Types.VARCHAR);
                        nullValues += "\nZip Code";
                    } else {
                        ps.setString(7, zip); // Zip_Code
                    }
                    if (phone.equals("")) {
                        ps.setNull(8, java.sql.Types.CHAR);
                        nullValues += "\nPhone";
                    } else {
                        ps.setString(8, phone); // Phone
                    }
                    if (birthDate == null) {
                        ps.setNull(9, java.sql.Types.DATE);
                        nullValues += "\nBirth Date";
                    } else {
                        ps.setDate(9, birthDate);// Birth_Date
                    }
                    if (socialSN.equals("")) {
                        ps.setNull(10, java.sql.Types.NVARCHAR);
                        nullValues += "\nSSN";
                    } else {
                        ps.setString(10, socialSN); // SSN
                    }
                    ps.setString(11, gender); // Gender
                    if (phoneAlt.equals("")) {
                        ps.setNull(12, java.sql.Types.VARCHAR);
                        nullValues += "\nPhone Alternate";
                    } else {
                        ps.setString(12, phoneAlt); // Phone_Alternate
                    }
                    if (res_email.equals("")) {
                        ps.setNull(13, java.sql.Types.VARCHAR);
                        nullValues += "\nResident Email";
                    } else {
                        ps.setString(13, res_email); // resident email
                    }

                    if (emContPhone.equals("")) {
                        ps.setNull(14, java.sql.Types.VARCHAR);
                        nullValues += "\nEmergency Contact Phone";
                    } else {
                        ps.setString(14, emContPhone); // Emergency_Contact_Phone
                    }
                    if (emContName.equals("")) {
                        ps.setNull(15, java.sql.Types.VARCHAR);
                        nullValues += "\nEmergency Contact Name";
                    } else {
                        ps.setString(15, emContName); // Emergency_Contact_Name
                    }
                    ps.setString(16, usVet); // US_Military_Veteran_Status
                    ps.setString(17, race); // Race
                    ps.setString(18, ethnicity); // Ethnicity
                    ps.setInt(19, 0); // Current_Length_Of_Stay
                    ps.setString(20, disability_con); // Does_Client_Have_a_Disabling_Condition
                    ps.setNull(21, java.sql.Types.VARCHAR); // Disability_Type
                    nullValues += "\nDisability Type";
                    ps.setString(22, insurance_con); // Are_You_Covered_By_Insurance
                    ps.setNull(23, java.sql.Types.VARCHAR); // Health_Insurance_Type
                    nullValues += "\nHealth Insurance Type";
                    ps.setString(24, homeless_history); // Homeless_History_Type
                    ps.setString(25, length_stay_prior); // Length_Of_Stay_In_Prior_Living_Situation
                    if (homeless_start == null) {
                        ps.setNull(26, java.sql.Types.DATE);
                        nullValues += "\nHomeless Start Date";
                    } else {
                        ps.setDate(26, homeless_start); // Homeless_Start_Date
                    }
                    ps.setString(27, house_status); // Housing_Status
                    if (last_zip.equals("")) {
                        ps.setNull(28, java.sql.Types.VARCHAR);
                        nullValues += "\nLast Known Zip";
                    } else {
                        ps.setString(28, last_zip); // Last_know_Zip_Code
                    }
                    if (coc_code.equals("")) {
                        ps.setNull(29, java.sql.Types.VARCHAR);
                        nullValues += "\nCOC Code";
                    } else {
                        ps.setString(29, coc_code);// COC_Code
                    }
                    if (NC_county_serv.equals("")) {
                        ps.setNull(30, java.sql.Types.VARCHAR);
                        nullValues += "\nNC County of Service";
                    } else {
                        ps.setString(30, NC_county_serv); // NC_County_Of_Service
                    }
                    if (residentCounty.equals("")) {
                        ps.setNull(31, java.sql.Types.VARCHAR);
                        nullValues += "\nCounty of Residence";
                    } else {
                        ps.setString(31, residentCounty); // County_Of_Residence
                    }
                    if (residentCity.equals("")) {
                        ps.setNull(32, java.sql.Types.VARCHAR);
                        nullValues += "\nCity of Residence";
                    } else {
                        ps.setString(32, residentCity); // City_Of_Residence
                    }
                    ps.setString(33, numOfTimes_homeless); // Number_Of_Times_Homelss

                    //dbg = new TestOptionPane11(nullValues);
                    ps.executeUpdate();

                    ResultSet tableKeys = ps.getGeneratedKeys();
                    tableKeys.next();
                    int residentKey = tableKeys.getInt(1);
                    this.residentID = residentKey;
                    //TestOptionPane11 dbg = new TestOptionPane11("Resident Key is: " + residentID);
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
                System.out.println("Invalid entries");
            }
        } else {
            System.out.println("This shelter can only accept males.  Please refer to another shelter.");
        }
    }

    // update an existing resident in the DB
    public void UpdateResident(Connection conn, int resID, String fName, String lName, String add, String add2, String c, String st, String zp, String phne, String phneAlt, String email, String bDate, String ssn, String gen, String emergencyP, String emergencyN, String vet, String r, String eth, String dcon, String ins, String hlstat, String len, String hlDate, String timesh, String houstat, String lzip, String coc, String counts, String countr, String cityr) {
        String error = "The following fields contain an error: ";
        int errorCount = 0;

        // check for invalid gender - if not male, refer to another shelter
        if (isGenderValid(gen)) {
            gender = gen;

            if (isFirstNameValid(fName)) {
                firstName = fName;
            } else {
                error += "\nFirst Name";
                errorCount++;
            }
            if (isLastNameValid(lName)) {
                lastName = lName;
            } else {
                error += "\nLast Name";
                errorCount++;
            }
            if (isAddressValid(add)) {
                addressLn1 = add;
            } else {
                error += "\nAddress Line 1";
                errorCount++;
            }
            addressLn2 = add2;
            city = c;
            if (isStateValid(st)) {
                state = st;
            } else {
                error += "\nState";
                errorCount++;
            }
            if (isZipValid(zp)) {
                zip = zp;
            } else {
                error += "\nZip Code";
                errorCount++;
            }
            if (phne.equals("")) {
                phone = "";
            } else {
                phne = phne.replaceAll("[^0-9]", "");
                phone = phne;
            }
            if (phneAlt.equals("")) {
                phoneAlt = "";
            } else {
                phneAlt = phneAlt.replaceAll("[^0-9]", "");
                phoneAlt = phneAlt;
            }
            if (isEmailValid(email)) {
                res_email = email;
            } else {
                error += "\nEmail Address - Resident";
                errorCount++;
            }
            if (bDate.equals("Client doesn't know")) {
                bDate = "01/01/1900";
            } else if (bDate.equals("Client refused")) {
                bDate = "01/01/1901";
            }
            if (isDateValid(bDate)) {
                if (bDate.equals("")) {
                    birthDate = null;
                } else {
                    try {
                        SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
                        java.util.Date date = sdf1.parse(bDate);
                        birthDate = new java.sql.Date(date.getTime());
                    } catch (ParseException pe) {
                        System.out.println("Parse Exception at Birth Date: " + pe);
                    }
                }
            } else {
                error += "\nDate of Birth";
                errorCount++;
            }
            if (isSSNValid(ssn)) {
                if (ssn.equals("")) {
                    socialSN = "";
                } else {
                    socialSN = ssn.replaceAll("-", "");
                }
            } else {
                error += "\nSSN";
                errorCount++;
            }

            if (emergencyP.equals("")) {
                emContPhone = "";
            } else {
                emergencyP = emergencyP.replaceAll("[^0-9]", "");
                emContPhone = emergencyP;
            }
            if (isFullNameValid(emergencyN)) {
                emContName = emergencyN;
            } else {
                error += "\nName - Emergency Contact";
                errorCount++;
            }
            usVet = vet;
            race = r;
            ethnicity = eth;
            disability_con = dcon;
            insurance_con = ins;
            homeless_history = hlstat;
            length_stay_prior = len;

            if (isDateValid(hlDate)) {
                if (hlDate.equals("")) {
                    homeless_start = null;
                } else {
                    try {
                        SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
                        java.util.Date date = sdf1.parse(hlDate);
                        homeless_start = new java.sql.Date(date.getTime());
                    } catch (ParseException pe) {
                        System.out.println("Parse Exception at Homeless Start Date: " + pe);
                    }
                }
            } else {
                error += "\nHomelessness Start Date";
                errorCount++;
            }
            numOfTimes_homeless = timesh;
            house_status = houstat;
            if (isZipValid(lzip)) {
                last_zip = lzip;
            } else {
                error += "\nLast Known Zip Code";
                errorCount++;
            }
            coc_code = coc;
            if (isFullNameValid(counts)) {
                NC_county_serv = counts;
            } else {
                error += "\nNC County of Service";
                errorCount++;
            }
            if (isFullNameValid(countr)) {
                residentCounty = countr;
            } else {
                error += "\nCounty of Residence";
                errorCount++;
            }
            if (isFullNameValid(cityr)) {
                residentCity = cityr;
            } else {
                error += "\nCity of Residence";
                errorCount++;
            }
            String message = lastName + ", " + firstName + ", " + addressLn1 + ", " + addressLn2 + ", " + city + ", " + state + ", " + zip + ", " + phone + ", " + birthDate + ", " + socialSN + ", " + gender + ", " + phoneAlt + ", " + res_email + ", " + emContPhone + ", " + emContName + ", " + usVet + ", " + race + ", " + ethnicity + ", " + 0 + ", " + disability_con + ", " + "NULL" + ", " + insurance_con + ", " + "NULL" + ", " + homeless_history + ", " + length_stay_prior + ", " + homeless_start + ", " + house_status + ", " + last_zip + ", " + coc_code + ", " + NC_county_serv + ", " + residentCounty + ", " + residentCity + ", " +  numOfTimes_homeless;
            String nullValues = "Null Fields are: ";
            //TestOptionPane11 dbg = new TestOptionPane11(message);
            if (errorCount == 0) {
                try {
                    PreparedStatement ps = conn.prepareStatement("Update [dbo].[Resident] SET Last_Name = ?, First_Name = ?, Address = ?, AddressLine2 = ?, City = ?, State = ?, Zip_Code = ?, Phone = ?, Birth_Date = ?, SSN = ?, Gender = ?, Phone_Alternate = ?, Email = ?, Emergency_Contact_Phone = ?, Emergency_Contact_Name = ?, US_Military_Veteran_Status = ?, Race = ?, Ethnicity = ?, Current_Length_Of_Stay = ?, Does_Client_Have_a_Disabling_Condition = ?, Disability_Type = ?, Are_You_Covered_By_Insurance = ?, Health_Insurance_Type = ?, Homeless_History_Type = ?, Length_Of_Stay_In_Prior_Living_Situation = ?, Homeless_Start_Date = ?, Housing_Status = ?, Last_know_Zip_Code = ?, COC_Code = ?, NC_County_Of_Service = ?, County_Of_Residence = ?, City_Of_Residence = ?, Number_Of_Times_Homelss = ? WHERE Resident_ID = ?");
                    ps.setString(1, lastName); // Last_Name
                    ps.setString(2, firstName); // First_Name
                    if (addressLn1.equals("")) {
                        ps.setNull(3, java.sql.Types.VARCHAR);
                        nullValues += "\nAddress Line 1";
                    } else {
                        ps.setString(3, addressLn1); // Address
                    }
                    if (addressLn2.equals("")) {
                        ps.setNull(4, java.sql.Types.VARCHAR);
                        nullValues += "\nAddress Line 2";
                    } else {
                        ps.setString(4, addressLn2); // AddressLine2
                    }
                    if (city.equals("")) {
                        ps.setNull(5, java.sql.Types.VARCHAR);
                        nullValues += "\nCity";
                    } else {
                        ps.setString(5, city); // City
                    }
                    if (state.equals("")) {
                        ps.setNull(6, java.sql.Types.CHAR);
                        nullValues += "\nState";
                    } else {
                        ps.setString(6, state); // State
                    }
                    if (zip.equals("")) {
                        ps.setNull(7, java.sql.Types.VARCHAR);
                        nullValues += "\nZip Code";
                    } else {
                        ps.setString(7, zip); // Zip_Code
                    }
                    if (phone.equals("")) {
                        ps.setNull(8, java.sql.Types.CHAR);
                        nullValues += "\nPhone";
                    } else {
                        ps.setString(8, phone); // Phone
                    }
                    if (birthDate == null) {
                        ps.setNull(9, java.sql.Types.DATE);
                        nullValues += "\nBirth Date";
                    } else {
                        ps.setDate(9, birthDate);// Birth_Date
                    }
                    if (socialSN.equals("")) {
                        ps.setNull(10, java.sql.Types.NVARCHAR);
                        nullValues += "\nSSN";
                    } else {
                        ps.setString(10, socialSN); // SSN
                    }
                    ps.setString(11, gender); // Gender
                    if (phoneAlt.equals("")) {
                        ps.setNull(12, java.sql.Types.VARCHAR);
                        nullValues += "\nPhone Alternate";
                    } else {
                        ps.setString(12, phoneAlt); // Phone_Alternate
                    }
                    if (res_email.equals("")) {
                        ps.setNull(13, java.sql.Types.VARCHAR);
                        nullValues += "\nResident Email";
                    } else {
                        ps.setString(13, res_email); // resident email
                    }

                    if (emContPhone.equals("")) {
                        ps.setNull(14, java.sql.Types.VARCHAR);
                        nullValues += "\nEmergency Contact Phone";
                    } else {
                        ps.setString(14, emContPhone); // Emergency_Contact_Phone
                    }
                    if (emContName.equals("")) {
                        ps.setNull(15, java.sql.Types.VARCHAR);
                        nullValues += "\nEmergency Contact Name";
                    } else {
                        ps.setString(15, emContName); // Emergency_Contact_Name
                    }
                    ps.setString(16, usVet); // US_Military_Veteran_Status
                    ps.setString(17, race); // Race
                    ps.setString(18, ethnicity); // Ethnicity
                    ps.setInt(19, 0); // Current_Length_Of_Stay
                    ps.setString(20, disability_con); // Does_Client_Have_a_Disabling_Condition
                    ps.setNull(21, java.sql.Types.VARCHAR); // Disability_Type
                    nullValues += "\nDisability Type";
                    ps.setString(22, insurance_con); // Are_You_Covered_By_Insurance
                    ps.setNull(23, java.sql.Types.VARCHAR); // Health_Insurance_Type
                    nullValues += "\nHealth Insurance Type";
                    ps.setString(24, homeless_history); // Homeless_History_Type
                    ps.setString(25, length_stay_prior); // Length_Of_Stay_In_Prior_Living_Situation
                    if (homeless_start == null) {
                        ps.setNull(26, java.sql.Types.DATE);
                        nullValues += "\nHomeless Start Date";
                    } else {
                        ps.setDate(26, homeless_start); // Homeless_Start_Date
                    }
                    ps.setString(27, house_status); // Housing_Status
                    if (last_zip.equals("")) {
                        ps.setNull(28, java.sql.Types.VARCHAR);
                        nullValues += "\nLast Known Zip";
                    } else {
                        ps.setString(28, last_zip); // Last_know_Zip_Code
                    }
                    if (coc_code.equals("")) {
                        ps.setNull(29, java.sql.Types.VARCHAR);
                        nullValues += "\nCOC Code";
                    } else {
                        ps.setString(29, coc_code);// COC_Code
                    }
                    if (NC_county_serv.equals("")) {
                        ps.setNull(30, java.sql.Types.VARCHAR);
                        nullValues += "\nNC County of Service";
                    } else {
                        ps.setString(30, NC_county_serv); // NC_County_Of_Service
                    }
                    if (residentCounty.equals("")) {
                        ps.setNull(31, java.sql.Types.VARCHAR);
                        nullValues += "\nCounty of Residence";
                    } else {
                        ps.setString(31, residentCounty); // County_Of_Residence
                    }
                    if (residentCity.equals("")) {
                        ps.setNull(32, java.sql.Types.VARCHAR);
                        nullValues += "\nCity of Residence";
                    } else {
                        ps.setString(32, residentCity); // City_Of_Residence
                    }
                    ps.setString(33, numOfTimes_homeless); // Number_Of_Times_Homelss
                    ps.setInt(34, resID); // resident ID

                    //dbg = new TestOptionPane11(nullValues);
                    ps.executeUpdate();

                    //ResultSet tableKeys = ps.getGeneratedKeys();
                    //tableKeys.next();
                    //int residentKey = tableKeys.getInt(1);
                    //this.residentID = residentKey;
                    //TestOptionPane11 dbg = new TestOptionPane11("Resident Key is: " + residentID);

                } catch (SQLException ex) {
                    System.out.println( ex.getMessage());
                }
            } else {
                System.out.println("Invalid entries");
            }
        } else {
            System.out.println("This shelter can only accept males.  Please refer to another shelter.");
        }
    }

    public void AddDisability(Connection conn, String[] dis) {
        // create table entries for disabilities selected
        try {
            String[] dn = new String[dis.length];
            String sql = "SELECT [Disability_Name] FROM [dbo].[Resident_Disability_Option] WHERE [Disability_Description] = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs;

            for (int i = 0; i < dis.length; i++) {
                ps.setString(1, dis[i]);
                rs = ps.executeQuery();
                while (rs.next()){
                    dn[i] = rs.getString("Disability_Name");
                }
            }


            ps = conn.prepareStatement("INSERT into [dbo].[Resident_Disability_Type] ([Disability_Name],[Residentt_ID]) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);

            for (String d : dn) {
                ps.setString(1, d);
                ps.setInt(2, residentID);

                ps.executeUpdate();
            }

        } catch (SQLException ex) {
            System.out.println("Error Writing to Disability Table");
        }
    }

    public String[] getDisability(Connection conn) {
        // create table entries for disabilities selected

        try {
            String sql = "SELECT [Disability_Name] FROM [dbo].[Resident_Disability_Type] WHERE [Residentt_ID] = ?";


            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, residentID);

            ResultSet rs = ps.executeQuery();
            String[] dis = new String[rs.getRow()];
            rs.beforeFirst();
            for (String d : dis) {
                rs.next();
                d = rs.getString("Disability_Name");
            }
            return dis;

        } catch (SQLException ex) {
            System.out.println( "Error Writing to Disability Table");
            String[] dis = {"No Results"};
            return dis;
        }
    }

    public void AddInsurance(Connection conn, String[] ins) {
        // create table entries for insurances selected
        try {
            String[] dn = new String[ins.length];
            String sql = "SELECT [Insurance_Name] FROM [dbo].[Resident_Health_Insurance_Type_Option] WHERE [Insurance_Description] = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs;

            for (int i = 0; i < ins.length; i++) {
                ps.setString(1, ins[i]);
                rs = ps.executeQuery();
                while (rs.next()){
                    dn[i] = rs.getString("Insurance_Name");
                }
            }
            ps = conn.prepareStatement("INSERT into [dbo].[Resident_Health_Insurance_Type] ([Insurance_Name],[Resident_ID]) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);

            for (String d : dn) {
                ps.setString(1, d);
                ps.setInt(2, residentID);

                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            System.out.println("Error Writing to Insurance Table");
        }
    }
}
