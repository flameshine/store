package com.example.app.util;

import java.util.List;
import java.util.Date;
import java.math.BigDecimal;

import org.testng.annotations.DataProvider;

import com.example.app.entity.*;

import static com.example.app.util.Utils.EMPTY_STRING;

/**
 * Class that provides test data.
 */

public final class TestData {

    private TestData() {}

    @DataProvider(name = "users")
    public static Object[][] users() {
        return new Object[][] {
                {
                    List.of(new User("name1", "email1@test", "password1", null, "firstname1", "lastname1", true, new Role("name1")), new User("name2", "email2@test", "password2", null, "firstname2", "lastname2", true, new Role("name2")), new User("name3", "email3@test", "password3", null, "firstname3", "lastname3", true, new Role("name3")))
                },
                {
                    List.of(new User(), new User(), new User())
                },
                {
                    List.of(new User(EMPTY_STRING, EMPTY_STRING, EMPTY_STRING, null, EMPTY_STRING, EMPTY_STRING, null, null), new User(EMPTY_STRING, EMPTY_STRING, EMPTY_STRING, null, EMPTY_STRING, EMPTY_STRING, null, null), new User(EMPTY_STRING, EMPTY_STRING, EMPTY_STRING, null, EMPTY_STRING, EMPTY_STRING, null, null))
                },
        };
    }

    @DataProvider(name = "roles")
    public static Object[][] roles() {
        return new Object[][] {
                {
                    List.of(new Role("name1"), new Role("name2"), new Role("name3"))
                },
                {
                    List.of(new Role(), new Role(), new Role())
                },
                {
                    List.of(new Role(EMPTY_STRING), new Role(EMPTY_STRING), new Role(EMPTY_STRING))
                },
        };
    }

    @DataProvider(name = "user")
    public static Object[][] user() {
        return new Object[][] {
                {
                    new User("name", "email@test", "password", null, "firstname", "lastname", true, new Role("name"))
                },
                {
                    new User()
                },
                {
                    new User(EMPTY_STRING, EMPTY_STRING, EMPTY_STRING, null, EMPTY_STRING, EMPTY_STRING, null, null)
                },
        };
    }

    @DataProvider(name = "role")
    public static Object[][] role() {
        return new Object[][] {
                {
                    new Role("name")
                },
                {
                    new Role()
                },
                {
                    new Role(EMPTY_STRING)
                },
        };
    }

    @DataProvider(name = "products")
    public static Object[][] products() {
        return new Object[][] {
                {
                    List.of(new Product("name1", BigDecimal.ZERO, new Date(), new Date(), 0, 0, new Category("name1")), new Product("name2", BigDecimal.ZERO, new Date(), new Date(), 0, 0, new Category("name2")), new Product("name3", BigDecimal.ZERO, new Date(), new Date(), 0, 0, new Category("name3")))
                },
                {
                    List.of(new Product(), new Product(), new Product())
                },
                {
                    List.of(new Product(EMPTY_STRING, null, null, null, 0, 0, null), new Product(EMPTY_STRING, null, null, null, 0, 0, null), new Product(EMPTY_STRING, null, null, null, 0, 0, null))
                },
        };
    }

    @DataProvider(name = "categories")
    public static Object[][] categories() {
        return new Object[][] {
                {
                    List.of(new Category("name1"), new Category("name2"), new Category("name3"))
                },
                {
                    List.of(new Category(), new Category(), new Category())
                },
                {
                    List.of(new Category(EMPTY_STRING), new Category(EMPTY_STRING), new Category(EMPTY_STRING))
                },
        };
    }

    @DataProvider(name = "product")
    public static Object[][] product() {
        return new Object[][] {
                {
                    new Product("name", BigDecimal.ZERO, new Date(), new Date(), 0, 0, new Category("name"))
                },
                {
                    new Product()
                },
                {
                    new Product(EMPTY_STRING, null, null, null, 0, 0, null)
                },
        };
    }

    @DataProvider(name = "category")
    public static Object[][] category() {
        return new Object[][] {
                {
                    new Category("name")
                },
                {
                    new Category()
                },
                {
                    new Category(EMPTY_STRING)
                },
        };
    }
}