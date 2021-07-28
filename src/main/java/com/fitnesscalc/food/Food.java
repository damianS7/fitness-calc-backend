package com.fitnesscalc.food;


import com.vladmihalcea.hibernate.type.array.IntArrayType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;

@Entity
@Table(name="foods")
@TypeDefs({
    @TypeDef(name = "int-array", typeClass = IntArrayType.class)
})
public class Food {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Type(type = "int-array")
    @Column(
        name = "ingredients",
        columnDefinition = "integer[]"
    )
    private int[] ingredients;

    public Food() {}

    public Food(Long id, String name, int[] ingredients) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int[] getIngredients() {
        return ingredients;
    }
}
