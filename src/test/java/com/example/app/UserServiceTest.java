package com.example.app;

import javax.persistence.EntityNotFoundException;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.example.app.service.UserService;
import com.example.app.util.TestData;
import com.example.app.entity.User;

import static org.testng.Assert.*;

@SpringBootTest
@Transactional
public class UserServiceTest extends AbstractTestNGSpringContextTests {

    // TODO: prettify.

    @Autowired
    private UserService testTarget;

    @Test(dataProviderClass = TestData.class, dataProvider = "users", priority = 1)
    public void testSave(User user) {

        testTarget.save(user);

        var databaseUser = testTarget.findById(user.getId());

        assertNotNull(databaseUser);
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "users", priority = 2)
    public void testFindAll(User user) {

        var databaseUsers = testTarget.findAll();

        assertNotNull(databaseUsers);

        assertFalse(databaseUsers.isEmpty());

        assertTrue(databaseUsers.contains(user));
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "users", priority = 3)
    public void testFindById(User user) {

        var databaseUser = testTarget.findById(user.getId());

        assertNotNull(databaseUser);

//      we need to compare this objects as a strings due to some hibernate data fetching features
        assertEquals(databaseUser.toString(), user.toString());
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "users", expectedExceptions = EntityNotFoundException.class, priority = 4)
    public void testDelete(User user) {

        testTarget.delete(user);

        testTarget.findById(user.getId());

        fail();
    }
}