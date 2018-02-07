package com.iins.modules.quote;

import org.json.JSONObject;
import org.springframework.data.annotation.Id;

public class TravelInsuranceQuote {
    @Id
    private String id;
    private String typeOfTravel;
    private String destination;
    private String dateOfDeparture;
    private String dateOfReturn;
    private String coverageFor;

    public TravelInsuranceQuote() {}
    public TravelInsuranceQuote(String typeOfTravel,String destination,String dateOfDeparture,String dateOfReturn,String coverageFor) {
        this.typeOfTravel =typeOfTravel;
        this.destination = destination;
        this.dateOfDeparture = dateOfDeparture;
        this.dateOfReturn = dateOfReturn;
        this.coverageFor = coverageFor;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeOfTravel() {
        return typeOfTravel;
    }

    public void setTypeOfTravel(String typeOfTravel) {
        this.typeOfTravel = typeOfTravel;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(String dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    public String getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(String dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public String getCoverageFor() {
        return coverageFor;
    }

    public void setCoverageFor(String coverageFor) {
        this.coverageFor = coverageFor;
    }

    public JSONObject toJSON(){
        JSONObject trvQuote = new JSONObject();
        trvQuote.put("id",getId());
        trvQuote.put("typeOfTravel",getTypeOfTravel());
        trvQuote.put("destination",getDestination());
        trvQuote.put("dateOfDeparture",getDateOfDeparture());
        trvQuote.put("dateOfReturn",getDateOfReturn());
        trvQuote.put("coverageFor",getCoverageFor());

        return trvQuote;
    }

}