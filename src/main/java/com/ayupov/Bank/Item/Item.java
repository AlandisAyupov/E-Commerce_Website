package com.ayupov.Bank.Item;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

@Entity
public class Item {
  @Id
  @GeneratedValue
  @Column(name = "id", nullable = false, unique = true)
  private int id; 
  @Column(name = "name", nullable = false)
  private String name;
  @Column(name = "description", nullable = false)
  private String description;
  @Column(name = "price", nullable = false)
  private double price;
  @Column(name = "pictureId", nullable = false, unique = true)
  private String pictureId;
  public int getId()
  {
    return this.id;
  }
  public void setId(int id)
  {
    this.id = id;
  }
  public String getName()
  {
    return this.name;
  }
  public void setName(String name)
  {
    this.name = name;
  }
  public String getDescription()
  {
    return this.description;
  }
  public void setDescription(String description)
  {
    this.description = description;
  }
  public double getPrice()
  {
    return this.price;
  }
  public void setPrice(double price)
  {
    this.price = price;
  }
  public String getPictureId()
  {
    return this.pictureId;
  }
  public void setPictureId(String pictureId)
  {
    this.pictureId = pictureId;
  }
}
