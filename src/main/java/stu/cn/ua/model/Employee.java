package stu.cn.ua.model;

import jakarta.persistence.*;
import org.apache.commons.lang3.RandomStringUtils;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String education;
    @Column(columnDefinition = "ENUM('Manager', 'Merchandiser', 'Cashier', 'Security', 'Cleaner', 'Loader')")
    @Enumerated(EnumType.STRING)
    private PostsENUM post;
    @ManyToOne
    @JoinColumn(name = "supermarket_id", referencedColumnName = "id")
    private SuperMarket supermarket;
    @Column(name = "password")
    private String password;

    public Employee(String name, String address, String education, PostsENUM post, SuperMarket supermarket) {
        this.name = name;
        this.address = address;
        this.education = education;
        this.post = post;
        this.supermarket = supermarket;
        newPassword();
    }

    public Employee() {

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

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public PostsENUM getPost() {
        return post;
    }

    public void setPost(PostsENUM post) {
        this.post = post;
    }

    public SuperMarket getSupermarket() {
        return supermarket;
    }

    public void setSupermarket(SuperMarket supermarket) {
        this.supermarket = supermarket;
    }

    public String getPassword() {
        return password;
    }

    public void newPassword() {
        this.password = RandomStringUtils.randomAlphanumeric(8);
    }
}
