package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing WordSearcher.
 * @author gkuznetsov.
 * @since 17.09.17.
 * @version 0.1.
 */

public class WordSearcherTest {
    /**
     * Test when string contains substring.
     */
    @Test
    public void whenStringContainSubstringThanReturnTrue() {
        WordSearcher wordSearcher = new WordSearcher();
        boolean result = wordSearcher.contains("Мама мыла раму", "ам");
        boolean expected = true;
        assertThat(result, is(expected));
    }
    /**
     * Test when string contains substring.
     */
    @Test
    public void whenStringContainSubstringThanReturnTrue2() {
        WordSearcher wordSearcher = new WordSearcher();
        boolean result = wordSearcher.contains("Мама МЫЛА раму", "мЫл");
        boolean expected = true;
        assertThat(result, is(expected));
    }
    /**
     * Test when string doesn't contains substring.
     */
    @Test
    public void whenStringDoesNotContainSubstringThanReturnTrue3() {
        WordSearcher wordSearcher = new WordSearcher();
        boolean result = wordSearcher.contains("Мама мыла раму", "мЫлО");
        boolean expected = false;
        assertThat(result, is(expected));
    }
}
