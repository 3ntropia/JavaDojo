import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AgileEngineTest {

    @Test
    public void testCountWithEmptyMaps() {
        Map<Long, Long> result = AgileEngine.count();
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testCountWithOptionalAbsent() {
        Map<String, AgileEngine.UserStats> map1 = new HashMap<>();
        map1.put("1", new AgileEngine.UserStats(null)); // Optional ausente
        map1.put("2", new AgileEngine.UserStats(200L));

        Map<Long, Long> result = AgileEngine.count(map1);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        // Añade aserciones para verificar el comportamiento con Optional ausente
    }

    @Test
    public void testCountWithOptionalPresent() {
        Map<String, AgileEngine.UserStats> map1 = new HashMap<>();
        map1.put("1", new AgileEngine.UserStats(100L));
        map1.put("2", new AgileEngine.UserStats(200L));

        Map<String, AgileEngine.UserStats> map2 = new HashMap<>();
        map2.put("3", new AgileEngine.UserStats(150L));
        map2.put("4", new AgileEngine.UserStats(300L));

        Map<String, AgileEngine.UserStats> map3 = new HashMap<>();
        map3.put("5", new AgileEngine.UserStats(400L)); // Optional presente

        Map<Long, Long> result = AgileEngine.count(map1, map2, map3);

        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void testCountWithNonConvertibleKeys() {
        Map<String, AgileEngine.UserStats> map1 = new HashMap<>();
        map1.put("user1", new AgileEngine.UserStats(100L));
        map1.put("user2", new AgileEngine.UserStats(200L));
        map1.put("nonConvertibleKey", new AgileEngine.UserStats(300L));

        Map<String, AgileEngine.UserStats> map2 = new HashMap<>();
        map2.put("user3", new AgileEngine.UserStats(150L));
        map2.put("user4", new AgileEngine.UserStats(300L));
        map2.put("anotherNonConvertibleKey", new AgileEngine.UserStats(400L));

        Map<Long, Long> result = AgileEngine.count(map1, map2);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        // Añade aserciones para verificar que las claves no convertibles se han ignorado
    }

    @Test
    public void testCountWithDuplicateUsers() {
        Map<String, AgileEngine.UserStats> map1 = new HashMap<>();
        map1.put("1", new AgileEngine.UserStats(100L));
        map1.put("2", new AgileEngine.UserStats(200L));

        Map<String, AgileEngine.UserStats> map2 = new HashMap<>();
        map2.put("1", new AgileEngine.UserStats(150L)); // Usuario repetido con diferentes stats
        map2.put("4", new AgileEngine.UserStats(300L));

        Map<Long, Long> result = AgileEngine.count(map1, map2);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        // Añade aserciones para verificar que se haya realizado correctamente la contabilización
        assertEquals(250L, result.get(1L));
        assertEquals(450L, result.get(2L));
    }

}