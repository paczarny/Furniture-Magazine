package com.github.paczarny.furnituremagazine.domain;

public class Producer {
    private String name;

    public Producer() {}

    public Producer(String  name) {
        this.name=name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

