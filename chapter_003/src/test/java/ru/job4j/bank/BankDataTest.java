package ru.job4j.bank;

import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing BankData.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 27.09.2017.
 */
public class BankDataTest {
    /**
     * Testing add new user to data storage.
     */
    @Test
    public void whenAddNewUserThenThereIsInBankStorage() {
        User user = new User("Ivan", 2233444111L);
        User user2 = new User("Alexandr", 1122333444L);
        BankData bankData = new BankData();
        bankData.addUser(user);
        bankData.addUser(user2);
        boolean result = bankData.getDataBank().containsKey(user);
        assertThat(result, is(true));

    }

    /**
     * Testing remove user from data storage.
     */
    @Test
    public void whenDeleteUserThenUserDeleted() {
        User user = new User("Ivan", 2233444111L);
        User user2 = new User("Alexandr", 1122333444L);
        BankData bankData = new BankData();
        bankData.addUser(user);
        bankData.addUser(user2);
        bankData.deleteUser(user);
        boolean result = bankData.getDataBank().containsKey(user);

        assertThat(result, is(false));

    }

    /**
     * Testing add user account from data storage.
     */
    @Test
    public void whenAddAccountToUserThenAccountAdded() {
        User user = new User("Ivan", 2233444111L);
        User user2 = new User("Alexandr", 1122333444L);
        Account userAccount = new Account(1111, 22222L);
        BankData bankData = new BankData();
        bankData.addUser(user);
        bankData.addUser(user2);

        bankData.addAccountToUser(user, userAccount);
        Account result = bankData.getUserAccount(user).get(0);

        assertThat(result, is(userAccount));

    }
    /**
     * Testing delete user account from data storage.
     */
    @Test
    public void whenDeleteAccountToUserThenAccountAdded() {
        User user = new User("Ivan", 2233444111L);
        User user2 = new User("Alexandr", 1122333444L);
        Account userAccount = new Account(1111, 22222L);
        Account userAccount2 = new Account(1111, 2255552L);
        BankData bankData = new BankData();
        bankData.addUser(user);
        bankData.addUser(user2);

        bankData.addAccountToUser(user, userAccount);
        bankData.addAccountToUser(user, userAccount2);

        bankData.deleteAccountFromUser(user, userAccount);
        Account result = bankData.getUserAccount(user).get(0);

        assertThat(result, is(userAccount2));

    }
    /**
     * Testing transfer money from user1 account to user2 account.
     */
    @Test
    public void whenTransferMoneyFromUser1ToUser2ThenUser2HasMoreMoney() {
        User user1 = new User("Ivan", 2233444111L);
        User user2 = new User("Alexandr", 1122333444L);
        Account userAccount1 = new Account(1111, 15555L);
        Account userAccount2 = new Account(1111, 10000L);
        BankData bankData = new BankData();
        bankData.addUser(user1);
        bankData.addUser(user2);

        bankData.addAccountToUser(user1, userAccount1);
        bankData.addAccountToUser(user2, userAccount2);

        bankData.transferMoney(user1, userAccount1, user2, userAccount2, 111);

        double result = bankData.getUserAccount(user2).get(0).getValue();

        assertThat(result, is(1222.0));

    }
    /**
     * Testing when transfer more money then user1 has.
     */
    @Test
    public void whenTransferMoreMoneyThemHasUser1ThenNoTransfer() {
        User user1 = new User("Ivan", 2233444111L);
        User user2 = new User("Alexandr", 1122333444L);
        Account userAccount1 = new Account(1111, 15555L);
        Account userAccount2 = new Account(1111, 10000L);
        BankData bankData = new BankData();
        bankData.addUser(user1);
        bankData.addUser(user2);

        bankData.addAccountToUser(user1, userAccount1);
        bankData.addAccountToUser(user2, userAccount2);

        boolean result = bankData.transferMoney(user1, userAccount1, user2, userAccount2, 11111);

        assertThat(result, is(false));

    }
}
