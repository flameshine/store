package com.example.app;

import javax.persistence.EntityNotFoundException;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.example.app.service.RoleService;
import com.example.app.util.TestData;
import com.example.app.entity.Role;

import static org.testng.Assert.*;

@SpringBootTest
@Transactional
public class RoleServiceTest extends AbstractTestNGSpringContextTests {

    // TODO: prettify.

    @Autowired
    private RoleService testTarget;

    @Test(dataProviderClass = TestData.class, dataProvider = "roles", priority = 1)
    public void testSave(Role role) {

        testTarget.save(role);

        final var databaseRole = testTarget.findById(role.getId());

        assertNotNull(databaseRole);
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "roles", priority = 2)
    public void testFindAll(Role role) {

        final var databaseRoles = testTarget.findAll();

        assertNotNull(databaseRoles);

        assertFalse(databaseRoles.isEmpty());

        assertTrue(databaseRoles.contains(role));
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "roles", priority = 3)
    public void testFindById(Role role) {

        final var databaseRole = testTarget.findById(role.getId());

        assertNotNull(databaseRole);

//      we need to compare this objects as a strings due to some hibernate data fetching features
        assertEquals(databaseRole.toString(), role.toString());
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "roles", expectedExceptions = EntityNotFoundException.class, priority = 4)
    public void testDelete(Role role) {

        testTarget.delete(role);

        testTarget.findById(role.getId());

        fail();
    }
}