package io.github.hurynovich.sructs.hashtable;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleHashMapTest {
    private static final Logger log = Logger.getLogger(SimpleHashMapTest.class.getCanonicalName());

    private final SimpleHashMap<Integer, Object> tested = new SimpleHashMap<>(1000);
    private final String val = "val";


    @Test()
    public void testValueWithNegativeHash(){
        tested.put(-1, val);
    }

}