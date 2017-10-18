package ru.job4j.threads;

import org.junit.Test;
import ru.job4j.threads.analizator.ProgramTimeControl;

/**
 * Class for testing ProgramTimeControl.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 13.10.2017.
 */

public class ProgramTimeControlTest {
    /**
     * Increment when program work faster then specified time.
     */
    @Test
    public void whenTimeProgramIsOkThenGetResult() {
        ProgramTimeControl ptc = new ProgramTimeControl(800);
        ptc.startProgram();
    }

    /**
     * Increment when program work slowly then specified time.
     */
    @Test
    public void whenTimeProgramIsOutThenThreadStop() {
        ProgramTimeControl ptc2 = new ProgramTimeControl(1400);
        ptc2.startProgram();
    }
}
