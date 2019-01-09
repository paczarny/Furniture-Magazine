package com.github.paczarny.furnituremagazine.domain;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Shop {
    private List<Section> sectionList;
    private List<Catalog> catalogsList;
    private String name;

    public Shop() {
        this.sectionList = new ArrayList<>();
        this.catalogsList = new ArrayList<>();
    }

    public Shop(String name, List<Section> sectionList, List<Catalog> catalogsList){
        this.name=name;
        this.sectionList = Objects.requireNonNullElseGet(sectionList, ArrayList::new);
        this.catalogsList = Objects.requireNonNullElseGet(catalogsList, ArrayList::new);
    }


    public void setName(String name) {
        this.name = name;
    }

    public void addSection(Section section){
        sectionList.add(section);
    }

    public void addCatalog(Catalog catalog){
        catalogsList.add(catalog);
    }

    public List<Catalog> getCatalogsList() {
        return catalogsList;
    }

    public void setCatalogsList(List<Catalog> catalogsList) {
        this.catalogsList = catalogsList;
    }

    public void setSectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }

    public List<Section> getSectionList() {
        return sectionList;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return Objects.equals(sectionList, shop.sectionList) &&
                Objects.equals(catalogsList, shop.catalogsList) &&
                name.equals(shop.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sectionList, catalogsList, name);
    }
}
