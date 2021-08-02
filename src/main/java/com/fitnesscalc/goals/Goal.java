package com.fitnesscalc.goals;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "goals")
public class Goal {
    @Id
    @Column
    private Long id;

    @Column
    private Long userId;

    @Column
    private int kcal;

    @Column
    private int proteins;

    @Column
    private int carbohydrates;

    @Column
    private int fats;

    public Goal() {

    }

    public Goal(Long id, Long user_id, int kcal, int proteins, int carbohydrates, int fats) {
        this.id = id;
        this.userId = user_id;
        this.proteins = proteins;
        this.carbohydrates = carbohydrates;
        this.fats = fats;
        this.kcal = kcal;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public int getProteins() {
        return proteins;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public int getFats() {
        return fats;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }
}
