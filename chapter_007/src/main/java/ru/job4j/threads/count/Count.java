package ru.job4j.threads.count;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Class for creating Count instances.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 17.10.2017.
 */
@ThreadSafe
public class Count {
    /**
     * Value.
     */
    @GuardedBy("value")
    private int value = 0;

    /**
     * Incrementing value.
     * @return int.
     */
    public int incremant() {
        return this.value++;
    }
}
