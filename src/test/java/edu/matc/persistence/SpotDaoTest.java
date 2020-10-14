package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.entity.Spot;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class to Instantiate the Dao and carry out various tests.
 */
class SpotDaoTest {
    private final Logger logger = LogManager.getLogger(this.getClass());
    //SpotDao spotDao;
    GenericDao genericDao;

    /**
     * Instantiates a new Dao and runs cleandb.sql
     */
    @BeforeEach
    void setUp() {
        //  spotDao = new SpotDao();
        genericDao = new GenericDao(Spot.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * test to verify the getByIDSuccess()
     */
    @Test
    void getByIdSuccess() {
        Spot spot = (Spot) genericDao.getById(2);
        assertNotNull(spot);
        logger.info("getById(2) test: " + spot);
        assertTrue("monona2".equals(spot.getSpotName()));
        assertTrue("monona".equals(spot.getCity()));
        assertTrue("WI".equals(spot.getState()));
        assertTrue("53716".equals(spot.getZipCode()));
        assertEquals(43.071923, spot.getLat());
        assertEquals(-89.333321, spot.getLon());
        assertEquals(1, spot.getUser().getId());
    }

    /**
     * test to verify saveOrUpdate() success
     */
    @Test
    void saveOrUpdate() {
        String newSpotName = "BySchluterBeach";
        Spot spot = (Spot) genericDao.getById(2);
        spot.setSpotName(newSpotName);
        genericDao.saveOrUpdate(spot);
        Spot retrievedSpot = (Spot) genericDao.getById(2);
        logger.info("update() test - updated record 1 : " + retrievedSpot);
        //assertEquals(newUser, retrievedSpot.getUser());
        // below method compares both the object values and this has been possible by adding overridden equals method in Spot
        assertEquals(newSpotName, retrievedSpot.getSpotName());
    }

    /**
     * test to verify insert() success
     */
    @Test
    void insertSuccess() {
        genericDao = new GenericDao(User.class);
        User user = (User) genericDao.getById(1);
        Spot newSpot = new Spot("madison1", "madison", "WI", "53703", 43.066675, -89.386825, user);
        user.addSpot(newSpot);
        genericDao = new GenericDao(Spot.class);
        int id = genericDao.insert(newSpot);
        assertNotEquals(0,id);
        Spot insertedSpot = (Spot) genericDao.getById(id);
        logger.info("insert() spot test - new record id: " + insertedSpot);
        assertEquals(newSpot, insertedSpot);
    }


    /**
     * test to verify getAll() success
     */
    @Test
    void getAll() {
        List<Spot> spots = genericDao.getAll();
        logger.info("getAll() test - total records in spot: " + spots.size());
        assertEquals(3, spots.size());
    }


    /**
     * test to verify delete() success
     */
    @Test
    void delete() {
        genericDao.delete(genericDao.getById(3));
        logger.error("deleted spot with id=3: " + genericDao.getById(3));
        assertNull(genericDao.getById(3));
    }
}