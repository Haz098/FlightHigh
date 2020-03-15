package com.example.project;

public class ticket {

    String nameId;
    String ic;
    String customerName;
    String customerDestination;
    String customerDeparture;
    String customerSeats;
    String customerTypeClass;

    public ticket(){

    }

    public ticket(String nameId, String ic,  String customerName, String customerDestination, String customerDeparture, String customerSeats, String customerTypeClass) {
        this.nameId = nameId;
        this.ic = ic;
        this.customerName = customerName;
        this.customerDestination = customerDestination;
        this.customerDeparture = customerDeparture;
        this.customerSeats = customerSeats;
        this.customerTypeClass = customerTypeClass;
    }

    public String getNameId() {
        return nameId;
    }


    public String getCustomerName() {
        return customerName;
    }

    public String getIc(){
        return ic;
    }

    public String getCustomerDestination() {
        return customerDestination;
    }

    public String getCustomerDeparture() {
        return customerDeparture;
    }

    public String getCustomerSeats() {
        return customerSeats;
    }
    public String getCustomerTypeClass(){
        return customerTypeClass;
    }
}
