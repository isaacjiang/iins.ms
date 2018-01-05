package com.iins.modules.insurance_company;


import org.springframework.data.annotation.Id;

public class InsuranceCompany {

    @Id
    private String id;

    private String Insurance_Company_Code;
    private String Name_Of_Insurance_Company;
    private String Office_Address1_Of_Insurance_Company;
    private String Website_Of_Insurance_Company;
    private String President_Of_Insurance_Company;
    private String Phone_Number;
    private String Email_Address;
    private String Email_Address_2;
    private String Authorization_Tag;
    private String Depository_Bank;
    private String Depository_Bank_Account_Type;
    private String Share_In_Premium_Payment_Type;
    private String Account_Creation_Date;
    private String Account_Creation_Author;
    private String Remarks_on_Account_Updates;

    public InsuranceCompany(String Insurance_Company_Code, String Name_Of_Insurance_Company) {
        this.Insurance_Company_Code = Insurance_Company_Code;
        this.Name_Of_Insurance_Company = Name_Of_Insurance_Company;
    }


    public String getInsurance_Company_Code() {
        return Insurance_Company_Code;
    }

    public void setInsurance_Company_Code(String insurance_Company_Code) {
        Insurance_Company_Code = insurance_Company_Code;
    }

    public String getName_Of_Insurance_Company() {
        return Name_Of_Insurance_Company;
    }

    public void setName_Of_Insurance_Company(String name_Of_Insurance_Company) {
        Name_Of_Insurance_Company = name_Of_Insurance_Company;
    }

    public String getOffice_Address1_Of_Insurance_Company() {
        return Office_Address1_Of_Insurance_Company;
    }

    public void setOffice_Address1_Of_Insurance_Company(String office_Address1_Of_Insurance_Company) {
        Office_Address1_Of_Insurance_Company = office_Address1_Of_Insurance_Company;
    }

    public String getWebsite_Of_Insurance_Company() {
        return Website_Of_Insurance_Company;
    }

    public void setWebsite_Of_Insurance_Company(String website_Of_Insurance_Company) {
        Website_Of_Insurance_Company = website_Of_Insurance_Company;
    }

    public String getPresident_Of_Insurance_Company() {
        return President_Of_Insurance_Company;
    }

    public void setPresident_Of_Insurance_Company(String president_Of_Insurance_Company) {
        President_Of_Insurance_Company = president_Of_Insurance_Company;
    }

    public String getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        Phone_Number = phone_Number;
    }

    public String getEmail_Address() {
        return Email_Address;
    }

    public void setEmail_Address(String email_Address) {
        Email_Address = email_Address;
    }

    public String getEmail_Address_2() {
        return Email_Address_2;
    }

    public void setEmail_Address_2(String email_Address_2) {
        Email_Address_2 = email_Address_2;
    }

    public String getAuthorization_Tag() {
        return Authorization_Tag;
    }

    public void setAuthorization_Tag(String authorization_Tag) {
        Authorization_Tag = authorization_Tag;
    }

    public String getAccount_Creation_Date() {
        return Account_Creation_Date;
    }

    public void setAccount_Creation_Date(String account_Creation_Date) {
        Account_Creation_Date = account_Creation_Date;
    }

    public String getAccount_Creation_Author() {
        return Account_Creation_Author;
    }

    public void setAccount_Creation_Author(String account_Creation_Author) {
        Account_Creation_Author = account_Creation_Author;
    }

    public String getRemarks_on_Account_Updates() {
        return Remarks_on_Account_Updates;
    }

    public void setRemarks_on_Account_Updates(String remarks_on_Account_Updates) {
        Remarks_on_Account_Updates = remarks_on_Account_Updates;
    }

    public String getDepository_Bank() {
        return Depository_Bank;
    }

    public void setDepository_Bank(String depository_Bank) {
        Depository_Bank = depository_Bank;
    }

    public String getDepository_Bank_Account_Type() {
        return Depository_Bank_Account_Type;
    }

    public void setDepository_Bank_Account_Type(String depository_Bank_Account_Type) {
        Depository_Bank_Account_Type = depository_Bank_Account_Type;
    }

    public String getShare_In_Premium_Payment_Type() {
        return Share_In_Premium_Payment_Type;
    }

    public void setShare_In_Premium_Payment_Type(String share_In_Premium_Payment_Type) {
        Share_In_Premium_Payment_Type = share_In_Premium_Payment_Type;
    }
}