package com.nphumbert;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Sha256HashProviderTest {

    @Test
    public void should_hash_text_using_sha_256() {
        // given
        HashProvider hashProvider = new Sha256HashProvider();

        // when
        String hash = hashProvider.hash("secret");

        // then
        assertThat(hash, is("[43, -72, 13, 83, 123, 29, -93, -29, -117, -45, 3, 97, -86, -123, 86, -122, -67, -32, -22, -51, 113, 98, -2, -10, -94, 95, -23, 123, -11, 39, -94, 91]"));
    }
}