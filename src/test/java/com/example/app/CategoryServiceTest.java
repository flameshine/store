package com.example.app;

import java.util.List;

import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.mockito.*;
import org.testng.annotations.*;

import com.example.app.service.impl.CategoryServiceImpl;
import com.example.app.repository.CategoryRepository;
import com.example.app.entity.Category;
import com.example.app.util.TestData;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

public class CategoryServiceTest extends AbstractTestNGSpringContextTests {

    @InjectMocks
    private CategoryServiceImpl testTarget;

    @Mock
    private CategoryRepository repository;

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "categories")
    public void testFindAll(List<Category> expected) {

        doReturn(expected).when(repository).findAll();

        final var actual = testTarget.findAll();

        assertNotNull(actual);

        assertEquals(actual.size(), 3);

        verify(repository, atLeastOnce()).findAll();
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "category")
    public void testSave(Category category) {

        testTarget.save(category);

        verify(repository, atLeastOnce()).save(any());
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "category")
    public void testDelete(Category category) {

        testTarget.deleteById(category.getId());

        verify(repository, atLeastOnce()).deleteById(any());
    }
}