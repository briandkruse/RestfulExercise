package edu.matc.restdemo.entity;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "users")
public class User implements Serializable {

    private String login;
    private String firstName;
    private String lastName;

    // empty constructor
    public User() {}

    // with user variables
    public User(String firstName, String lastName, String login) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setLogin(login);
    }

    @Id
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "login", nullable = false)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "firstname", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "lastname", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) { this.lastName = lastName; }




    public String toString () {
        String userInformation =
                "First Name:" + this.firstName +
                        " Last Name: " + this.lastName +
                        " Login: " + this.login;
        return userInformation;
    }
}
