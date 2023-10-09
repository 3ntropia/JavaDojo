import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreeLettersTest {

    @Test
    void solution() {
        var asd = ThreeLetters.solution(5,3);
        System.out.println(asd);
    }

    @Test
    void solution2() {
        var asd = ThreeLetters.solution(3,3);
        System.out.println(asd);
    }

    @Test
    void solution3() {
        var asd = ThreeLetters.solution(1,4);
        System.out.println(asd);
    }
}