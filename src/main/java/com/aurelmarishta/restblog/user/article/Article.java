package com.aurelmarishta.restblog.user.article;

import com.aurelmarishta.restblog.category.Category;
import com.aurelmarishta.restblog.tag.Tag;
import com.aurelmarishta.restblog.user.User;
import com.aurelmarishta.restblog.user.article.comment.ArticleComment;
import com.aurelmarishta.restblog.user.article.meta.ArticleMeta;
import com.aurelmarishta.restblog.user.article.reaction.Reaction;
import com.aurelmarishta.restblog.user.image.Image;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity(name = "articles")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    @NotBlank
    @NotNull
    private String title;

    @Lob
    @NotBlank
    @NotNull
    private String body;

    @NotBlank
    @NotNull
    private  String summary;

    @Column(unique = true)
    @NotBlank
    @NotNull
    private String slug;

    private long featuredImage;

    private long position;

    @Temporal(TemporalType.DATE)
    private Date created_at;

    @Temporal(TemporalType.DATE)
    private Date updated_at;

    @Temporal(TemporalType.DATE)
    private Date scheduledAt;

    private boolean authorised;

    private boolean enabled;

    private boolean is_featured;

    private boolean open_new_window;

    @OneToOne(mappedBy = "article",cascade = CascadeType.ALL)
    private ArticleMeta meta;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "user_id")
    //@JsonIgnore
    private User user;

    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinColumn(name = "category_id")
    //@JsonIgnore
    private Category category;

    @OneToMany(mappedBy = "article",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    //@JsonIgnore
    private List<ArticleComment> comments;

    @OneToMany(mappedBy = "article",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    //@JsonIgnore
    private List<Reaction> reactions;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH
            }
    )
    @JoinTable(
            name = "article_tag",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "article_id")
    )
    //@JsonIgnore
    private List<Tag> tags;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.DETACH
    )
    @JoinTable(
            name = "article_image",
            joinColumns = @JoinColumn(name = "image_id"),
            inverseJoinColumns = @JoinColumn(name = "article_id")
    )
    //@JsonIgnore
    private List<Image> images;

    public Article() {
    }

    public Article(@NotBlank @NotNull String title, @NotBlank @NotNull String body, @NotBlank @NotNull String summary, @NotBlank @NotNull String slug, long featuredImage, long position, Date created_at, Date updated_at, Date scheduledAt, boolean authorised, boolean enabled, boolean is_featured, boolean open_new_window, ArticleMeta meta, User user, Category category, List<ArticleComment> comments, List<Reaction> reactions, List<Tag> tags, List<Image> images) {
        this.title = title;
        this.body = body;
        this.summary = summary;
        this.slug = slug;
        this.featuredImage = featuredImage;
        this.position = position;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.scheduledAt = scheduledAt;
        this.authorised = authorised;
        this.enabled = enabled;
        this.is_featured = is_featured;
        this.open_new_window = open_new_window;
        this.meta = meta;
        this.user = user;
        this.category = category;
        this.comments = comments;
        this.reactions = reactions;
        this.tags = tags;
        this.images = images;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public long getFeaturedImage() {
        return featuredImage;
    }

    public void setFeaturedImage(long featuredImage) {
        this.featuredImage = featuredImage;
    }

    public long getposition() {
        return position;
    }

    public void setposition(long position) {
        this.position = position;
    }

    public Date getScheduledAt() {
        return scheduledAt;
    }

    public void setScheduledAt(Date scheduledAt) {
        this.scheduledAt = scheduledAt;
    }

    public boolean isAuthorised() {
        return authorised;
    }

    public void setAuthorised(boolean authorised) {
        this.authorised = authorised;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isIs_featured() {
        return is_featured;
    }

    public void setIs_featured(boolean is_featured) {
        this.is_featured = is_featured;
    }

    public boolean isOpen_new_window() {
        return open_new_window;
    }

    public void setOpen_new_window(boolean open_new_window) {
        this.open_new_window = open_new_window;
    }

    public ArticleMeta getMeta() {
        return meta;
    }

    public void setMeta(ArticleMeta meta) {
        this.meta = meta;
    }


    public long getPosition() {
        return position;
    }

    public void setPosition(long position) {
        this.position = position;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<ArticleComment> getComments() {
        return comments;
    }

    public void setComments(List<ArticleComment> comments) {
        this.comments = comments;
    }

    public List<Reaction> getReactions() {
        return reactions;
    }

    public void setReactions(List<Reaction> reactions) {
        this.reactions = reactions;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }


    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", summary='" + summary + '\'' +
                ", slug='" + slug + '\'' +
                ", featuredImage=" + featuredImage +
                ", position=" + position +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", scheduledAt=" + scheduledAt +
                ", authorised=" + authorised +
                ", enabled=" + enabled +
                ", is_featured=" + is_featured +
                ", open_new_window=" + open_new_window +
                ", meta=" + meta +
                ", user=" + user +
                ", category=" + category +
                ", comments=" + comments +
                ", reactions=" + reactions +
                ", tags=" + tags +
                ", images=" + images +
                '}';
    }
}

