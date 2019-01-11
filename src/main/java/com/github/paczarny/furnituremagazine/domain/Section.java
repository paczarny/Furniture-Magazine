package com.github.paczarny.furnituremagazine.domain;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Embeddable
public class Section {
    private String name;

    @Embedded
    private List<Furniture> furnitureList;

    public Section(String name) {
        this.furnitureList = new ArrayList<>();
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return name.equals(section.name) &&
                Objects.equals(furnitureList, section.furnitureList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, furnitureList);
    }
}
