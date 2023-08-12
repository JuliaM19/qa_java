package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    private Feline feline;
    @InjectMocks
    private Cat cat;


    @Test
    public void testGetSound() {
        String actualResult = cat.getSound();
        String expectedResult = "Мяу";

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void name() throws Exception {
        List<String> expected = List.of("Рыбка");
        Mockito.when(feline.eatMeat()).thenReturn(expected);
        List<String> food = cat.getFood();
        assertArrayEquals(food.toArray(), expected.toArray());
    }
}