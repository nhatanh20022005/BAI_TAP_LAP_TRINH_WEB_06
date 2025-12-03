package vn.iotstar.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class User {

    @Id
    private String username;

    private String password;
    private String phone;
    private String fullname;
    private String email;
    private boolean admin;
    private boolean active;
    private String images;

    @ManyToMany
    @JoinTable(
            name="User_Category",
            joinColumns = @JoinColumn(name="username"),
            inverseJoinColumns = @JoinColumn(name="categoryId")
    )
    private List<Category> categories;
}

