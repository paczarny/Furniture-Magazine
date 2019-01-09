package com.github.paczarny.furnituremagazine.domain;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producer producer = (Producer) o;
        return name.equals(producer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

