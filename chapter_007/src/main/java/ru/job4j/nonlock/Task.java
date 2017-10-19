package ru.job4j.nonlock;

/**
 * Class task.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 19.10.2017.
 */
public class Task implements Comparable<Task> {
    /**
     * String name.
     */
    private String name;
    /**
     * Task id.
     */
    private int taskID;
    /**
     * Task version.
     */
    private volatile int version = 0;

    /**
     * Task constructor.
     * @param taskID - task id.
     * @param name - task name.
     */
    public Task(int taskID, String name) {
        this.taskID = taskID;
        this.name = name;
    }

    /**
     * Return task name.
     * @return String.
     */
    public String getName() {
        return name;
    }

    /**
     * Return version.
     * @return int.
     */
    public int getVersion() {
        return version;
    }

    /**
     * Return task id.
     * @return int.
     */
    public int getTaskID() {
        return taskID;
    }

    /**
     * Set name.
     * @param name - new name.
     */
    public void  setName(String name) {
        this.name = name;
    }

    /**
     * Up version.
     */
    public void upVersion() {
        this.version++;
    }

    /**
     * Equals.
     * @param o - compared object.
     * @return boolean.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Task task = (Task) o;

        if (taskID != task.taskID) {
            return false;
        }
        if (version != task.version) {
            return false;
        }
        return name != null ? name.equals(task.name) : task.name == null;
    }

    /**
     * Hash code.
     * @return int.
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + taskID;
        result = 31 * result + version;
        return result;
    }

    /**
     * Comparator.
     * @param o - comparing object.
     * @return int.
     */
    @Override
    public int compareTo(Task o) {
        return this.version == o.version ? 0 : -1;
    }
}
