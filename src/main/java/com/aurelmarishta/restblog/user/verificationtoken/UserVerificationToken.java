package com.aurelmarishta.restblog.user.verificationtoken;

import com.aurelmarishta.restblog.user.User;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class UserVerificationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="token_id")
    private long tokenId;

    @Column(name="confirmation_token")
    private String confirmationToken;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "userId")
    private User user;

    public UserVerificationToken() {
    }

    public UserVerificationToken(User user) {
        this.user = user;
        createdDate = new Date();
        confirmationToken = UUID.randomUUID().toString();
    }

    public long getTokenid() {
        return tokenId;
    }

    public void setTokenid(long tokenid) {
        this.tokenId = tokenid;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ConfirmationToken [tokenid=" + tokenId + ", confirmationToken=" + confirmationToken + ", createdDate="
                + createdDate + ", user=" + user + "]";
    }

}
