package com.nphumbert;

import org.junit.Test;

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

    @Test
    public void should_hash_password_when_create_user() {
        // when
        User user = new User("jdoe", "john.doe@gmail.com", "password");

        // then
        assertThat(user.password(), is("[94, -120, 72, -104, -38, 40, 4, 113, 81, -48, -27, 111, -115, -58, 41, 39, 115, 96, 61, 13, 106, -85, -67, -42, 42, 17, -17, 114, 29, 21, 66, -40]"));
    }

}