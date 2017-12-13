package ru.job4j.examples;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class fo test examples.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 12.12.2017.
 */
public class StreamMethodMapExample {
    /**
     * List.
     */
    private List<String> collection1 = Arrays.asList("a1", "a2", "a3", "a1");
    /**
     * List.
     */
    private List<String> collection2 = Arrays.asList("1,2,0", "4,5");
    /**
     * Test.
     */
    @Test
    public void add1ToEachElementFromCollection1() {
        List<String> result = collection1.stream().map((s) -> s + "_1").collect(Collectors.toList());
        assertThat(result.get(0), is("a1_1"));
    }
    /**
     * Test.
     */
    @Test
    public void remofeFirsSymbolFromEachElement() {
        int[] result = collection1.stream().mapToInt((s) -> Integer.parseInt(s.substring(1))).toArray();
        assertThat(result[2], is(3));
    }
    /**
     * Test.
     */
    @Test
    public void getStringNumberArrayFromCollection2() {
        String[] result = collection2.stream().flatMap((p) -> Arrays.asList(p.split(",")).stream()).toArray(String[]::new);
        assertThat(result[3], is("4"));
    }
    /**
     * Test.
     */
    @Test
    public void getSumFromCollection2() {
        int result = collection2.stream().flatMapToInt((p) -> Arrays.asList(p.split(",")).stream().mapToInt(Integer::parseInt)).sum();
        assertThat(result, is(12));
    }
}
