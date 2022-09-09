package com.sept.abdulrahmanalanazi.rest.model;

public class Item {
    public Item(){
    }
    private String id;
    private String title;
    private String desc;
    private String imagePath;
    private double price;

    public Item(String id, String name, String desc,String imagePath, double price) {
        this.id = id;
        this.title = name;
        this.desc = desc;
        this.price = price;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String name) {
        this.title = name;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "item{" +
                "id='" + id + '\'' +
                ", name='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", price=" + price +
                '}';
    }
}
