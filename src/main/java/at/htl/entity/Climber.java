package at.htl.entity;
import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Table(name = "MP_CLIMBER")
@Entity
public class Climber extends PanacheEntityBase {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "C_ID")
    public Long id;
    @NotNull(message="Firstname may not be blank!")
    @Column(name = "C_FIRST_NAME")
    public String firstName;
    @NotNull(message="Lastname may not be blank!")
    @Column(name = "C_LAST_NAME")
    public String lastName;
    @NotNull(message="Age may not be blank!")
    @Min(message="Climber has to be older than 3 years", value=3)
    @Max(message="Climber has to be younger than 100 years", value=100)
    @Column(name = "C_AGE")
    public int age;
    //@Column(name = "C_USERNAME")
    //public String userName;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    public League league;

    //region Constructor
    public Climber() {
    }

    public Climber(String firstName, String lastName, int age, League league) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.league = league;
        //this.userName = firstName.toLowerCase() + lastName;
    }
    //endregion

    @Override
    public String toString() {
        return String.format("%d: %s %s, %d, %s", this.id, this.lastName, this.firstName, this.age, this.league.toString());
    }
}
