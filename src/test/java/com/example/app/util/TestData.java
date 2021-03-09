package com.example.app.util;

import java.util.List;
import java.util.Collections;

import org.testng.annotations.DataProvider;

import com.example.app.entity.User;
import com.example.app.entity.Role;

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
                    List.of(new User(1L, "name1", "email1@test", "password1", null, "firstname1", "lastname1", true, new Role(1L, "name1", Collections.emptySet())),
                            new User(2L, "name2", "email2@test", "password2", null, "firstname2", "lastname2", true, new Role(1L, "name1", Collections.emptySet())),
                            new User(3L, "name3", "email3@test", "password3", null, "firstname3", "lastname3", true, new Role(1L, "name1", Collections.emptySet())))
                },
                {
                    List.of(new User(), new User(), new User())
                },
                {
                    List.of(new User(1L, EMPTY_STRING, EMPTY_STRING, EMPTY_STRING, null, EMPTY_STRING, EMPTY_STRING, null, null),
                            new User(2L, EMPTY_STRING, EMPTY_STRING, EMPTY_STRING, null, EMPTY_STRING, EMPTY_STRING, null, null),
                            new User(3L, EMPTY_STRING, EMPTY_STRING, EMPTY_STRING, null, EMPTY_STRING, EMPTY_STRING, null, null))
                },
        };
    }

    @DataProvider(name = "roles")
    public static Object[][] roles() {
        return new Object[][] {
                {
                    List.of(new Role(1L, "name1", Collections.emptySet()),
                            new Role(2L, "name2", Collections.emptySet()),
                            new Role(3L, "name3", Collections.emptySet()))
                },
                {
                    List.of(new Role(), new Role(), new Role())
                },
                {
                    List.of(new Role(1L, EMPTY_STRING, null),
                            new Role(2L, EMPTY_STRING, null),
                            new Role(3L, EMPTY_STRING, null))
                },
        };
    }

    @DataProvider(name = "user")
    public static Object[][] user() {
        return new Object[][] {
                {
                    new User(1L, "name", "email@test", "password", null, "firstname", "lastname", true, new Role(4L, "name4", Collections.emptySet()))
                },
                {
                    new User(1L, EMPTY_STRING, EMPTY_STRING, EMPTY_STRING, null, EMPTY_STRING, EMPTY_STRING, null, null)
                },
                {
                    new User()
                },
        };
    }

    @DataProvider(name = "role")
    public static Object[][] role() {
        return new Object[][] {
                {
                    new Role(1L, "name", Collections.emptySet())
                },
                {
                    new Role()
                },
                {
                    new Role(1L, EMPTY_STRING, null)
                },
        };
    }
}