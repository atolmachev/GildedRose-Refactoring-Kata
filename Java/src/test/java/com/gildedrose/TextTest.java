package com.gildedrose;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.Assert.assertEquals;

public class TextTest {
    @Test
    public void shouldBeEqualToGolden() {
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(bs);
        String golden = new Scanner(this.getClass().getResourceAsStream("golden.txt")).useDelimiter("\\A").next();

        TexttestFixture.run(ps, 2);

        assertEquals(golden, new String(bs.toByteArray(), UTF_8));
    }
}
