

import java.util.Optional;

/**
 * Created by marti on 25/1/2018.
 */
public class AwesomeOptionalClass {

    public boolean isNUll(Integer i){
        Optional<Integer> optinalI = Optional.of(i);
        return optinalI.isPresent();
    }
}
