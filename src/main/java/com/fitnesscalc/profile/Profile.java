package com.fitnesscalc.profile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @Column
    private Long id;

//    @Column(name = "user_id")
    @Column
    private Long userId;

    @Column
    private int age;

    @Column
    private int height;

//    private List<Weight> weights;

    public Profile() {

    }

    public Profile(Long id, Long user_id, int age, int height) {
        this.id = id;
        this.userId = user_id;
        this.age = age;
        this.height = height;
//        this.weights = weights;
    }

    /*public void setWeights(List<Weight> weights) {
        this.weights = weights;
    }

    public List<Weight> getWeights() {
        return weights;
    }*/

    public void setHeight(int height) {
        this.height = height;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

}
