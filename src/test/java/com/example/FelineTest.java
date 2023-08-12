package com.example;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class FelineTest {
    private static Feline feline;

    @BeforeClass
    public static void setUp() {
        feline = new Feline();
    }

    @Test
    public void testGetKittens() {
        int kittens = feline.getKittens(5);
        assertEquals(5, kittens);

        int felineKittens = feline.getKittens();
        assertEquals(1, felineKittens);
    }

    @Test
    public void testGetFamily() {
        String family = feline.getFamily();
        assertEquals("Кошачьи", family);
    }

    @Test
    public void testEatMeat() throws Exception {
        List<String> foodKind = feline.eatMeat();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertArrayEquals(expected.toArray(), foodKind.toArray());
    }
}