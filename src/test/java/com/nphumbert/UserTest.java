package com.nphumbert;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserTest {

    private HashProvider hashProvider;

    @Before
    public void setUp() throws Exception {
        hashProvider = mock(HashProvider.class);
    }

    @Test
    public void should_create_user() {
        // when
        User user = new User("jdoe", "john.doe@gmail.com", "password", hashProvider);

        // then
        assertThat(user.login(), is("jdoe"));
        assertThat(user.email(), is("john.doe@gmail.com"));
    }

    @Test
    public void should_hash_password_when_create_user() {
        // given
        when(hashProvider.hash("secret")).thenReturn("hash");

        // when
        User user = new User("jdoe", "john.doe@gmail.com", "secret", hashProvider);

        // then
        assertThat(user.password(), is("hash"));
    }

}