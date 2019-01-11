package com.github.paczarny.furnituremagazine.domain;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Magazine {
    @Embedded
    private List<Furniture> furnitureList;

    @ManyToOne(cascade = CascadeType.ALL)
    private Address address;

    private String name;

    public Magazine() {
        this.address = new Address();
        this.furnitureList = new ArrayList<>();
    }

    public Magazine(String name, Address address, List<Furniture> furnitureList) {
        this.furnitureList = Objects.requireNonNullElseGet(furnitureList, ArrayList::new);
        this.address = Objects.requireNonNullElseGet(address, Address::new);
        this.name = name;
    }

    public void addFurniture(Furniture furniture) {
        this.furnitureList.add(furniture);
    }

    public void deleteFurniture(Furniture furniture) {
        this.furnitureList.remove(furniture);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Magazine magazine = (Magazine) o;
        return Objects.equals(furnitureList, magazine.furnitureList) &&
                Objects.equals(address, magazine.address) &&
                name.equals(magazine.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(furnitureList, address, name);
    }
}
