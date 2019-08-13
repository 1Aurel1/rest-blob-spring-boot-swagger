package com.aurelmarishta.restblog.user.image;

import com.aurelmarishta.restblog.user.User;
import com.aurelmarishta.restblog.user.article.Article;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Entity(name="images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @NotEmpty
    private String url;

    private String name;

    private String type;

    private String size;

    private Date created_at;

    private Date updated_at;

    @ManyToOne(
            cascade = {
                    CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST,CascadeType.REFRESH
            },
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "user_id")
    //@JsonIgnore
    private User user;

    @ManyToMany(
            cascade = CascadeType.DETACH,
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "article_image",
            joinColumns = @JoinColumn(name="article_id"),
            inverseJoinColumns = @JoinColumn(name="image_id")
    )
    //@JsonIgnore
    private List<Article> articles;

    public Image() {
    }


}
