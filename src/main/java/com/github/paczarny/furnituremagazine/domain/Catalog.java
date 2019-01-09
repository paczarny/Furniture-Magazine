package com.github.paczarny.furnituremagazine.domain;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Embeddable
public class Catalog {
    @Transient
    private List<Furniture> furnitureList;
    private String name;

    public Catalog() { this.furnitureList = new ArrayList<>(); }

    public Catalog(String name) {
        this.furnitureList = new ArrayList<>();
        this.name=name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFurnitureList(List<Furniture> furnitureList) {
        this.furnitureList = furnitureList;
    }

    public String getName() {
        return name;
    }

    public List<Furniture> getFurnitureList() {
        return furnitureList;
    }

    public void addFurniture(Furniture furniture){
        this.furnitureList.add(furniture);
    }

    public void deleteFurniture(Furniture furniture){
        this.furnitureList.remove(furniture);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Catalog catalog = (Catalog) o;
        return Objects.equals(furnitureList, catalog.furnitureList) &&
                name.equals(catalog.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(furnitureList, name);
    }
}
