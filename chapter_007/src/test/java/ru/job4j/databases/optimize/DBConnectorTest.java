package ru.job4j.databases.optimize;

import org.junit.Test;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

/**
 * Class for DBConnector testing.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 28.10.2017.
 */
public class DBConnectorTest {
    /**
     * Testing optimize.
     * @throws TransformerException - exception.
     * @throws ParserConfigurationException - exception.
     */
    @Test
    public void whenSetOneMillionThenReturnSummFromOneToMillion() throws TransformerException, ParserConfigurationException {
        long startTime = System.currentTimeMillis();
        ProgramRunner runner = new ProgramRunner();
        runner.startProgram(1_000);
        long finishTime = System.currentTimeMillis() - startTime;

        if (finishTime < 300_000) {
            System.out.println("Good handler time - " + finishTime + " ms");
        } else {
            System.out.println("Bad handler time " + finishTime + " ms");
        }

    }
}
