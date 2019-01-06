package com.github.paczarny.furnituremagazine.domain;

import javax.persistence.Entity;

@Entity
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

