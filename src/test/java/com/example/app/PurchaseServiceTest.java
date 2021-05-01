package com.example.app;

import java.util.List;
import java.util.Optional;

import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.mockito.*;
import org.testng.annotations.*;

import com.example.app.service.impl.PurchaseServiceImpl;
import com.example.app.repository.PurchaseRepository;
import com.example.app.util.TestData;
import com.example.app.entity.Purchase;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

public class PurchaseServiceTest extends AbstractTestNGSpringContextTests {

    @InjectMocks
    private PurchaseServiceImpl testTarget;

    @Mock
    private PurchaseRepository repository;

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "purchases")
    public void testFindAll(List<Purchase> expected) {

        doReturn(expected).when(repository).findAll();

        final var actual = testTarget.findAll();

        assertNotNull(actual);

        assertEquals(actual.size(), 3);

        verify(repository, atLeastOnce()).findAll();
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "purchase")
    public void testFindById(Purchase expected) {

        doReturn(Optional.of(expected)).when(repository).findById(any());

        final var actual = testTarget.findById(any());

        assertNotNull(actual);

        assertEquals(actual, expected);

        verify(repository, atLeastOnce()).findById(any());
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "purchase")
    public void testSave(Purchase purchase) {

        testTarget.save(purchase);

        verify(repository, atLeastOnce()).save(any());
    }

    @Test(dataProviderClass = TestData.class, dataProvider = "purchase")
    public void testDelete(Purchase purchase) {

        testTarget.deleteById(purchase.getId());

        verify(repository, atLeastOnce()).deleteById(any());
    }
}