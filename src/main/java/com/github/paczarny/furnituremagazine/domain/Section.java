package com.github.paczarny.furnituremagazine.domain;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Embeddable
public class Section {
    private String name;
    @Transient
    private List<Furniture> furnitureList;

    public Section() {
        this.furnitureList = new ArrayList<>();
    }

    public Section(String name){
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
}
