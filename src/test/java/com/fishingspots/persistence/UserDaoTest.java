package com.fishingspots.persistence;

import com.fishingspots.entity.Spot;
import com.fishingspots.entity.User;
import com.fishingspots.test.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Class to carry out various tests on the dao methods.
 *
 * @author JeevaG
 */
public class UserDaoTest {

    //UserDao dao;
    GenericDao genericDao;
    private final Logger logger = LogManager.getLogger(this.getClass());


    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
     */
    @BeforeEach
    void setUp() {
        genericDao = new GenericDao(User.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        //dao = new UserDao();
    }

    /**
     * Verify successful retrieval of a User
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = (User) genericDao.getById(1);
        logger.debug("user info with id = 1: " + retrievedUser);
        assertEquals("Joe", retrievedUser.getFirstName());
        assertEquals("Coyne", retrievedUser.getLastName());
        assertEquals("jcoyne@gmail.com", retrievedUser.getEmail());
        assertEquals("supersecret1", retrievedUser.getPassword());
    }

    /**
     * Verify successful insert of a User
     */
    @Test
    void insertSuccess() {

        User newUser = new User("Sue", "Hamilton", "shamilton@gmail.com","secret7");
        int id = genericDao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = (User) genericDao.getById(id);
        logger.info("inserted user: " + insertedUser);
        //assertEquals("Sue", insertedUser.getFirstName());
        //assertEquals("Hamilton", insertedUser.getLastName());
        assertEquals(newUser, insertedUser);
    }

    /**
     * Verify successful insert of a User with a Spot
     */
    @Test
    void insertWithSpotSuccess() {

        User newUser = new User("Sue", "Hamilton", "shamilton@gmail.com","secret7");
        String spotName = "madison1";
        String city = "madison";
        String state = "WI";
        String zipCode = "53703";
        double lat = 43.066675;
        double lon = -89.386825;
        Spot spot = new Spot(spotName, city, state, zipCode, lat, lon, newUser);

        newUser.addSpot(spot);

        int id = genericDao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = (User) genericDao.getById(id);
        logger.info("inserted user with a spot: " + insertedUser + " // " + insertedUser.getSpots());
        assertEquals(newUser, insertedUser);
        assertEquals(spot.hashCode(), insertedUser.getSpots().hashCode());
        assertEquals(1, insertedUser.getSpots().size());
    }

    /**
     * Verify successful update of a User
     */
    @Test
    void updateSuccess() {
        String newLastName = "Stevenson";
        User userToUpdate = (User) genericDao.getById(2);
        userToUpdate.setLastName(newLastName);
        genericDao.saveOrUpdate(userToUpdate);
        User userAfterUpdate = (User) genericDao.getById(2);
        logger.info("new last name for user with id=2: " + userAfterUpdate.getLastName());
        assertEquals(newLastName, userAfterUpdate.getLastName());
    }

    /**
     * Verify successful delete of User
     */
    @Test
    void deleteSuccess() {
        genericDao.delete(genericDao.getById(2));
        logger.error("deleting user with id=2: " + genericDao.getById(2));
        assertNull(genericDao.getById(2));
    }

    /**
     * Verify successful retrieval of all Users
     */
    @Test
    void getAllSuccess() {
        List<User> users = genericDao.getAll();
        logger.info("users size should be 5: " + users.size());
        assertEquals(5, users.size());
    }
}