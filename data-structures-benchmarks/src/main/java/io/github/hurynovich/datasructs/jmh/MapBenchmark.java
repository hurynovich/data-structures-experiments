package io.github.hurynovich.datasructs.jmh;

import io.github.hurynovich.dsa.hashtable.SimpleHashMap;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Warmup;

import java.util.Map;
import java.util.Random;

public class MapBenchmark {

    private static final Random rnd = new Random(1);
    private static final String val = "val";
    private static final Map<Integer, String> map = new SimpleHashMap<>(100000);

    @Benchmark()
    @Fork(1)
    @Warmup(iterations = 1, time = 2)
    @Measurement(iterations = 5, time = 2)
    public void testMapPut(){
        map.put(rnd.nextInt(), val);
    }

}
