package com.spotter.backend.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestImgur {

    public final Imgur imgur = new Imgur.Builder()
            .withDbId(1)
            .withImgUrLink("test")
            .withImgUrId("1234")
            .withDeleteHash("deleteHash")
            .build();

    @Test
    public void testImgurBuilder() {
        Assertions.assertTrue(imgur instanceof Imgur);
    }

    @Test
    public void testInputWithDbId() {
        Assertions.assertTrue(imgur.getDbId() == 1);
    }

    @Test
    public void testInputWithImgUrLink() {
        Assertions.assertTrue(imgur.getLink() == "test");
    }

    @Test
    public void testInputWithImgUrId() {
        Assertions.assertTrue(imgur.getImgurId() == "1234");
    }

    @Test
    public void testInputWithDeleteHash() {
        Assertions.assertTrue(imgur.getDeleteHash() == "deleteHash");
    }

}
