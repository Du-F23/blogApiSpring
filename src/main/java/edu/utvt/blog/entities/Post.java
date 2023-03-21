package edu.utvt.blog.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
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
    private Categories categories;

    public Post(String title, String content, String links, Boolean status, User user, Categories categories){
        super();
        this.title = title;
        this.content = content;
        this.links = links;
        this.status = status;
        this.categories = categories;
        this.user = user;
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

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUsuario() {
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
                ", category=" + categories +
                '}';
    }
}
