package ru.job4j.threads;

import org.junit.Test;

/**
 * Class for testing ProgramTimeControl.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 13.10.2017.
 */

public class ProgramTimeControlTest {
    /**
     * Test when program work faster then specified time.
     */
    @Test
    public void whenTimeProgramIsOkThenGetResult() {
        ProgramTimeControl ptc = new ProgramTimeControl(800);
        ptc.startProgram();
    }

    /**
     * Test when program work slowly then specified time.
     */
    @Test
    public void whenTimeProgramIsOutThenThreadStop() {
        ProgramTimeControl ptc2 = new ProgramTimeControl(1400);
        ptc2.startProgram();
    }
}
