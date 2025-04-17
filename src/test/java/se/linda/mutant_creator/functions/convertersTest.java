package se.linda.mutant_creator.functions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import se.linda.mutant_creator.enums.*;

class convertersTest {

    @Test
    void testEnumEquipment() {
        Assertions.assertNotEquals(equipment.KRUBB, new converters().stringTOEnum("test", equipment.values()));
        for (equipment E : equipment.class.getEnumConstants()) {
            Assertions.assertEquals(E, new converters().stringTOEnum(E.name, equipment.values()));
        }
        Assertions.assertNull(new converters().stringTOEnum("test", equipment.values()));
    }

    @Test
    void testEnumFardigheter() {
        for (fardigheter F : fardigheter.class.getEnumConstants()) {
            Assertions.assertEquals(F, new converters().stringTOEnum(F.getName(), fardigheter.values()));
        }
        Assertions.assertNull(new converters().stringTOEnum("test", fardigheter.values()));
    }

    @Test
    void testEnumKlasser() {
        for (klasser K : klasser.class.getEnumConstants()) {
            Assertions.assertEquals(K, new converters().stringTOEnum(K.getName(), klasser.values()));
        }
        Assertions.assertNull(new converters().stringTOEnum("test", klasser.values()));
    }

    @Test
    void testEnumSpecFardigheter() {
        for (specFardigheter S : specFardigheter.class.getEnumConstants()) {
            Assertions.assertEquals(S, new converters().stringTOEnum(S.getName(), specFardigheter.values()));
        }
        Assertions.assertNull(new converters().stringTOEnum("test", specFardigheter.values()));
    }

    @Test
    void testEnumStats() {
        for (stats S : stats.class.getEnumConstants()) {
            Assertions.assertEquals(S, new converters().stringTOEnum(S.name, stats.values()));
        }
        Assertions.assertNull(new converters().stringTOEnum("test", stats.values()));
    }

    @Test
    void testEnumTalanger() {
        for (talanger T : talanger.class.getEnumConstants()) {
            Assertions.assertEquals(T, new converters().stringTOEnum(T.getName(), talanger.values()));
        }
        Assertions.assertNull(new converters().stringTOEnum("Test", talanger.values()));
    }
}