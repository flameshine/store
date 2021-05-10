package com.example.app.util;

import java.util.*;
import java.math.BigDecimal;

import org.testng.annotations.DataProvider;

import com.example.app.entity.*;

/**
 * Class that provides test data.
 */

public final class TestData {

    private static final String EMPTY = "";

    private TestData() {}

    @DataProvider(name = "users")
    public static Object[][] users() {
        return new Object[][] {
                {
                    List.of(new User(1L, "name1", "email1@test", "password1", null, "firstname1", "lastname1", true, new Role()), new User(2L, "name2", "email2@test", "password2", null, "firstname2", "lastname2", true, new Role()), new User(3L, "name3", "email3@test", "password3", null, "firstname3", "lastname3", true, new Role()))
                },
                {
                    List.of(new User(), new User(), new User())
                },
                {
                    List.of(new User(null, EMPTY, EMPTY, EMPTY, null, EMPTY, EMPTY, null, null), new User(null, EMPTY, EMPTY, EMPTY, null, EMPTY, EMPTY, null, null), new User(null, EMPTY, EMPTY, EMPTY, null, EMPTY, EMPTY, null, null))
                },
        };
    }

    @DataProvider(name = "roles")
    public static Object[][] roles() {
        return new Object[][] {
                {
                    List.of(new Role(1L, "name1"), new Role(2L, "name2"), new Role(3L, "name3"))
                },
                {
                    List.of(new Role(), new Role(), new Role())
                },
                {
                    List.of(new Role(null, EMPTY), new Role(null, EMPTY), new Role(null, EMPTY))
                },
        };
    }

    @DataProvider(name = "products")
    public static Object[][] products() {
        return new Object[][] {
                {
                    List.of(new Product(1L, "name1", BigDecimal.ZERO, new Date(), new Date(), 0, 0, new Category(), List.of()), new Product(2L, "name2", BigDecimal.ZERO, new Date(), new Date(), 0, 0, new Category(), List.of()), new Product(3L, "name3", BigDecimal.ZERO, new Date(), new Date(), 0, 0, new Category(), List.of()))
                },
                {
                    List.of(new Product(), new Product(), new Product())
                },
                {
                    List.of(new Product(null, EMPTY, null, null, null, 0, 0, null, null), new Product(null, EMPTY, null, null, null, 0, 0, null, null), new Product(null, EMPTY, null, null, null, 0, 0, null, null))
                },
        };
    }

    @DataProvider(name = "categories")
    public static Object[][] categories() {
        return new Object[][] {
                {
                    List.of(new Category(1L, "name1"), new Category(2L, "name2"), new Category(3L, "name3"))
                },
                {
                    List.of(new Category(), new Category(), new Category())
                },
                {
                    List.of(new Category(null, EMPTY), new Category(null, EMPTY), new Category(null, EMPTY))
                },
        };
    }

    @DataProvider(name = "purchases")
    public static Object[][] purchases() {
        return new Object[][] {
                {
                    List.of(new Purchase(1L, PurchaseStatus.REGISTERED, new User(), List.of()), new Purchase(2L, PurchaseStatus.REGISTERED, new User(), List.of()), new Purchase(3L, PurchaseStatus.REGISTERED, new User(), List.of()))
                },
                {
                    List.of(new Purchase(), new Purchase(), new Purchase())
                },
                {
                    List.of(new Purchase(null, null, null, null), new Purchase(null, null, null, null), new Purchase(null, null, null, null))
                },
        };
    }

    @DataProvider(name = "user")
    public static Object[][] user() {
        return new Object[][] {
                {
                    new User(0L, "name", "email@test", "password", null, "firstname", "lastname", true, new Role())
                },
                {
                    new User()
                },
                {
                    new User(null, EMPTY, EMPTY, EMPTY, null, EMPTY, EMPTY, null, null)
                },
        };
    }

    @DataProvider(name = "role")
    public static Object[][] role() {
        return new Object[][] {
                {
                    new Role(0L, "name")
                },
                {
                    new Role()
                },
                {
                    new Role(null, EMPTY)
                },
        };
    }

    @DataProvider(name = "product")
    public static Object[][] product() {
        return new Object[][] {
                {
                    new Product(0L, "name", BigDecimal.ZERO, new Date(), new Date(), 0, 0, new Category(), List.of())
                },
                {
                    new Product()
                },
                {
                    new Product(null, "", null, null, null, 0, 0, null, null)
                },
        };
    }

    @DataProvider(name = "category")
    public static Object[][] category() {
        return new Object[][] {
                {
                    new Category(0L, "name")
                },
                {
                    new Category()
                },
                {
                    new Category(null, EMPTY)
                },
        };
    }

    @DataProvider(name = "purchase")
    public static Object[][] purchase() {
        return new Object[][] {
                {
                    new Purchase(0L, PurchaseStatus.REGISTERED, new User(), List.of())
                },
                {
                    new Purchase()
                },
                {
                    new Purchase(null, null, null, null)
                },
        };
    }
}