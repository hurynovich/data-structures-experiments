package io.github.hurynovich.sructs.hashtable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Common unit tests for {@link java.util.Map} implementations.
*/
public class MapTest {
    private Integer KEY_ONE = 1;
    private Integer KEY_TWO = 2;
    private Integer KEY_THREE = 3;

    private String VAL_A = "A";
    private String VAL_B = "B";
    private String VAL_C = "C";

    private Supplier<Map> mapFactory = SimpleHashMap::new;

    @ParameterizedTest
    @MethodSource()
    public void testPut(Supplier<Map> mapFactory){
        Map<Integer, String> map = mapFactory.get();
        String prevVal;

//     first put initial value
        assertEquals(null, map.put(KEY_ONE, VAL_A));
        assertEquals(1, map.size());
        assertEquals(VAL_A, map.get(KEY_ONE));

//      second put replaces previous value
        prevVal = map.put(KEY_ONE, VAL_B);
        assertEquals(1, map.size());
        assertEquals(VAL_A, prevVal);
        assertEquals(VAL_B, map.get(KEY_ONE));

//      therd put sets null value
        prevVal = map.put(KEY_ONE, null);
        assertEquals(1, map.size());
        assertEquals(VAL_B, prevVal);
        assertEquals(null, map.get(KEY_ONE));

//      fours put places two new values
        assertEquals(null, map.put(KEY_TWO, VAL_B));
        assertEquals(null, map.put(KEY_THREE, VAL_C));
        assertEquals(3, map.size());
        assertEquals(null, map.get(KEY_ONE));
        assertEquals(VAL_B, map.get(KEY_TWO));
        assertEquals(VAL_C, map.get(KEY_THREE));
    }
}
