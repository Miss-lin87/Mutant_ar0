package src.main.tests;

import org.junit.Assert;
import org.junit.Test;
import se.linda.functions.dice_rolls;

import java.util.ArrayList;
import java.util.List;

public class dice_rollsTest {
    private dice_rolls D = new dice_rolls();
    private List<String> D66results = new ArrayList<>();

    private void makeD66Result() {
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                D66results.add(i+""+j);
            }
        }
    }

    @Test
    public void testD6() {
        for (int i = 0; i < 1000; i++) {
            int roll = D.D6();
            Assert.assertTrue(roll < 7 && roll != 0);
            Assert.assertFalse(roll == 0 || 7 < roll);
        }
    }

    @Test
    public void testD66() {
        makeD66Result();
        for (int i = 0; i < 1000; i++) {
            Assert.assertTrue(D66results.contains(D.D66()));
        }
    }

    @Test
    public void testD6overload() {
        for (int i = 1; i < 100; i++) {
            int number = D.D6(i);
            Assert.assertTrue(number > i && number < (i*6)+1);
        }
    }
}