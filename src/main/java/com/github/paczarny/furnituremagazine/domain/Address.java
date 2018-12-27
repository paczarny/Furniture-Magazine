package com.github.paczarny.furnituremagazine.domain;


public class Address {
    private String place;
    private String zipCode;
    private String country;
    private String houseNumber;
    private String apartmentNumber;
    private String street;

    public Address() {}

    public Address(String place, String zipCode, String country, String houseNumber, String apartmentNumber,String street) {
        this.apartmentNumber=apartmentNumber;
        this.country=country;
        this.houseNumber=houseNumber;
        this.place=place;
        this.street=street;
        this.zipCode=zipCode;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getCountry() {
        return country;
    }

    public String getPlace() {
        return place;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public String getStreet() {
        return street;
    }

}
