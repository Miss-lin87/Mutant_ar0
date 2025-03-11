package src.main.tests;

import org.junit.Assert;
import org.junit.Test;
import se.linda.Player_functions.baseFunctions.Basestats;
import se.linda.enums.klasser;
import se.linda.enums.stats;

public class BasestatsTest {

    @Test
    public void testGetStats() {
        Assert.assertTrue(new Basestats(klasser.KROSSARE).getBeststat() == stats.STYRKA);
        Assert.assertTrue(new Basestats(klasser.SKROTSKALLE).getBeststat() == stats.SKÄRPA);
        Assert.assertTrue(new Basestats(klasser.ZONSTRYKARE).getBeststat() == stats.KYLA
                && new Basestats(klasser.SLAV).getBeststat() == stats.KYLA
                && new Basestats(klasser.MUTANT_MED_HUND).getBeststat() == stats.KYLA);
        Assert.assertTrue(new Basestats(klasser.FIXARE).getBeststat() == stats.KÄNSLA
                && new Basestats(klasser.KRÖNIKÖR).getBeststat() == stats.KÄNSLA
                && new Basestats(klasser.BOSS).getBeststat() == stats.KÄNSLA);
    }

    @Test
    public void testSetters() {
        Basestats mock = new Basestats(klasser.KROSSARE);
        mock.setStyrka(3);
        mock.setKänsla(5);
        mock.setKyla(2);
        mock.setSkärpa(1);
        Assert.assertEquals(5, mock.getStyrka());
        Assert.assertEquals(2, mock.getKänsla());
        Assert.assertEquals(4, mock.getKyla());
        Assert.assertEquals(3, mock.getSkärpa());
    }
}
