package com.fitnesscalc.meals;

import com.vladmihalcea.hibernate.type.array.IntArrayType;
import com.vladmihalcea.hibernate.type.array.ListArrayType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "meals")
@TypeDefs({
        @TypeDef(name = "list-array", typeClass = ListArrayType.class)
})
public class Meal {
    @Id
    @Column
    private Long id;

    @Column
    private Long userId;

    @Column
    private Date date;

    @Type(type = "list-array")
    @Column(
            name = "meal1", columnDefinition = "integer[]"
    )
    private List<Integer> meal1;

    @Type(type = "list-array")
    @Column(
            name = "meal2",
            columnDefinition = "integer[]"
    )
    private List<Integer> meal2;

    @Type(type = "list-array")
    @Column(
            name = "meal3",
            columnDefinition = "integer[]"
    )
    private List<Integer> meal3;

    @Type(type = "list-array")
    @Column(
            name = "meal4",
            columnDefinition = "integer[]"
    )
    private List<Integer> meal4;


    @Type(type = "list-array")
    @Column(
            name = "meal5",
            columnDefinition = "integer[]"
    )
    private List<Integer> meal5;

    public Meal() {

    }

    public Meal(Long id, Long user_id, Date date, List<Integer> meal1,
                List<Integer> meal2, List<Integer> meal3,
                List<Integer> meal4, List<Integer> meal5) {
        this.id = id;
        this.userId = user_id;
        this.date = date;
        this.meal1 = meal1;
        this.meal2 = meal2;
        this.meal3 = meal3;
        this.meal4 = meal4;
        this.meal5 = meal5;
    }

    public Long getId() {
        return id;
    }

    public List<Integer> getMeal1() {
        return meal1;
    }

    public void setMeal1(List<Integer> meal1) {
        this.meal1 = meal1;
    }

    public List<Integer> getMeal2() {
        return meal2;
    }

    public void setMeal2(List<Integer> meal2) {
        this.meal2 = meal2;
    }

    public List<Integer> getMeal3() {
        return meal3;
    }

    public void setMeal3(List<Integer> meal3) {
        this.meal3 = meal3;
    }

    public List<Integer> getMeal4() {
        return meal4;
    }

    public void setMeal4(List<Integer> meal4) {
        this.meal4 = meal4;
    }

    public List<Integer> getMeal5() {
        return meal5;
    }

    public void setMeal5(List<Integer> meal5) {
        this.meal5 = meal5;
    }

    public String getDate() {
//        DateFormat formatter = new SimpleDateFormat("yyyy-m-dd");
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
