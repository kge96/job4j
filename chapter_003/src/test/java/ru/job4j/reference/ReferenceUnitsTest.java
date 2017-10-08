package ru.job4j.reference;

import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing ReferenceUnit.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 08.10.2017.
 */
public class ReferenceUnitsTest {
    /**
     * Testing sort from smaller to biggest.
     */
    @Test
    public void whenSortArrayFromSmallerToBiggestThenGetSortedArray() {
        String[] units = new String[]{
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        };
        ReferenceUnits referenceUnits = new ReferenceUnits(units);

        String[] result = referenceUnits.sortFromSmallest();
        String[] expected = new String[]{"K1", "K1\\SK1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K1\\SK2", "K2", "K2\\SK1", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        assertThat(result, is(expected));
    }

    /**
     * Testing sort form biggest to smaller.
     */
    @Test
    public void whenSortArrayFromBiggestToSmallerThenGetSortedArray() {
        String[] units = new String[]{
                "K1\\SK1",
                "K1\\SK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        };
        ReferenceUnits referenceUnits = new ReferenceUnits(units);

        String[] result = referenceUnits.sortFromBiggest();
        String[] expected = new String[]{"K2", "K2\\SK1", "K2\\SK1\\SSK2", "K2\\SK1\\SSK1", "K1", "K1\\SK2", "K1\\SK1", "K1\\SK1\\SSK2", "K1\\SK1\\SSK1"};
        assertThat(result, is(expected));
    }
}
