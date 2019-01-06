package com.github.paczarny.furnituremagazine.domain;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Section {
    private String name;
    private Address address;
    private List<Furniture> furnitureList;

    public Section() {
        this.address = new Address();
        this.furnitureList = new ArrayList<>();

    }

    public Section(String name, Address address, List<Furniture> furnitureList){
        this.name=name;
        furnitureList = new ArrayList<>();
        if(furnitureList!=null)
            this.furnitureList.addAll(furnitureList);
        if(address!=null)
            this.address=address;
        else this.address = new Address();
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFurnitureList(List<Furniture> furnitureList) {
        this.furnitureList = furnitureList;
    }

    public Address getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public List<Furniture> getFurnitureList() {
        return furnitureList;
    }
}
