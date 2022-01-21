package at.htl.entity;
import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Table(name = "MP_CLIMBER")
@Entity
@UserDefinition
public class Climber extends PanacheEntityBase {
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
    @Username
    @Column(name = "C_USERNAME")
    public String username;
    @Password
    @Column(name = "C_PASSWORD")
    public String password;
    @Roles
    @Column(name = "C_ROLE")
    public String role;
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

    public Climber(String firstName, String lastName, int age, String username, String password, String role) {
        this();
        this.username = username;
        this.password = BcryptUtil.bcryptHash(password);
        this.role = role;
    }

    public Climber(String firstName, String lastName, int age, League league, String username, String password, String role) {
        this();
        this.league = league;
    }
    //endregion

    @Override
    public String toString() {
        return String.format("%d: %s %s, %d, %s", this.id, this.lastName, this.firstName, this.age, this.league.toString());
    }
}
