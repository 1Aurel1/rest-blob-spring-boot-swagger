package com.aurelmarishta.restblog.user;

import com.aurelmarishta.restblog.user.access.Access;
import com.aurelmarishta.restblog.user.article.Article;
import com.aurelmarishta.restblog.user.article.comment.ArticleComment;
import com.aurelmarishta.restblog.user.article.reaction.Reaction;
import com.aurelmarishta.restblog.user.image.Image;
import com.aurelmarishta.restblog.user.role.Role;
import com.aurelmarishta.restblog.user.userprofile.UserProfile;
import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity(name = "users")
@ApiModel(description = "All details about the User. ")
public class User  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "")
    @NotNull
    private String username;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Temporal(TemporalType.DATE)
    private Date dataOfBirth;

    @Column(unique = true, nullable = false)
    @Email(message = "{email.invalid}")
    @NotBlank(message = "{email.notempty}")
    @NotNull
    private String email;

    @Column
    private boolean enabled;

    @Column
    private boolean accountNonExpired;

    @Column
    private boolean credentialsNonExpired;

    @Column
    private boolean accountNonLocked;

    @Column(nullable = false)
    @Size(min = 8, message = "{password.size}")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name = "role_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    //@JsonIgnore
    private List<Role> roles;


    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    //@JsonIgnore
    private UserProfile profile;

    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    //@JsonIgnore
    private List<Image> images;


    @OneToMany(
            mappedBy = "user",
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH
            }
    )
    //@JsonIgnore
    private List<Article> articles;

    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    //@JsonIgnore
    private List<ArticleComment> comments;

    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    //@JsonIgnore
    private List<Reaction> reactions;

    @OneToMany(
            mappedBy = "byUser",
            cascade = {
                    CascadeType.DETACH
            },
            fetch = FetchType.LAZY
    )
    //@JsonIgnore
    private List<Access> granted;

    @ManyToMany(
            cascade = CascadeType.DETACH,
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "access_user",
            joinColumns = @JoinColumn(name = "access_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    //@JsonIgnore
    private List<Access> accesses;

    public User() {
    }

    public User(@NotBlank(message = "") String username, @NotBlank String firstName, @NotBlank String lastName, Date dataOfBirth, @Email(message = "{email.invalid}") @NotBlank(message = "{email.notempty}") String email, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, @Size(min = 8, message = "{password.size}") String password, List<Role> roles, UserProfile profile, List<Image> images, List<Article> articles, List<ArticleComment> comments, List<Reaction> reactions, List<Access> granted, List<Access> accesses) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dataOfBirth = dataOfBirth;
        this.email = email;
        this.enabled = enabled;
        this.accountNonExpired = accountNonExpired;
        this.credentialsNonExpired = credentialsNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.password = password;
        this.roles = roles;
        this.profile = profile;
        this.images = images;
        this.articles = articles;
        this.comments = comments;
        this.reactions = reactions;
        this.granted = granted;
        this.accesses = accesses;
    }

    public User(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.enabled = user.isEnabled();
        this.accountNonExpired = user.isAccountNonExpired();
        this.credentialsNonExpired = user.isCredentialsNonExpired();
        this.accountNonLocked = user.isAccountNonLocked();
        this.roles = user.getRoles();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDataOfBirth() {
        return dataOfBirth;
    }

    public void setDataOfBirth(Date dataOfBirth) {
        this.dataOfBirth = dataOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public UserProfile getProfile() {
        return profile;
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
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

    public List<Access> getGranted() {
        return granted;
    }

    public void setGranted(List<Access> granted) {
        this.granted = granted;
    }

    public List<Access> getPermisions() {
        return accesses;
    }

    public void setPermisions(List<Access> accesses) {
        this.accesses = accesses;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dataOfBirth=" + dataOfBirth +
                ", email='" + email + '\'' +
                ", enabled=" + enabled +
                ", accountNonExpired=" + accountNonExpired +
                ", credentialsNonExpired=" + credentialsNonExpired +
                ", accountNonLocked=" + accountNonLocked +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", profile=" + profile +
                ", images=" + images +
                ", articles=" + articles +
                ", comments=" + comments +
                ", reactions=" + reactions +
                ", granted=" + granted +
                ", accesses=" + accesses +
                '}';
    }
}
