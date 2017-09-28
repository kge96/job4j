package ru.job4j.bank;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.LinkedList;

/**
 * Class for data management.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 27.09.2017.
 */
public class BankData {
    /**
     * Users data storage.
     */
    private Map<User, List<Account>> dataBank = new HashMap<>();
    /**
     * Data storage iterator.
     */
    private Iterator<Map.Entry<User, List<Account>>> itr = dataBank.entrySet().iterator();


    /**
     * Add new user at storage.
     * @param user - user.
     */
    public void addUser(User user) {
        if (this.dataBank.containsKey(user)) {
            return;
        }
        this.dataBank.put(user, new LinkedList<>());
    }

    /**
     * Delete user from data storage.
     * @param user - user.
     */
    public void deleteUser(User user) {
        this.dataBank.remove(user);
    }

    /**
     * Add new account for specified user.
     * @param user - user.
     * @param account - account.
     */
    public void addAccountToUser(User user, Account account) {
        List<Account> accountList = this.dataBank.get(user);
        accountList.add(account);
    }

    /**
     * Delete specified account from specified user.
     * @param user - user.
     * @param account - account.
     */
    public void deleteAccountFromUser(User user, Account account) {
        List<Account> accountList = this.dataBank.get(user);
        accountList.remove(account);
    }

    /**
     * Return all user accounts.
     * @param user - user.
     * @return List<Account>.
     */
    public List<Account> getUserAccount(User user) {
        return this.dataBank.get(user);
    }

    /**
     * Transfer money from srcUser account to dstUser account.
     * @param srcUser - source user.
     * @param srcAccount - source user account.
     * @param dstUser - destination user.
     * @param dstAccount - destination user account.
     * @param amount - count of money.
     * @return boolean.
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) {
        boolean result = false;
        Account src = null;
        Account dst = null;

        if (srcUser.equals(dstUser)) {
            for (Account account : this.dataBank.get(srcUser)) {
                if (account.equals(srcAccount)) {
                    src = account;
                }
                if (account.equals(dstAccount)) {
                    dst = account;
                }
            }
        } else {
            for (Account account : this.dataBank.get(srcUser)) {
                if (account.equals(srcAccount)) {
                    src = account;
                }
            }
            for (Account account : this.dataBank.get(dstUser)) {
                if (account.equals(dstAccount)) {
                    dst = account;
                }
            }
        }

        if (src != null && dst != null && src.getValue() > amount) {
            src.setValue(src.getValue() - amount);
            dst.setValue(dst.getValue() + amount);
            result = true;
        }
        return result;
    }

    /**
     * Return data storage. Need for tests.
     * @return Map.
     */
    public Map<User, List<Account>> getDataBank() {
        return this.dataBank;
    }
}
