import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZigzagTest {

    @Test
    void findZigZagSequence() {
        int[] arra = new int[]{ 2,3,5,1,4 };
        Zigzag.findZigZagSequence(arra, arra.length);
    }
}