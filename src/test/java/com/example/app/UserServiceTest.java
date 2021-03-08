package com.example.app;

import java.util.List;
import java.util.Optional;

import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.mockito.*;
import org.testng.annotations.*;

import com.example.app.service.impl.UserServiceImpl;
import com.example.app.repository.UserRepository;
import com.example.app.util.TestData;
import com.example.app.entity.User;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

public class UserServiceTest extends AbstractTestNGSpringContextTests {

    @InjectMocks
    private UserServiceImpl testTarget;

    @Mock
    private UserRepository repository;

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "users")
    public void testFindAll(List<User> expected) {

        doReturn(expected).when(repository).findAll();

        final var actual = testTarget.findAll();

        assertNotNull(actual);

        assertEquals(actual.size(), 3);

        verify(repository, atLeastOnce()).findAll();
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "user")
    public void testFindById(User expected) {

        doReturn(Optional.of(expected)).when(repository).findById(anyLong());

        final var actual = testTarget.findById(anyLong());

        assertNotNull(actual);

        assertEquals(actual, expected);

        verify(repository, atLeastOnce()).findById(anyLong());
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "user")
    public void testSave(User user) {

        testTarget.save(user);

        verify(repository, atLeastOnce()).save(any());
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "user")
    public void testDelete(User user) {

        testTarget.delete(user);

        verify(repository, atLeastOnce()).delete(any());
    }
}