package stu.cn.ua.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Product> productList;

    public Category(String name, List<Product> productList) {
        this.name = name;
        this.productList = productList;
    }

    public Category() {

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductList() {
        return productList;
    }

}
