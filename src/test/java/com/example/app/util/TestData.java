package com.example.app.util;

import java.util.Collections;

import com.example.app.entity.Role;
import org.testng.annotations.DataProvider;

import com.example.app.entity.User;

/**
 * Class that provides test data.
 */

public final class TestData {

    private TestData() {}

    // TODO: add varied test cases.

    @DataProvider(name = "users")
    public static Object[][] users() {
        return new Object[][] {
                {
                    new User(1L, "name1", "email1@test", "password1", null, "firstname1", "lastname1", true, Collections.emptyList())
                },
                {
                    new User(2L, "name2", "email2@test", "password2", null, "firstname2", "lastname2", true, Collections.emptyList())
                },
                {
                    new User(3L, "name3", "email3@test", "password3", null, "firstname3", "lastname3", true, Collections.emptyList())
                }
        };
    }

    @DataProvider(name = "roles")
    public static Object[][] roles() {
        return new Object[][] {
                {
                    new Role(1L, "name1", Collections.emptyList())
                },
                {
                    new Role(2L, "name2", Collections.emptyList())
                },
                {
                    new Role(3L, "name3", Collections.emptyList())
                }
        };
    }
}