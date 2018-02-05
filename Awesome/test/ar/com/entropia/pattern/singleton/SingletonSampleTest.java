package ar.com.entropia.pattern.singleton;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by marti on 5/2/2018.
 */
public class SingletonSampleTest {
    @Test
    public void whenSetDifferentNumber_getInstance() throws Exception {
        SingletonSample singletonSample = SingletonSample.getInstance();
        singletonSample.setNumber(2);
        singletonSample = SingletonSample.getInstance();
        Assert.assertEquals(singletonSample.getNumber(),Integer.valueOf(2));
    }

}