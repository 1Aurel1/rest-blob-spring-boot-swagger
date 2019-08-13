package com.aurelmarishta.restblog.user.article.reaction;

import com.aurelmarishta.restblog.user.User;
import com.aurelmarishta.restblog.user.article.Article;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;

@Entity(name="reactions")
public class Reaction {

    private final static String[] REACTIONS = {"Like", "Love", "Haha", "Yay", "Wow", "Sad", "Angry"};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private byte reaction;

    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinColumn(name = "article_id")
    //@JsonIgnore
    private Article article;

    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinColumn(name = "user_id")
    //@JsonIgnore
    private User user;

    public Reaction() {
    }

    public Reaction(byte reaction, Article article, User user) {
        this.reaction = reaction;
        this.article = article;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReaction() {
        switch (reaction) {
            case 0: {
                return "Undefinded";
            }
            case 1: {
                return "Like";
            }
            case 2: {
                return "Love";
            }
            case 3: {
                return "Haha";
            }
            case 4: {
                return "Yay";
            }
            case 5: {
                return "Wow";
            }
            case 6: {
                return "Sad";
            }
            case 7: {
                return "Angry";
            }
            default: {
                return "";
            }
        }
    }

    public void setReaction(byte reaction) {
        this.reaction = reaction;
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

    public static String[] getREACTIONS() {
        return REACTIONS;
    }

    @Override
    public String toString() {
        return "Reaction{" +
                "id=" + id +
                ", reaction=" + reaction +
                ", article=" + article +
                ", user=" + user +
                '}';
    }
}
