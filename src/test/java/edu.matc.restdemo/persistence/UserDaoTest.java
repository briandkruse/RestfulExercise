package edu.matc.restdemo.persistence;

import edu.matc.restdemo.entity.User;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class UserDaoTest {

    UserDao userDao = new UserDao();
    User userTest;

    @Test
    public void getAllUsersTest() throws Exception {
        List<User> users = userDao.getAllUsers();
        assertTrue("Failed to get all users" + users.size(), users.size() > 0);
    }

    @Test
    public void getUserTest() throws Exception {
        userTest = new User("usertest", "usertest", "usertest");
        userDao.addUser(userTest);
        User user = userDao.getUser("usertest");
        assertNotNull("User usertest was not found", user);
        userDao.deleteUser("usertest");
    }

    @Test
    public void deleteUserTest() {
        User deleteTest = new User("deletetest", "deletetest", "deletetest");
        userDao.addUser(deleteTest);
        int initialUserCount = userDao.getAllUsers().size();
        userDao.deleteUser("deletetest");
        assertEquals("User was not deleted from the database", initialUserCount - 1, userDao.getAllUsers().size());
    }

}

