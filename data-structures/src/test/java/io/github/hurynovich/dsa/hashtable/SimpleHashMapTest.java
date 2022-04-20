package io.github.hurynovich.dsa.hashtable;

import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

public class SimpleHashMapTest {
    private static final Logger log = Logger.getLogger(SimpleHashMapTest.class.getCanonicalName());

    private final SimpleHashMap<Integer, Object> tested = new SimpleHashMap<>(1000);
    private final String val = "val";


    @Test()
    public void testValueWithNegativeHash(){
        tested.put(-1, val);
    }

}