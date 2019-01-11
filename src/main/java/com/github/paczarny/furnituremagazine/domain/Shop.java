package com.github.paczarny.furnituremagazine.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Shop {
    @OneToMany
    private List<Section> sectionList;

    @ManyToOne
    private Address address;

    private String name;

    public Shop() {
        this.sectionList = new ArrayList<>();
    }

    public Shop(String name, List<Section> sectionList, Address address) {
        this.name = name;
        this.sectionList = Objects.requireNonNullElseGet(sectionList, ArrayList::new);
        this.address = address;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void addSection(Section section) {
        sectionList.add(section);
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
                name.equals(shop.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sectionList, name);
    }
}
