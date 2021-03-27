package com.example.app;

import java.util.List;
import java.util.Optional;

import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.mockito.*;
import org.testng.annotations.*;

import com.example.app.service.impl.ProductServiceImpl;
import com.example.app.repository.ProductRepository;
import com.example.app.util.TestData;
import com.example.app.entity.Product;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

public class ProductServiceTest extends AbstractTestNGSpringContextTests {

    @InjectMocks
    private ProductServiceImpl testTarget;

    @Mock
    private ProductRepository repository;

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "products")
    public void testFindAll(List<Product> expected) {

        doReturn(expected).when(repository).findAll();

        final var actual = testTarget.findAll();

        assertNotNull(actual);

        assertEquals(actual.size(), 3);

        verify(repository, atLeastOnce()).findAll();
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "product")
    public void testFindById(Product expected) {

        doReturn(Optional.of(expected)).when(repository).findById(any());

        final var actual = testTarget.findById(any());

        assertNotNull(actual);

        assertEquals(actual, expected);

        verify(repository, atLeastOnce()).findById(any());
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "product")
    public void testSave(Product product) {

        testTarget.save(product);

        verify(repository, atLeastOnce()).save(any());
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "product")
    public void testDelete(Product product) {

        testTarget.deleteById(product.getId());

        verify(repository, atLeastOnce()).deleteById(any());
    }
}