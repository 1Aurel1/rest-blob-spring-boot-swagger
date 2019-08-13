package com.aurelmarishta.restblog.user.userprofile;

import com.aurelmarishta.restblog.user.User;

import javax.persistence.*;

@Entity(name = "user_profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String education;

    private String website;

    private String country;

    private String city;

    private String street;


    @OneToOne(cascade = {
            CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinColumn(name = "user_id")
    private User user;

    public UserProfile() {
    }

    public UserProfile(String education, String website, String country, String city, String street, User user) {
        this.education = education;
        this.website = website;
        this.country = country;
        this.city = city;
        this.street = street;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
                ", education='" + education + '\'' +
                ", website='" + website + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", user=" + user +
                '}';
    }
}
