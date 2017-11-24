package ru.job4j.io;


import org.junit.Test;


import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * Class for filter testing.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 21.11.2017.
 */
public class StreamAbusesFilterTEst {
    /**
     * Test Filter.
     */
    @Test
    public void test() {
        StreamAbusesFilter filter = new StreamAbusesFilter();
        String str = "Hello my world again!";
        String[] abuses = {"my", "again!"};
        InputStream in = new ByteArrayInputStream(str.getBytes());
        OutputStream out = new ByteArrayOutputStream();

        String result = filter.dropAbuses(in, out, abuses);

        assertThat(result, is("Hello world"));
    }
}
