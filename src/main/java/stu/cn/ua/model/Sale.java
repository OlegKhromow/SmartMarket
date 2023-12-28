package stu.cn.ua.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private Timestamp date;
    @Column
    private float cost;
    @Column(name = "productlist")
    private String products;
    @ManyToOne
    @JoinColumn(name = "supermarket_id", referencedColumnName = "id")
    private SuperMarket superMarket;

    public Sale(int id, Timestamp date, float cost, String products, SuperMarket superMarket) {
        this.id = id;
        this.date = date;
        this.cost = cost;
        this.products = products;
        this.superMarket = superMarket;
    }

    public Sale() {

    }

    public int getId() {
        return id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public SuperMarket getSuperMarket() {
        return superMarket;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", date=" + date +
                ", cost=" + cost +
                ", products='" + products + '\'' +
                ", superMarket=" + superMarket.getName() +
                '}';
    }
}
