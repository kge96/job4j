package ru.job4j.multifunction;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Class for creating multifunction.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 13.12.2017.
 */
public class Multifunction {
    /**
     * Multifunction.
     * @param start - start point.
     * @param end - end point.
     * @param func - function.
     * @return List.
     */
    public List<Double> diapason(int start, int end, Function<Integer, Double> func) {
        return IntStream
                .range(start, end)
                .boxed()
                .map(func::apply)
                .collect(Collectors.toList());
    }
}
