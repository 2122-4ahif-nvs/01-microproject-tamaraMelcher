package at.htl.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Table(name = "MP_LEAGUE")
@Entity
public class League {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "L_ID")
    private Long id;
    @NotNull(message="League has to have a difficulty")
    @Column(name = "L_DIFFICULTY")
    private Difficulty difficulty;
    @NotBlank(message="League has to be named")
    @Column(name = "L_NAME_OF_LEAGUE")
    private String nameOfLeague;
    @OneToMany(cascade = CascadeType.ALL)
    List<Climber> climbers;

    //region Constructor
    public League() {
    }

    public League(Difficulty difficulty, String nameOfLeague) {
        this.difficulty = difficulty;
        this.nameOfLeague = nameOfLeague;
    }

    @Override
    public String toString() {
        return String.format("%s", this.nameOfLeague);
    }
    //endregion Constructor


}
