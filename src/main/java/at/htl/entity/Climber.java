package at.htl.entity;
import javax.persistence.*;

@Table(name = "MP_CLIMBER")
@Entity
public class Climber {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "C_ID")
    private Long id;
    @Column(name = "C_FIRST_NAME")
    private String firstName;
    @Column(name = "C_LAST_NAME")
    private String lastName;
    @Column(name = "C_AGE")
    private int age;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private League league;

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
