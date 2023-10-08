import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers.
 * Then print the respective minimum and maximum values as a single line of two space-separated long integers.
 *
 * Example
 * arr = [1,3, 5, 7, 9]
 * The minimum sum is 16 (1+3+5+7) and the maximum sum is (3+5+7+9). The function prints [16, 24]
 *
 */
public class MiniMaxSum {

    public static List<Integer> miniMaxSum(List<Integer> arr) {
        // Write your code here
        arr.sort(Comparator.naturalOrder());
        Integer min = arr.stream()
                .limit(arr.size()-1)
                .reduce(Integer::sum).orElse(0);
        Integer max = arr.stream()
                .skip(1)
                .reduce(Integer::sum).orElse(0);
        return Arrays.asList(min, max);
    }
}
