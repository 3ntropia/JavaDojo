import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MiniMaxSumTest {

    @Test
    void miniMaxSum() {
        List<Integer> arr = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> result = MiniMaxSum.miniMaxSum(arr);
        assertNotNull(result);
        assertEquals(16, result.get(0));
        assertEquals(24, result.get(1));
    }

    @Test
    void miniMaxSum2() {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = MiniMaxSum.miniMaxSum(arr);
        assertNotNull(result);
        assertEquals(10, result.get(0));
        assertEquals(14, result.get(1));
    }

    @Test
    void miniMaxSum3() {
        List<Integer> arr = Arrays.asList(5, 4, 3, 2, 1);
        List<Integer> result = MiniMaxSum.miniMaxSum(arr);
        assertNotNull(result);
        assertEquals(10, result.get(0));
        assertEquals(14, result.get(1));
    }
}