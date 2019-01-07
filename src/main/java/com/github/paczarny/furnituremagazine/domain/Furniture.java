package com.github.paczarny.furnituremagazine.domain;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Furniture {
    private String name;
    private double price;
    private Producer producer;
    private Style style;
    private Section section;
    private Catalog catalog;

    public Furniture() {
        this.style = new Style();
        this.producer = new Producer();
        this.section = new Section();
        this.catalog = new Catalog();
    }

    public Furniture(String name, double price, Producer producer, Style style, Section section, Catalog catalog) {
        this.name = name;
        this.price = price;
        this.producer = Objects.requireNonNullElseGet(producer, Producer::new);
        this.style = Objects.requireNonNullElseGet(style, Style::new);
        this.section = Objects.requireNonNullElseGet(section, Section::new);
        this.catalog = Objects.requireNonNullElseGet(catalog, Catalog::new);
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
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
}
