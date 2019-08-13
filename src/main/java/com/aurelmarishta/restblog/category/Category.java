package com.aurelmarishta.restblog.category;

import com.aurelmarishta.restblog.user.article.Article;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity(name="comments")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @NotNull
    private String name;

    private int position;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    //@JsonIgnore
    private Category parent;

    @OneToMany(mappedBy =  "parent", cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    //@JsonIgnore
    private List<Category> subCategories;

    @OneToMany( mappedBy = "category",
            cascade = {
                CascadeType.DETACH, CascadeType.MERGE,
                CascadeType.PERSIST, CascadeType.REFRESH
            },
            fetch = FetchType.LAZY
    )
    //@JsonIgnore
    private List<Article> articles;


    public Category() {
    }

    public Category(@NotBlank @NotNull String name, int position, Category parent, List<Category> subCategories, List<Article> articles) {
        this.name = name;
        this.position = position;
        this.parent = parent;
        this.subCategories = subCategories;
        this.articles = articles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getposition() {
        return position;
    }

    public void setposition(int position) {
        this.position = position;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public List<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<Category> subCategories) {
        this.subCategories = subCategories;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position=" + position +
                ", parent=" + parent +
                ", subCategories=" + subCategories +
                ", articles=" + articles +
                '}';
    }
}
