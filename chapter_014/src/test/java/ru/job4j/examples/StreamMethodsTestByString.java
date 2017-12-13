package ru.job4j.examples;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for test example.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 12.12.2017.
 */
public class StreamMethodsTestByString {
    /**
     * List.
     */
    private List<String> list = Arrays.asList("a1", "a2", "a8", "a4", "a1");
    /**
     * Test.
     */
    @Test
    public void testFilter() {
        long result = list.stream().filter("a1"::equals).count();
        assertThat(result, is(2L));
    }
    /**
     * Test.
     */
    @Test
    public void testFindFirst() {
        String result = String.valueOf(list.stream().findFirst().orElse("0"));
        assertThat(result, is("a1"));
    }
    /**
     * Test.
     */
    @Test
    public void testGetLastCollectionElement() {
        String result = String.valueOf(list.stream().skip(list.size() - 2).findAny().orElse("empty"));
        assertThat(result, is("a4"));
    }
    /**
     * Test.
     */
    @Test
    public void findElementOrThrowException() {
        String result = String.valueOf(list.stream().filter("a8"::equals).findFirst().get());
        assertThat(result, is("a8"));
    }
    /**
     * Test.
     */
    @Test
    public void getTherdCollectionElement() {
        String result = String.valueOf(list.stream().skip(2).findFirst().get());
        assertThat(result, is("a8"));
    }
    /**
     * Test.
     */
    @Test
    public void getTowElementsStartFromSecond() {
        Object[] result = list.stream().skip(1).limit(2).toArray();
        assertThat(result[0].toString(), is("a2"));
    }

    //**********Match testing*****************//
    /**
     * Test.
     */
    @Test
    public void isThereAnyElementA8() {
        boolean result = list.stream().anyMatch("a8"::equals);
        assertThat(result, is(true));
    }
    /**
     * Test.
     */
    @Test
    public void isThereAnyElementA3() {
        boolean result = list.stream().anyMatch("a3"::equals);
        assertThat(result, is(false));
    }
    /**
     * Test.
     */
    @Test
    public void isThereSymbol1() {
        boolean result = list.stream().allMatch((s) -> s.contains("1"));
        assertThat(result, is(false));
    }
    /**
     * Test.
     */
    @Test
    public void isntThereElementA7() {
        boolean result = list.stream().noneMatch("a7"::equals);
        assertThat(result, is(true));
    }
}
