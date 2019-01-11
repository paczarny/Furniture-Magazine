package com.github.paczarny.furnituremagazine.domain;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Embeddable
public class Furniture {
    private String name;
    private double price;

    @ManyToOne
    private Producer producer;

    @ManyToOne
    private Style style;

    public Furniture() {
        this.style = new Style();
        this.producer = new Producer();
    }

    public Furniture(String name, double price, Producer producer, Style style, Section section, Catalog catalog) {
        this.name = name;
        this.price = price;
        this.producer = Objects.requireNonNullElseGet(producer, Producer::new);
        this.style = Objects.requireNonNullElseGet(style, Style::new);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Producer getProducer() {
        return producer;
    }

    public Style getStyle() {
        return style;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Furniture furniture = (Furniture) o;
        return Double.compare(furniture.price, price) == 0 &&
                name.equals(furniture.name) &&
                Objects.equals(producer, furniture.producer) &&
                Objects.equals(style, furniture.style);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, producer, style);
    }
}
