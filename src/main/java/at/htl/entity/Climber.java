package at.htl.entity;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@NamedQueries({
        @NamedQuery(
                name = "Climber.getAllClimbers",
                query = "select c from Climber c"
        )
})

@Table(name = "MP_CLIMBER")
@Entity
public class Climber {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "C_ID")
    public Long id;
    @NotBlank(message="Firstname may not be blank!")
    @Column(name = "C_FIRST_NAME")
    public String firstName;
    @NotBlank(message="Lastname may not be blank!")
    @Column(name = "C_LAST_NAME")
    public String lastName;
    @NotBlank(message="Age may not be blank!")
    @Min(message="Climber has to be older than 3 years", value=3)
    @Max(message="Climber has to be younger than 100 years", value=100)
    @Column(name = "C_AGE")
    public int age;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    public League league;

    //region Constructor
    public Climber() {
    }

    public Climber(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Climber(String firstName, String lastName, int age, League league) {
    this();
        this.league = league;
    }
    //endregion

    @Override
    public String toString() {
        return String.format("%d: %s %s, %d, %s", this.id, this.lastName, this.firstName, this.age, this.league.toString());
    }
}
