package com.github.paczarny.furnituremagazine.domain;


import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Address {
    private String city;
    private String zipCode;
    private String country;
    private String houseNumber;
    private String apartmentNumber;
    private String street;


    public Address() { }

    public Address(String city, String zipCode, String country, String houseNumber, String apartmentNumber, String street) {
        this.apartmentNumber = apartmentNumber;
        this.country = country;
        this.houseNumber = houseNumber;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }


    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setPlace(String place) {
        this.city = place;
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
        return city;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city) &&
                Objects.equals(zipCode, address.zipCode) &&
                Objects.equals(country, address.country) &&
                Objects.equals(houseNumber, address.houseNumber) &&
                Objects.equals(apartmentNumber, address.apartmentNumber) &&
                Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, zipCode, country, houseNumber, apartmentNumber, street);
    }
}
