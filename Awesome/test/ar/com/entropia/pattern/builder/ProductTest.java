package ar.com.entropia.pattern.builder;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by marti on 5/2/2018.
 */
public class ProductTest {

    @Test
    public void newProduct() throws Exception {
        Product product = Product.newProduct()
                .id("1")
                .name("name")
                .build();
        Assert.assertEquals(product.getName(),"name");

    }

}