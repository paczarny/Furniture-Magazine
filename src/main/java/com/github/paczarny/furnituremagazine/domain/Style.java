package com.github.paczarny.furnituremagazine.domain;

public class Style {
    private String name;

    public Style() {}

    public Style(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
