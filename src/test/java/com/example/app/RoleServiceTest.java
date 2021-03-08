package com.example.app;

import java.util.List;
import java.util.Optional;

import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.mockito.*;
import org.testng.annotations.*;

import com.example.app.service.impl.RoleServiceImpl;
import com.example.app.repository.RoleRepository;
import com.example.app.util.TestData;
import com.example.app.entity.Role;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

public class RoleServiceTest extends AbstractTestNGSpringContextTests {

    @InjectMocks
    private RoleServiceImpl testTarget;

    @Mock
    private RoleRepository repository;

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "roles")
    public void testFindAll(List<Role> expected) {

        doReturn(expected).when(repository).findAll();

        final var actual = testTarget.findAll();

        assertNotNull(actual);

        assertEquals(actual.size(), 3);

        verify(repository, atLeastOnce()).findAll();
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "role")
    public void testFindById(Role expected) {

        doReturn(Optional.of(expected)).when(repository).findById(anyLong());

        final var actual = testTarget.findById(anyLong());

        assertNotNull(actual);

        assertEquals(actual, expected);

        verify(repository, atLeastOnce()).findById(anyLong());
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "role")
    public void testSave(Role role) {

        testTarget.save(role);

        verify(repository, atLeastOnce()).save(any());
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "role")
    public void testDelete(Role role) {

        testTarget.delete(role);

        verify(repository, atLeastOnce()).delete(any(Role.class));
    }
}