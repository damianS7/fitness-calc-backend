package com.fitnesscalc.profile;

import com.vladmihalcea.hibernate.type.array.IntArrayType;
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

@Entity
@Table(name = "meals")
@TypeDefs({
        @TypeDef(name = "int-array", typeClass = IntArrayType.class)
})
public class Meal {
    @Id
    @Column
    private Long id;

    @Column
    private Long profileId;

    @Column
    private Date date;

    @Type(type = "int-array")
    @Column(
            name = "meal1",
            columnDefinition = "integer[]"
    )
    private int[] meal1;

    @Type(type = "int-array")
    @Column(
            name = "meal2",
            columnDefinition = "integer[]"
    )
    private int[] meal2;

    @Type(type = "int-array")
    @Column(
            name = "meal3",
            columnDefinition = "integer[]"
    )
    private int[] meal3;

    @Type(type = "int-array")
    @Column(
            name = "meal4",
            columnDefinition = "integer[]"
    )
    private int[] meal4;


    @Type(type = "int-array")
    @Column(
            name = "meal5",
            columnDefinition = "integer[]"
    )
    private int[] meal5;

    public Meal() {

    }

    public Meal(Long id, Long profile_id, Date date, int[] meal1,
                int[] meal2, int[] meal3, int[] meal4 , int[] meal5) {
        this.id = id;
        this.profileId = profile_id;
        this.date = date;
        this.meal1 = meal1;
        this.meal2 = meal2;
        this.meal3 = meal3;
        this.meal4 = meal4;
        this.meal5 = meal5;
    }

    public int[] getMeal1() {
        return meal1;
    }

    public int[] getMeal2() {
        return meal2;
    }

    public int[] getMeal3() {
        return meal3;
    }

    public int[] getMeal4() {
        return meal4;
    }

    public int[] getMeal5() {
        return meal5;
    }

    public String getDate() {
//        DateFormat formatter = new SimpleDateFormat("yyyy-m-dd");
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }


}
