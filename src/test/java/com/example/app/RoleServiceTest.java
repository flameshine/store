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

    @Autowired
    private RoleService service;

    @Test(dataProviderClass = TestData.class, dataProvider = "roles", priority = 1)
    public void testFindAll(Role role) {

        service.save(role);

        var databaseRoles = service.findAll();

        assertNotNull(databaseRoles);

        assertFalse(databaseRoles.isEmpty());

        assertTrue(databaseRoles.contains(role));
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "roles", priority = 2)
    public void testFindById(Role role) {

        service.save(role);

        var databaseRole = service.findById(role.getId());

        assertNotNull(databaseRole);

//      we need to compare this objects as a strings due to some hibernate data fetching features
        assertEquals(databaseRole.toString(), role.toString());
    }

    // TODO: find a good way to test service layer save() method.

    @Test(dataProviderClass = TestData.class, dataProvider = "roles", expectedExceptions = EntityNotFoundException.class, priority = 3)
    public void testDelete(Role role) {

        service.save(role);

        service.delete(role);

        service.findById(role.getId());

        fail();
    }
}