package io.github.hurynovich.sructs.hashtable;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleHashMapTest {
    private static final Logger log = Logger.getLogger(SimpleHashMapTest.class.getCanonicalName());

    private final SimpleHashMap<Integer, Object> tested = new SimpleHashMap<>();
    private final String val = "val";


    @Test()
    @Timeout(value = 30, unit = TimeUnit.SECONDS)
    public void testPutMillionKeys(){
        for (int i = 0; i < 1_000_000; i++) {
            if(i % 10_000 == 0) log.info(String.format("Iteration %d.", i));
            tested.put(i, val);
        }
    }

}