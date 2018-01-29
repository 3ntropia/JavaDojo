import ar.com.entropia.AwesomeClass;
import org.junit.Assert;

import static org.junit.Assert.*;

/**
 * Created by marti on 29/1/2018.
 */
public class AwesomeClassTest {
    @org.junit.Test
    public void compute() throws Exception {
    }

    @org.junit.Test
    public void addOldFashion() throws Exception {
    }

    @org.junit.Test
    public void invertTheNumber() throws Exception {
    }

    @org.junit.Test
    public void invertTheNumberNew() throws Exception {
    }

    @org.junit.Test
    public void addOneTo() throws Exception {
        Assert.assertEquals(AwesomeClass.addOneTo(1),Integer.valueOf(2));
    }

}