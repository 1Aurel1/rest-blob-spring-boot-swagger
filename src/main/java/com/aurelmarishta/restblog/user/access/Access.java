package com.aurelmarishta.restblog.user.access;

import com.aurelmarishta.restblog.user.User;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Access {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade =  {
                    CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH
            }
    )
    @JoinColumn(name = "by_user_id")
    //@JsonIgnore
    private User byUser;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.DETACH
    )
    @JoinTable(
            name = "access_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "access_id")
    )
    //@JsonIgnore
    private List<User> toUsers;

    private String item;

    private long item_id;

    private String type;

    public Access() {
    }

    public Access(User byUser, List<User> toUsers, String item, long item_id, String type) {
        this.byUser = byUser;
        this.toUsers = toUsers;
        this.item = item;
        this.item_id = item_id;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getByUser() {
        return byUser;
    }

    public void setByUser(User byUser) {
        this.byUser = byUser;
    }

    public List<User> getToUsers() {
        return toUsers;
    }

    public void setToUsers(List<User> toUsers) {
        this.toUsers = toUsers;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public long getItem_id() {
        return item_id;
    }

    public void setItem_id(long item_id) {
        this.item_id = item_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Access{" +
                "id=" + id +
                ", byUser=" + byUser +
                ", toUsers=" + toUsers +
                ", item='" + item + '\'' +
                ", item_id=" + item_id +
                ", type='" + type + '\'' +
                '}';
    }
}
