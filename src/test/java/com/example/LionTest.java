package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;


@RunWith(Parameterized.class)
public class LionTest {

    private String sex;
    private boolean hasMane;
    private Feline feline;

    public LionTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters(name = "Наличие гривы у животного. " + "Тестовые данные: {0}, {1}")
    public static Object[][] getTestData() {
        // генерация тестовых данных
        return new Object[][]{{"Самец", true}, {"Самка", false}};
    }

    @Before
    public void setUp() {
        feline = Mockito.mock(Feline.class);
    }

    @Test
    public void testWrongSex() {
        assertThrows(Exception.class,
                () -> new Lion("WRONG", null));
    }

    @Test
    public void testHasManeTestMale() throws Exception { //Проверка Самца
        Lion lion = new Lion(sex, feline);
        boolean actualResult = lion.doesHaveMane();
        assertEquals(hasMane, actualResult);
    }

    @Test
    public void testGetKittens() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion(sex, feline);
        int expectedResult = 1;
        assertEquals(expectedResult, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedValue = List.of("Вкусная еда");
        Mockito.when(feline.getFood(anyString())).thenReturn(expectedValue);
        Lion lion = new Lion(sex, feline);
        List<String> lionsFood = lion.getFood();

        assertArrayEquals(expectedValue.toArray(), lionsFood.toArray());
    }
}
