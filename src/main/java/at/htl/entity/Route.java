package at.htl.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Table(name = "MP_ROUTE")
@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "R_ID")
    private Long id;
    @NotBlank(message="Route has to have a colour")
    @Column(name = "R_COLOR")
    private String color;
    @NotNull(message="Route has to have status")
    @Column(name = "R_IS_FREE")
    private boolean isFree;
    @NotNull(message="League has to have a difficulty")
    @Column(name = "R_DIFFICULTY")
    private Difficulty difficulty;

    //region Constructor
    public Route() {
    }

    public Route(String color, Difficulty difficulty, boolean isFree) {
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
