import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DequeueTest {

    @Test
    void maximumUniqueIntegers() {
        List<Integer> arr = Arrays.asList(5, 3, 2, 3, 2);
        var result = DequeueMax.solve(6, 3,arr);
        assertNotNull(result);
        assertEquals(3, result);
    }
}