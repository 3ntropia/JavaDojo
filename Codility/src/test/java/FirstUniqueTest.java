import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstUniqueTest {

    @Test
    void solution() {
        int[] array = new int[]{1, 4, 3, 3, 1, 2};
        var result = FirstUnique.chatGPT(array);
        assertEquals(4, result);
    }


    @Test
    void solution2() {
        int[] array = new int[]{6, 4, 4, 6};
        var result = FirstUnique.chatGPT(array);
        assertEquals(-1, result);
    }

    @Test
    void solution3() {
        int[] array = new int[]{4, 10, 5, 4, 2, 10};
        var result = FirstUnique.chatGPT(array);
        assertEquals(5, result);
    }
}