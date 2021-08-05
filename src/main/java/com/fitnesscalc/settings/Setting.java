package com.fitnesscalc.settings;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "settings")
public class Setting {
    @Id
    @Column
    private String key;

    @Column
    private String value;

    @Column
    private Long userId;


    public Setting() {

    }

    public Setting(Long userId, String key, String value) {
        this.key = key;
        this.value = value;
        this.userId = userId;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getUserId() {
        return userId;
    }
}
