package com.iins.modules.address;

import org.springframework.data.annotation.Id;

public class Address {

    @Id
    private String id;

    private String Address_Desc_line_1;
    private String Address_Desc_line_2;
    private String Address_Desc_line_3;
    private String City;
    private String Province;
    private String Country;
    private String PostalCode;
    private String LastUpdateTime;
    private String LastUpdateUser;
    private String Formatted;

    public Address(String Address_Desc_line_1, String Address_Desc_line_2,String Address_Desc_line_3,String City,String Province,String Country,String PostalCode) {
        this.Address_Desc_line_1 = Address_Desc_line_1;
        this.Address_Desc_line_2 = Address_Desc_line_2;
        this.Address_Desc_line_3 = Address_Desc_line_3;
        this.City =City;
        this.Province =Province;
        this.Country = Country;
        this.PostalCode = PostalCode;
        this.Formatted = Address_Desc_line_1 +Address_Desc_line_2+Address_Desc_line_3+", "+City +", "+Province+", "+Country+", "+PostalCode;
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