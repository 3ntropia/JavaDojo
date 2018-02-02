package ar.com.entropia;

import java.util.List;
import java.util.Optional;
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

    public Integer crazyStuf(Integer i){
        return highOrderCrazyStuf(x->x++,i);
    }

    public Integer highOrderCrazyStuf(Function<Integer,Integer> function, Integer number){
        return function.apply(number);
    }


    public Integer adder(Integer first, Integer second){
        BiFunction<Integer, Integer, Integer> adder = (a, b) -> a + b;
        return adder.apply(first,second);
    }

    public static Integer addOneTo(Integer i){
        return addOne.apply(i);
    }

    public static Function <Integer,Integer> addOne = x -> x + 1;

    public static void listingOptional(AwesomeOptionalClass awesomeOptionalClass){
        Optional optional = Optional.ofNullable(awesomeOptionalClass.getStringList());
        if(optional.isPresent()){
            awesomeOptionalClass.getStringList().stream().forEach(System.out::println);
        }
    }

    public static String firstItem(AwesomeOptionalClass awesomeOptionalClass){
        Optional<List<String>> optional = Optional.ofNullable(awesomeOptionalClass.getStringList());
        String result = "LISTA EN NULL";
        if(optional.isPresent()){
            result = optional.get().stream().findFirst().orElse("LISTA VACIA");
        }
        return result;
    }
}
