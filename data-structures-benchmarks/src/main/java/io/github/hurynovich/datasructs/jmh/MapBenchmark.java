package io.github.hurynovich.datasructs.jmh;

import io.github.hurynovich.sructs.hashtable.SimpleHashMap;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Warmup;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class MapBenchmark {

    private static final Random rnd = new Random(1);
    private static final String val = "val";
    private static final Map<Integer, String> map = new SimpleHashMap<>();

    @Benchmark()
    @Fork(1)
    @Warmup(iterations = 1, time = 1)
    @Measurement(iterations = 5, time = 1)
    public void testMapPut(){
        map.put(rnd.nextInt(), val);
    }

}
