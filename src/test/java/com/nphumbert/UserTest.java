package com.nphumbert;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserTest {

    @Test
    public void should_create_user() {
        // when
        User user = new User("jdoe", "john.doe@gmail.com", "password");

        // then
        assertThat(user.login(), is("jdoe"));
        assertThat(user.email(), is("john.doe@gmail.com"));
    }

    /**
     * Inappropriate way to test the hash of the password.
     */
    @Test
    public void should_hash_password() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // given
        User user = new User("jdoe", "john.doe@gmail.com", "secret");
        Method method = user.getClass().getDeclaredMethod("hash", String.class);
        method.setAccessible(true);

        // when
        String hashedPassword = (String) method.invoke(user, "secret");

        // then
        assertThat(hashedPassword, is("[43, -72, 13, 83, 123, 29, -93, -29, -117, -45, 3, 97, -86, -123, 86, -122, -67, -32, -22, -51, 113, 98, -2, -10, -94, 95, -23, 123, -11, 39, -94, 91]"));
    }

}