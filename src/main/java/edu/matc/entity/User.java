package edu.matc.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The type Author.
 */
@Entity(name = "User")
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    //@OneToMany(mappedBy = "userid", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    //private Set<Spot> spots = new HashSet<>();

    public User() {
    //    this.id = id;
    }

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        //this.spots = spots;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

/*    public Set<Spot> getSpots() {
        return spots;
    }

    public void setSpots(Set<Spot> spots) {
        this.spots = spots;
    }
*/

  /*  public void addSpot(Spot spot) {
        spots.add(spot);
        spot.setUser(this);
    }

    public void removeSpot(Spot spot) {
        spots.remove(spot);
        spot.setUser(null);
    }
*/

    @java.lang.Override
    public java.lang.String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        User user = (User) object;
        return id == user.id &&
                java.util.Objects.equals(firstName, user.firstName) &&
                java.util.Objects.equals(lastName, user.lastName) &&
                java.util.Objects.equals(email, user.email) &&
                java.util.Objects.equals(password, user.password);
    }

    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, password);
    }
}

