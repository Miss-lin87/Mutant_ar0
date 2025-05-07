package se.linda.mutant_creator.functions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.linda.mutant_creator.enums.*;

class convertersTest {

    @Test
    void testEnumEquipment() {
        Assertions.assertNotEquals(equipment.KRUBB, new Converters().stringTOEnum("test", equipment.values()));
        for (equipment E : equipment.class.getEnumConstants()) {
            Assertions.assertEquals(E, new Converters().stringTOEnum(E.name, equipment.values()));
        }
        Assertions.assertNull(new Converters().stringTOEnum("test", equipment.values()));
    }

    @Test
    void testEnumFardigheter() {
        for (fardigheter F : fardigheter.class.getEnumConstants()) {
            Assertions.assertEquals(F, new Converters().stringTOEnum(F.getName(), fardigheter.values()));
        }
        Assertions.assertNull(new Converters().stringTOEnum("test", fardigheter.values()));
    }

    @Test
    void testEnumKlasser() {
        for (klasser K : klasser.class.getEnumConstants()) {
            Assertions.assertEquals(K, new Converters().stringTOEnum(K.getName(), klasser.values()));
        }
        Assertions.assertNull(new Converters().stringTOEnum("test", klasser.values()));
    }

    @Test
    void testEnumSpecFardigheter() {
        for (specFardigheter S : specFardigheter.class.getEnumConstants()) {
            Assertions.assertEquals(S, new Converters().stringTOEnum(S.getName(), specFardigheter.values()));
        }
        Assertions.assertNull(new Converters().stringTOEnum("test", specFardigheter.values()));
    }

    @Test
    void testEnumStats() {
        for (stats S : stats.class.getEnumConstants()) {
            Assertions.assertEquals(S, new Converters().stringTOEnum(S.name, stats.values()));
        }
        Assertions.assertNull(new Converters().stringTOEnum("test", stats.values()));
    }

    @Test
    void testEnumTalanger() {
        for (talanger T : talanger.class.getEnumConstants()) {
            Assertions.assertEquals(T, new Converters().stringTOEnum(T.getName(), talanger.values()));
        }
        Assertions.assertNull(new Converters().stringTOEnum("Test", talanger.values()));
    }
}