package ru.job4j.threads;

/**
 * Class for start program.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 13.10.2017.
 */
public class ProgramTimeControl {
    /**
     * Program work time.
     */
    private long workTime = 0;

    /**
     * Constructor.
     * @param workTime - program work time.
     */
    public ProgramTimeControl(long workTime) {
        this.workTime = workTime;
    }

    /**
     * Start program.
     */
    public void startProgram() {
        Thread doCountCars = new Thread(new CountChar("Раз, два, три - елочка гори"));
        Thread startTimer = new Thread(new Time(workTime));
        doCountCars.setDaemon(true);

        doCountCars.start();
        startTimer.start();

        try {
            Thread.currentThread().sleep(workTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (!doCountCars.isInterrupted()) {
            doCountCars.interrupt();
//            doCountCars.stop();
        }
    }
}
