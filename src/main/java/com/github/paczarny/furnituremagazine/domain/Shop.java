package com.github.paczarny.furnituremagazine.domain;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Section> sectionList;
    private Address address;
    private String name;

    public Shop() {
        this.address=new Address();
        this.sectionList = new ArrayList<>();
    }

    public Shop(String name, Address address, List<Section> sectionList){
        sectionList = new ArrayList<>();
        if(sectionList!=null)
            this.sectionList.addAll(sectionList);
        if(address!=null)
            this.address=address;
        else this.address = new Address();
        this.name=name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

}
