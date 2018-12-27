package com.github.paczarny.furnituremagazine.domain;

import java.util.LinkedList;
import java.util.List;

public class Catalog {
    private List<Furniture> furnitureList;
    private String name;

    public Catalog() { this.furnitureList = new LinkedList<>(); }

    public Catalog(String name, List<Furniture> furnitureList) {
        this.furnitureList = new LinkedList<>();
        if(!(furnitureList==null))
            this.furnitureList.addAll(furnitureList);
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

}
