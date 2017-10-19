package ru.job4j.nonlock;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Class for creating Cash.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 19.10.2017.
 */
public class Cash {
   /**
    * Task storage.
    */
   private ConcurrentHashMap<Integer, Task> taskMap = new ConcurrentHashMap();

   /**
    * Add new task to storage.
    * @param task - task.
    */
   public void add(Task task) {
      if (!taskMap.containsKey(task)) {
         taskMap.put(task.getTaskID(), task);
      }
   }

   /**
    * Update task at storage.
    * @param task - task.
    */
   public void update(Task task) {
      if (task.compareTo(taskMap.get(task.getTaskID())) == -1) {
         throw new RuntimeException("OplimisticException");
      } else {
         taskMap.get(task.getTaskID()).upVersion();
         taskMap.computeIfPresent(task.getTaskID(), (k, v) -> task);
      }
   }

   /**
    * Delete task from collection.
    * @param task - deleting task.
    */
   public void delete(Task task) {
      taskMap.remove(task);
   }

   /**
    * Return task.
    * @param id - id.
    * @return Task.
    */
   public Task getTask(int id) {
      return taskMap.get(id);
   }
}
