import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class PlusMinus {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<String> plusMinus(List<Integer> arr) {
        // Write your code here
        Map<Integer, Integer> ratios = new HashMap<>();
        ratios.put(-1, 0);
        ratios.put(0, 0);
        ratios.put(+1, 0);
        for(int value:arr){
            if(value<0){
                ratios.compute(-1, increaseValueByOne);
            } else if (value == 0) {
                ratios.compute(0, increaseValueByOne);
            } else{
                ratios.compute(+1, increaseValueByOne);
            }
        }
        BigDecimal divisor = BigDecimal.valueOf(arr.size());
        String negatives = String.valueOf(divide.apply(BigDecimal.valueOf(ratios.get(-1)), divisor));
        String zeros = String.valueOf(divide.apply(BigDecimal.valueOf(ratios.get(0)), divisor));
        String positive = String.valueOf(divide.apply(BigDecimal.valueOf(ratios.get(+1)), divisor));
        return Arrays.asList(positive, negatives, zeros);
    }

    static BiFunction<Integer, Integer, Integer> increaseValueByOne = (k, v) -> v+1;
    static BiFunction<BigDecimal, BigDecimal, BigDecimal> divide = (n, d) -> n.divide(d, 4, RoundingMode.HALF_UP);
}