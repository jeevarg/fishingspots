package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Spot.
 *
 * @author JeevaG
 */
@Entity(name = "Spot")
@Table(name = "spot") // case sensitive!
public class Spot {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    private String spotName;
    private String city;
    private String state;
    private String zipCode;
    private double lat;
    private double lon;
//    private int userId;

    @ManyToOne
    private User user;

    /**
     * Instantiates a new Spot.
     */
    public Spot() {
    }

    /**
     * Instantiates a new Spot.
     *
     * @param spotName the spot name
     * @param city     the city
     * @param state    the state
     * @param zipCode  the zip code
     * @param lat      the lat
     * @param lon      the lon
     * @param user     the user
     */
    public Spot(String spotName, String city, String state, String zipCode, double lat, double lon, User user) {
        this.spotName = spotName;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.lat = lat;
        this.lon = lon;
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
     * Gets spot name.
     *
     * @return the spot name
     */
    public String getSpotName() {
        return spotName;
    }

    /**
     * Sets spot name.
     *
     * @param spotName the spot name
     */
    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets zip code.
     *
     * @return the zip code
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets zip code.
     *
     * @param zipCode the zip code
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Gets lat.
     *
     * @return the lat
     */
    public double getLat() {
        return lat;
    }

    /**
     * Sets lat.
     *
     * @param lat the lat
     */
    public void setLat(double lat) {
        this.lat = lat;
    }

    /**
     * Gets lon.
     *
     * @return the lon
     */
    public double getLon() {
        return lon;
    }

    /**
     * Sets lon.
     *
     * @param lon the lon
     */
    public void setLon(double lon) {
        this.lon = lon;
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
        return "Spot{" +
                "id=" + id +
                ", spotName='" + spotName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", user='" + user + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spot spot = (Spot) o;
        return id == spot.id &&
                Double.compare(spot.lat, lat) == 0 &&
                Double.compare(spot.lon, lon) == 0 &&
                Objects.equals(spotName, spot.spotName) &&
                Objects.equals(city, spot.city) &&
                Objects.equals(state, spot.state) &&
                Objects.equals(zipCode, spot.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, spotName, city, state, zipCode, lat, lon);
    }
}