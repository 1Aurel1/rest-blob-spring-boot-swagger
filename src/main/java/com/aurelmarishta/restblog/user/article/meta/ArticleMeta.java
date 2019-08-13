package com.aurelmarishta.restblog.user.article.meta;

import com.aurelmarishta.restblog.user.article.Article;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class ArticleMeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String metaKey;

    @NotBlank
    private String metaValue;


    @OneToOne(cascade = {
            CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinColumn(name = "article_id")
    private Article article;

    public ArticleMeta() {
    }

    public ArticleMeta(String metaKey, String metaValue, Article article) {
        this.metaKey = metaKey;
        this.metaValue = metaValue;
        this.article = article;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMetaKey() {
        return metaKey;
    }

    public void setMetaKey(String metaKey) {
        this.metaKey = metaKey;
    }

    public String getMetaValue() {
        return metaValue;
    }

    public void setMetaValue(String metaValue) {
        this.metaValue = metaValue;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "ArticleMeta{" +
                "id=" + id +
                ", metaKey='" + metaKey + '\'' +
                ", metaValue='" + metaValue + '\'' +
                ", article=" + article +
                '}';
    }
}
