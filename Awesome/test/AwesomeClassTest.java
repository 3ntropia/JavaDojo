import ar.com.entropia.AwesomeClass;
import ar.com.entropia.AwesomeOptionalClass;
import org.junit.Assert;

import java.util.ArrayList;


/**
 * Created by marti on 29/1/2018.
 */
public class AwesomeClassTest {

    @org.junit.Test
    public void invertTheNumber() throws Exception {
        Assert.assertEquals(AwesomeClass.invertTheNumber(),Integer.valueOf(2));
    }

    @org.junit.Test
    public void invertTheNumberNew() throws Exception {
        Assert.assertEquals(AwesomeClass.invertTheNumberNew(),Integer.valueOf(-5));
    }

    @org.junit.Test
    public void invertTheNumberNewFail() throws Exception {
        Assert.assertNotEquals(AwesomeClass.invertTheNumberNew(),Integer.valueOf(5));
    }

    @org.junit.Test
    public void addOneTo() throws Exception {
        Assert.assertEquals(AwesomeClass.addOneTo(1),Integer.valueOf(2));
    }

    @org.junit.Test
    public void listingOptional_whenNotEmpty() throws Exception{
        AwesomeOptionalClass awesomeOptionalClass = AwesomeOptionalClass.awesomeHardcoded();
        AwesomeClass.listingOptional(awesomeOptionalClass);
    }

    @org.junit.Test
    public void listingOptional_whenEmpty() throws Exception{
        AwesomeOptionalClass awesomeOptionalClass = new AwesomeOptionalClass();
        AwesomeClass.listingOptional(awesomeOptionalClass);
    }

    @org.junit.Test
    public void returnFirstOptional_whenNotNull() throws Exception{
        AwesomeOptionalClass awesomeOptionalClass = AwesomeOptionalClass.awesomeHardcoded();
        Assert.assertEquals(AwesomeClass.firstItem(awesomeOptionalClass),"string1");
    }

    @org.junit.Test
    public void returnFirstOptional_whenNull() throws Exception{
        AwesomeOptionalClass awesomeOptionalClass = new AwesomeOptionalClass();
        Assert.assertEquals(AwesomeClass.firstItem(awesomeOptionalClass),"LISTA EN NULL");
    }

    @org.junit.Test
    public void returnFirstOptional_whenEmpty() throws Exception{
        AwesomeOptionalClass awesomeOptionalClass = new AwesomeOptionalClass();
        awesomeOptionalClass.setStringList(new ArrayList<>());
        Assert.assertEquals(AwesomeClass.firstItem(awesomeOptionalClass),"LISTA VACIA");
    }

}