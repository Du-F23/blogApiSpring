package edu.utvt.blog.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.io.*;

@Entity
@Data
@Table(name = "users")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID=-1156945731802631833L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name", nullable=false)
    private String name;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name="password", nullable=false)
    private String password;

    public User(String name, String email, String password){
        super();
        this.name = name;
        this.email = email;
        this.password = password;
    }


    public User() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
