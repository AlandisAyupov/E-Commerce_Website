package com.ayupov.Bank.Item;

public class RequestItem {
  private int id;
  private String name;
  private String description;
  private double price;
  private String pictureId;
  private String pictureName;

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getPrice() {
    return this.price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getPictureId() {
    return this.pictureId;
  }

  public void setPictureId(int pictureId) {
    this.pictureId = pictureId;
  }

  public String getPictureName(String pictureName) {
    return this.pictureName;
  }

  public void setPictureName(String pictureName) {
    this.pictureName = pictureName;
  }

  @Override
  public String toString() {
    return this.id + " " + this.name + " " + this.description + " " + this.price + " " + this.pictureId;
  }
}
