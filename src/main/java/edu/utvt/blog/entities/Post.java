package edu.utvt.blog.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
@Table(name = "post")
public class Post implements Serializable {
    @Serial
    private static final long serialVersionUID = -992378481586392219L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "links")
    private String links;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Categories category;

    public Post(String title, String content, String links, Boolean status, User user_id, Categories category_id){
        super();
        this.title = title;
        this.content = content;
        this.links = links;
        this.status = status;
        this.user= user_id;
        this.category = category_id;
    }

    public Post() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public String getLinks() {
        return links;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setCategory(Categories categories) {
        this.category = categories;
    }

    public Categories getCategory() {
        return category;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Publicaciones{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", links='" + links + '\'' +
                ", status=" + status +
                ", user=" + user +
                ", category=" + category +
                '}';
    }
}
