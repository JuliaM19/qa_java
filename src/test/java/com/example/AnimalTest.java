package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AnimalTest {

    @Test
    public void testGetFood() throws Exception {
        Animal animal = new Animal();
        List<String> veganFood = animal.getFood("Травоядное");
        List<String> expectedVeganResult = List.of("Трава", "Различные растения");
        assertArrayEquals(expectedVeganResult.toArray(), veganFood.toArray());

        List<String> notVeganFood = animal.getFood("Хищник");
        List<String> expectedNotVeganResult = List.of("Животные", "Птицы", "Рыба");
        assertArrayEquals(notVeganFood.toArray(), expectedNotVeganResult.toArray());
    }

    @Test
    public void testGetFoodException() {
        Animal animal = new Animal();
        assertThrows("Неизвестный вид животного, используйте значение Травоядное или Хищник", Exception.class, () -> animal.getFood("TEST"));
    }

    @Test
    public void testGetFamily() {
        Animal animal = new Animal();
        String family = animal.getFamily();
        String expectedResult = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expectedResult, family);
    }
}