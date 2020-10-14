package edu.matc.persistence;

import edu.matc.entity.User;
//import edu.matc.entity.Book;
import edu.matc.test.util.Database;
//import edu.matc.testUtils.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Class to carry out various tests on the dao methods.
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
     * Verify successful insert of a User with a Book
     */
 /*   @Test
    void insertWithBookSuccess() {

        User newUser = new User("Sue", "Hamilton");
        String bookTitle = "Freshwater Fishing";
        String isbn = "978-1-62403-681-1";
        int year = 2014;
        Book book = new Book(bookTitle, isbn, year, newUser);

        newUser.addBook(book);

        int id = genericDao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = (User) genericDao.getById(id);
        logger.info("inserted user with book: " + insertedUser + " // " + insertedUser.getBooks());
        assertEquals(newUser, insertedUser);
        assertEquals(book.hashCode(), insertedUser.getBooks().hashCode());
        assertEquals(1, insertedUser.getBooks().size());
    } */

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