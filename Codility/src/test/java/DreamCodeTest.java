import org.junit.jupiter.api.Test;

import java.util.Arrays;

class DreamCodeTest {

    @Test
    void solution() {
        String [] result = DreamCode.solution(3);
        System.out.println(Arrays.toString(result));
    }

    @Test
    void solution2() {
        String [] result = DreamCode.solution(-1);
        System.out.println(Arrays.toString(result));
    }

    @Test
    void solution3() {
        String [] result = DreamCode.solution(8);
        System.out.println(Arrays.toString(result));
    }

    @Test
    void solution4() {
        DreamCode exam = new DreamCode();
        String [] result = exam.solution(15);
        System.out.println(Arrays.toString(result));
    }
}