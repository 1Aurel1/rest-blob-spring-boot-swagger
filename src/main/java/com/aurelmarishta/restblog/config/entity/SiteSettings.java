package com.aurelmarishta.restblog.config.entity;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class SiteSettings {

    @Id
    private String valueKey;

    private String value;

    public SiteSettings() {
    }

    public SiteSettings(String valueKey, String value) {
        this.valueKey = valueKey;
        this.value = value;
    }

    public String getValueKey() {
        return valueKey;
    }

    public void setValueKey(String valueKey) {
        this.valueKey = valueKey;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SiteSettings{" +
                "valueKey='" + valueKey + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
