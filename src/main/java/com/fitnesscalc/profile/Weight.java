package com.fitnesscalc.profile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "weights")
public class Weight {
    @Id
    @Column
    private Long id;

    @Column
    private Long profileId;

    @Column
    private Date date;

    @Column
    private float weight;

    public Weight() {

    }

    public Weight(Long id, Long profileId, Date date, float weight) {
        this.id = id;
        this.profileId = profileId;
        this.date = date;
        this.weight = weight;
    }

    public String getDate() {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }

    public float getWeight() {
        return weight;
    }
}
