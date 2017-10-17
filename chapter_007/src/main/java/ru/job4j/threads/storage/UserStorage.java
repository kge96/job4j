package ru.job4j.threads.storage;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Class for creating user storage.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 17.10.2017.
 */
@ThreadSafe
public class UserStorage {
    /**
     * User storages.
     */
    private ConcurrentHashMap<Integer, User> storage = new ConcurrentHashMap<>();

    /**
     * Add new User.
     * @param user - user.
     */
    public void add(User user) {
        storage.put(user.getId(), user);
    }

    /**
     * Update user in the storage.
     * @param user - user.
     */
    public void update(User user) {
        if (storage.contains(user)) {
            storage.get(user.getId()).setAmount(user.getAmount());
        }
    }

    /**
     * Delete user from storage.
     * @param id - user id.
     */
    public synchronized void delete(int id) {
        if (storage.containsKey(id)) {
            storage.remove(id);
        }

    }

    /**
     * Return user by specified id.
     * @param id - user id.
     * @return User.
     */
    public User getUser(int id) {
        return storage.get(id);
    }

    /**
     * Return storage size.
     * @return int.
     */
    public int getStorageSize() {
        return storage.size();
    }

    /**
     * Transfer from user 1 amount to user 2 amount.
     * @param fromId - user id which get amount.
     * @param told - user id which take amount.
     * @param amount - amount.
     */
    public synchronized void transfer(int fromId, int told, int amount) {
        User fromUser = storage.get(fromId);
        User toUser = storage.get(told);
        if (isTransferPossible(fromUser, toUser, amount)) {
            fromUser.setAmount(fromUser.getAmount() - amount);
            toUser.setAmount(toUser.getAmount() + amount);
        }

    }

    /**
     * Check that transfer is possible.
     * @param user1 - user 1.
     * @param user2 - user 2.
     * @param amount - amount.
     * @return boolean.
     */
    private boolean isTransferPossible(User user1, User user2, int amount) {
        return user1 != null && user2 != null && user1.getAmount() >= amount;
    }
}
