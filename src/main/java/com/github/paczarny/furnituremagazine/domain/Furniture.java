package com.github.paczarny.furnituremagazine.domain;



public class Furniture {
    private String name;
    private double price;
    private Producer producer;
    private Style style;

    public Furniture() {
        this.style = new Style();
        this.producer = new Producer();
    }

    public Furniture(String name, double price, Producer producer, Style style) {
        this.name = name;
        this.price = price;
        if(producer!=null)
        this.producer=producer;
        else this.producer = new Producer();
        if(style!=null)
        this.style=style;
        else this.style=new Style();
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
