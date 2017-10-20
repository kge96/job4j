package ru.job4j.threads.searcher;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Class for testing text searcher.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 19.10.2017.
 */
public class ParallelSearcherTest {
    /**
     * Testing search text.
     * @throws InterruptedException - exception.
     */
    @Test
    public void whenSearchTextThenResultHasFiveLinks() throws InterruptedException {
        List<String> list = new LinkedList<>();
        list.add("java");
        list.add("txt");
        list.add("html");


        ParallelSearcher ps = new ParallelSearcher();
        ps.doSearching("C:\\Projects\\gkuznetsov\\chapter_007", "This is Sparta", list);
        List<String> result = ps.getResults();
        System.out.println(result.size());
        for (String s : result) {
            System.out.println(s);
        }
    }
}
