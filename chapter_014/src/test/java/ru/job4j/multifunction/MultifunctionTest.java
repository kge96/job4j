package ru.job4j.multifunction;

import org.junit.Test;

import java.util.List;
import java.util.function.Function;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing multifunction.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 13.12.2017.
 */
public class MultifunctionTest {
    /**
     * Multifunction.
     */
    private Multifunction multi = new Multifunction();

    /**
     * Test linear function.
     */
    @Test
    public void whenPassLinearFunctionThenGetListWithLinearVariables() {
        Function<Integer, Double> linear = x -> (double) (x + 1);
        List<Double> result = multi.diapason(1, 6, linear);
        assertThat(result.get(2), is(4.0));
    }

    /**
     * Test pow function.
     */
    @Test
    public void whenPassPowFunctionThenGetListWithPowVariables() {
        Function<Integer, Double> linear = x -> Math.pow(x, 2);
        List<Double> result = multi.diapason(1, 6, linear);
        assertThat(result.get(2), is(9.0));
    }

    /**
     * Test logarithmic function.
     */
    @Test
    public void whenPassLogarithmicFunctionThenGetListWithLogarithmicVariables() {
        Function<Integer, Double> linear = x -> Math.log10(x);
        List<Double> result = multi.diapason(10, 12, linear);
        assertThat(result.get(0), is(1.0));
    }

}
