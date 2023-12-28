package stu.cn.ua.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "supermarket")
public class SuperMarket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String address;
    @OneToMany(mappedBy = "supermarket")
    private List<Employee> employeeList;
    @OneToMany(mappedBy = "supermarket")
    private List<Product> productList;

    public SuperMarket(long id, String name, String address, List<Employee> employeeList, List<Product> productList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.employeeList = employeeList;
        this.productList = productList;
    }

    public SuperMarket() {

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "SuperMarket{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
