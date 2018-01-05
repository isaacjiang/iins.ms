package com.iins.modules.policy;

import org.springframework.data.annotation.Id;

public class Policy {

    @Id
    private String id;

    private String Insurance_Company_Code;
    private String Policy_Name;
    private String Policy_Decription;
    private String City;
    private String Province;
    private String Country;
    private String PostalCode;
    private String LastUpdateTime;
    private String LastUpdateUser;


    public Policy(String Insurance_Company_Code, String Policy_Name, String Policy_Decription, String City, String Province, String Country, String PostalCode) {
        this.Insurance_Company_Code = Insurance_Company_Code;
        this.Policy_Name = Policy_Name;
        this.Policy_Decription = Policy_Decription;
        this.City =City;
        this.Province =Province;
        this.Country = Country;
        this.PostalCode = PostalCode;

    }

    public String getLastUpdateTime() {
        return LastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        LastUpdateTime = lastUpdateTime;
    }

    public String getLastUpdateUser() {
        return LastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        LastUpdateUser = lastUpdateUser;
    }
}