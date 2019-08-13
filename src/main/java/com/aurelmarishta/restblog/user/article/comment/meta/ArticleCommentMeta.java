package com.aurelmarishta.restblog.user.article.comment.meta;

import com.aurelmarishta.restblog.user.article.comment.ArticleComment;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class ArticleCommentMeta {

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
    @JoinColumn(name = "comment_id")
    private ArticleComment comment;

    public ArticleCommentMeta() {
    }

    public ArticleCommentMeta(@NotBlank String metaKey, @NotBlank String metaValue, ArticleComment comment) {
        this.metaKey = metaKey;
        this.metaValue = metaValue;
        this.comment = comment;
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

    public ArticleComment getComment() {
        return comment;
    }

    public void setComment(ArticleComment comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "CommentMeta{" +
                "id=" + id +
                ", metaKey='" + metaKey + '\'' +
                ", metaValue='" + metaValue + '\'' +
                ", comment=" + comment +
                '}';
    }
}
