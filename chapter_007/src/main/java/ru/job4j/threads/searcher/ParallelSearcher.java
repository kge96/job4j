package ru.job4j.threads.searcher;

import java.util.LinkedList;
import java.util.List;

/**
 * Class for parallel searching.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 19.10.2017.
 */
public class ParallelSearcher {
    /**
     * Results storage.
     */
    private volatile List<String> results = new LinkedList<>();

    /**
     * Do serching at specified path.
     * @param root - search start path.
     * @param text - searching text.
     * @param exts - file extention.
     */
    public void doSearching(String root, String text, List<String> exts) {
        ThreadManager threadManager = new ThreadManager(root, exts, text, results);
        threadManager.startSearch();
    }

    /**
     * Return searching result.
     * @return List.
     */
    public List<String> getResults() {
        return results;
    }
}
