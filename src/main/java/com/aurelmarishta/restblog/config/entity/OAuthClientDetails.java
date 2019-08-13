package com.aurelmarishta.restblog.config.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class OAuthClientDetails {

    @Id
    private String client_id;

    @NotNull
    private String client_secret;

    private String web_server_redirect_uri;

    private String scope;

    private short access_token_validity;

    private short refresh_token_validity;

    @Size(max = 1024)
    private String resource_ids;

    @Size(max = 1024)
    private String authorized_grant_types;

    @Size(max = 1024)
    private String authorities;

    @Size(max = 4096)
    private String additional_information;

    @Size(max = 255)
    private String autoapprove;

    public OAuthClientDetails() {
    }

    public OAuthClientDetails(String client_id, @NotNull String client_secret, String web_server_redirect_uri, String scope, short access_token_validity, short refresh_token_validity, @Size(max = 1024) String resource_ids, @Size(max = 1024) String authorized_grant_types, @Size(max = 1024) String authorities, @Size(max = 4096) String additional_information, @Size(max = 255) String autoapprove) {
        this.client_id = client_id;
        this.client_secret = client_secret;
        this.web_server_redirect_uri = web_server_redirect_uri;
        this.scope = scope;
        this.access_token_validity = access_token_validity;
        this.refresh_token_validity = refresh_token_validity;
        this.resource_ids = resource_ids;
        this.authorized_grant_types = authorized_grant_types;
        this.authorities = authorities;
        this.additional_information = additional_information;
        this.autoapprove = autoapprove;
    }

    public short getAccess_token_validity() {
        return access_token_validity;
    }

    public void setAccess_token_validity(short access_token_validity) {
        this.access_token_validity = access_token_validity;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getWeb_server_redirect_uri() {
        return web_server_redirect_uri;
    }

    public void setWeb_server_redirect_uri(String web_server_redirect_uri) {
        this.web_server_redirect_uri = web_server_redirect_uri;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public short getRefresh_token_validity() {
        return refresh_token_validity;
    }

    public void setRefresh_token_validity(short refresh_token_validity) {
        this.refresh_token_validity = refresh_token_validity;
    }

    public String getResource_ids() {
        return resource_ids;
    }

    public void setResource_ids(String resource_ids) {
        this.resource_ids = resource_ids;
    }

    public String getAuthorized_grant_types() {
        return authorized_grant_types;
    }

    public void setAuthorized_grant_types(String authorized_grant_types) {
        this.authorized_grant_types = authorized_grant_types;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public String getAdditional_information() {
        return additional_information;
    }

    public void setAdditional_information(String additional_information) {
        this.additional_information = additional_information;
    }

    public String getAutoapprove() {
        return autoapprove;
    }

    public void setAutoapprove(String autoapprove) {
        this.autoapprove = autoapprove;
    }

    @Override
    public String toString() {
        return "OAuthClientDetails{" +
                "client_id='" + client_id + '\'' +
                ", client_secret='" + client_secret + '\'' +
                ", web_server_redirect_uri='" + web_server_redirect_uri + '\'' +
                ", scope=" + scope +
                ", access_token_validity=" + access_token_validity +
                ", refresh_token_validity=" + refresh_token_validity +
                ", resource_ids='" + resource_ids + '\'' +
                ", authorized_grant_types='" + authorized_grant_types + '\'' +
                ", authorities='" + authorities + '\'' +
                ", additional_information='" + additional_information + '\'' +
                ", autoapprove='" + autoapprove + '\'' +
                '}';
    }
}
