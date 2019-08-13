package com.aurelmarishta.restblog.user.article.comment;

import com.aurelmarishta.restblog.user.User;
import com.aurelmarishta.restblog.user.article.Article;
import com.aurelmarishta.restblog.user.article.comment.meta.ArticleCommentMeta;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
public class ArticleComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @NotEmpty
    private String body;

    @OneToOne(mappedBy = "comment", fetch = FetchType.LAZY, optional = true, cascade = CascadeType.ALL)
    private ArticleCommentMeta meta;

    @ManyToOne(
            cascade = {
                    CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH
            },
            optional = false
    )
    @JoinColumn(name = "article_id")
    //@JsonIgnore
    private Article article;

    @ManyToOne(cascade = {
            CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
        },
        optional = false
    )
    @JoinColumn(name = "user_id")
    //@JsonIgnore
    private User user;

    public ArticleComment() {
    }

    public ArticleComment(@NotBlank @NotEmpty String body, ArticleCommentMeta meta, Article article, User user) {
        this.body = body;
        this.meta = meta;
        this.article = article;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public ArticleCommentMeta getMeta() {
        return meta;
    }

    public void setMeta(ArticleCommentMeta meta) {
        this.meta = meta;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ArticleComment{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", meta=" + meta +
                ", article=" + article +
                ", user=" + user +
                '}';
    }
}
