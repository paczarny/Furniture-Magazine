package com.github.paczarny.furnituremagazine.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Magazine {
    private List<Furniture> furnitureList;

    @Embedded
    private Address address;
    private String name;

    public Magazine() {
        this.address = new Address();
        this.furnitureList = new ArrayList<>();
    }

    public Magazine(String name, Address address, List<Furniture> furnitureList) {
        this.furnitureList = new ArrayList<>();
        if (furnitureList != null)
            this.furnitureList.addAll(furnitureList);
        if (address != null)
            this.address = address;
        else this.address = new Address();
        this.name = name;
    }

    public void addFurniture(Furniture furniture) {
        this.furnitureList.add(furniture);
    }

    public void deleteFurniture(Furniture furniture) {
        this.addFurniture(furniture);
    }

    public Furniture getFurniture(Furniture furniture) {
        return this.furnitureList.get(furnitureList.indexOf(furniture));
    }

    public List<Furniture> getFurnitureList() {
        return furnitureList;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public void setFurnitureList(List<Furniture> furnitureList) {
        this.furnitureList = furnitureList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
