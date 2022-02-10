package at.htl.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NamedQueries({
        @NamedQuery(
                name = "Route.getAllRoutes",
                query = "select r from Route r"
        ),
        @NamedQuery(
                name = "Route.getRoutePerId",
                query = "select r from Route r where r.id = :ID"
        )
})

@Table(name = "MP_ROUTE")
@Entity
public class Route extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "R_ID")
    public Long id;

    @NotNull(message="Route has to have a name")
    @Column(name = "R_Name")
    public String name;

    @NotNull(message="Route has to have a colour")
    @Column(name = "R_COLOR")
    public String color;

    @NotNull(message="Route has to have status")
    @Column(name = "R_IS_FREE")
    public boolean isFree;

    @NotNull(message="League has to have a difficulty")
    @Column(name = "R_DIFFICULTY")
    public Difficulty difficulty;

    //region Constructor
    public Route() {
    }

    public Route(String name, String color, Difficulty difficulty, boolean isFree) {
        this.name = name;
        this.difficulty = difficulty;
        this.color = color;
        this.isFree = isFree;
    }
    //endregion Constructor


    @Override
    public String toString() {
        return String.format("%d: %s, %s, %b", this.id, this.color, this.difficulty, this.isFree);
    }
}
