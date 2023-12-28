package stu.cn.ua.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "product")
public class Product {
    @Id
    private String id;
    @Column
    private String name;
    @Column
    private float price;
    @Column
    private Date expirationDate;
    @Column
    private int count;
    @ManyToOne
    @JoinColumn(name = "supermarket_id", referencedColumnName = "id")
    private SuperMarket supermarket;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    public Product(String id, String name, float price, Date expirationDate, int count, SuperMarket supermarket, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.expirationDate = expirationDate;
        this.count = count;
        this.supermarket = supermarket;
        this.category = category;
    }

    public Product() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public SuperMarket getSupermarket() {
        return supermarket;
    }

    public void setSupermarket(SuperMarket supermarket) {
        this.supermarket = supermarket;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", expirationDate=" + expirationDate +
                ", count=" + count +
                ", supermarket=" + supermarket +
                ", category=" + category.getName() +
                '}';
    }
}