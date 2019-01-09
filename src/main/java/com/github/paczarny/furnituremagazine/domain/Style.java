package com.github.paczarny.furnituremagazine.domain;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Style style = (Style) o;
        return name.equals(style.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
