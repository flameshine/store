package com.example.app;

import java.util.List;

import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.mockito.*;
import org.testng.annotations.*;

import com.example.app.service.impl.RoleServiceImpl;
import com.example.app.repository.RoleRepository;
import com.example.app.entity.Role;
import com.example.app.util.TestData;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

public class RoleServiceTest extends AbstractTestNGSpringContextTests {

    // All tests temporarily disabled and will be replaced with the special Spring Boot tests.

    @InjectMocks
    private RoleServiceImpl testTarget;

    @Mock
    private RoleRepository repository;

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test(enabled = false, dataProviderClass = TestData.class, dataProvider = "roles")
    public void testFindAll(List<Role> expected) {

        doReturn(expected).when(repository).findAll();

        var actual = testTarget.findAll();

        assertNotNull(actual);

        assertEquals(actual.size(), 3);

        verify(repository, atLeastOnce()).findAll();
    }

    @Test(enabled = false, dataProviderClass = TestData.class, dataProvider = "role")
    public void testSave(Role role) {

        testTarget.save(role);

        verify(repository, atLeastOnce()).save(any());
    }

    @Test(enabled = false, dataProviderClass = TestData.class, dataProvider = "role")
    public void testDelete(Role role) {

        testTarget.deleteById(role.getId());

        verify(repository, atLeastOnce()).deleteById(any());
    }
}