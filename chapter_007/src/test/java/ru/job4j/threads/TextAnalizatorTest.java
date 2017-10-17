package ru.job4j.threads;

import org.junit.Test;
import ru.job4j.threads.analizator.TextAnalizator;

/**
 * Class for testing threads.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 13.10.2017.
 */
public class TextAnalizatorTest {
    /**
     * Testing timeout.
     * @throws InterruptedException - exception.
     */
    @Test
    public void whenThereIstimeOutInOneOfMethodsThanGetTimeOutMessage() throws InterruptedException {
        TextAnalizator analizator = new TextAnalizator("Мама мыла раму ");
        analizator.analizeText();
        Thread.currentThread().sleep(1000);

    }

}
