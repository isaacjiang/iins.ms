package com.iins.modules.customer;

import com.iins.modules.address.Address;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Customer {
    @Id
    private String id;
    private String Firstname;
    private String Lastname;
    private String Date_of_Birth;
    private String Gennder;

//    @DBRef
    private String Address;

    private String Cell_Phone_Number;
    private String Work_Phone_Number;
    private String Home_Phone_Number;
    private String Email;





    public Customer(String Firstname, String Lastname, String Date_of_Birth, String Gennder,String Address,String Cell_Phone_Number,String Work_Phone_Number,String Home_Phone_Number,String Email) {
        setFirstname(Firstname);
        setLastname(Lastname);
        setDate_of_Birth(Date_of_Birth);
        setGennder(Gennder);
    }

//    public Customer(String Firstname, String Lastname, String Date_of_Birth, String Gennder) {
//        setFirstname(Firstname);
//        setLastname(Lastname);
//        setDate_of_Birth(Date_of_Birth);
//        setGennder(Gennder);
//    }
    public String getId() {
        return id;
    }

    public void setId(String custId) {
        this.id = custId;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCell_Phone_Number() {
        return Cell_Phone_Number;
    }

    public void setCell_Phone_Number(String cell_Phone_Number) {
        Cell_Phone_Number = cell_Phone_Number;
    }

    public String getWork_Phone_Number() {
        return Work_Phone_Number;
    }

    public void setWork_Phone_Number(String work_Phone_Number) {
        Work_Phone_Number = work_Phone_Number;
    }

    public String getHome_Phone_Number() {
        return Home_Phone_Number;
    }

    public void setHome_Phone_Number(String home_Phone_Number) {
        Home_Phone_Number = home_Phone_Number;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getDate_of_Birth() {
        return Date_of_Birth;
    }

    public void setDate_of_Birth(String date_of_Birth) {
        Date_of_Birth = date_of_Birth;
    }

    public String getGennder() {
        return Gennder;
    }

    public void setGennder(String gennder) {
        Gennder = gennder;
    }
}