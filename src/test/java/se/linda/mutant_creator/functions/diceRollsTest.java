package se.linda.mutant_creator.functions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class diceRollsTest {

    @Test
    public void testRollD6() {
        DiceRolls die = new DiceRolls();
        for (int i = 0; i < 100; i++) {
            int result = die.D6(Optional.of(1));
            Assertions.assertTrue(result >= 1 && result <= 6);
        }
    }
}
