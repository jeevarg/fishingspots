package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Role.
 *
 * @author JeevaG
 */
@Entity(name = "Role")
@Table(name = "role") // case sensitive!
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    private String roleType;
    private String email;

    @ManyToOne
    @JoinColumn(name = "email",
            foreignKey = @ForeignKey(name = "role_user_email_fk")
    )
    private User user;

    /**
     * Instantiates a new Role.
     */
    public Role() {
    }

    /**
     * Instantiates a new Role.
     *
     * @param roleType the role type
     * @param email    email of the user
     * @param user     the user
     */
    public Role(User user, String email, String roleType) {
        this.roleType = roleType;
        this.email = email;
        this.user = user;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets role type.
     *
     * @return the role type
     */
    public String getRoleType() {
        return roleType;
    }

    /**
     * Sets role type.
     *
     * @param roleType the role type
     */
    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleType='" + roleType + '\'' +
                ", email='" + email + '\'' +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id == role.id &&
                Objects.equals(roleType, role.roleType) &&
                Objects.equals(email, role.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleType, email);
    }
}