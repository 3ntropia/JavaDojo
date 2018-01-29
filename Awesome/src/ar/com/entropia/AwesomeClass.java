package ar.com.entropia;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by marti on 24/1/2018.
 */
public class AwesomeClass {

    public static Integer compute(Function<Integer, Integer> function, Integer value) {
        return function.apply(value);
    }

    private static Integer invert(Integer value) {
        return -value;
    }

    public Integer addOldFashion(Integer a, Integer b) {
        return a + b;
    }

    public static BiFunction<Integer, Integer, Integer> addNewFashion = (a,b) -> {
        Integer result = a + b;
        return result;
    };

    public static Integer invertTheNumber(){
        Integer toInvert = 5;
        Function<Integer, Integer> invertFunction = AwesomeClass::invert;
        return compute(invertFunction, toInvert);
    }

    public static Integer invertTheNumberNew(){
        Integer toInvert = 5;
        return compute((a) -> -a, toInvert);
    }

    public static Integer addOneTo(Integer i){
        return addOne.apply(i);
    }

    public static Function <Integer,Integer> addOne = x -> x + 1;
}
