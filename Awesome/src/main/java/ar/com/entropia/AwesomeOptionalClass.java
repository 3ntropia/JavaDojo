package ar.com.entropia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by marti on 25/1/2018.
 */
public class AwesomeOptionalClass {

    private List<String> stringList;

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public static AwesomeOptionalClass awesomeHardcoded(){
        AwesomeOptionalClass awesomeOptionalClass = new AwesomeOptionalClass();
        awesomeOptionalClass.setStringList(Arrays.asList("string1","string2","string3"));
        return awesomeOptionalClass;
    }
}
