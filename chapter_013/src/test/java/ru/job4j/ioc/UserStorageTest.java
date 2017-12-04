package ru.job4j.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.job4j.ioc.storages.MemoryStorage;

import static org.junit.Assert.assertNotNull;

/**
 * Class for testing UserStorage.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 04.12.2017.
 */
public class UserStorageTest {
    /**
     * Test.
     */
    @Test
    public void whenAddUserShouldAddIt() {
        MemoryStorage memory = new MemoryStorage();
        UserStorage storage = new UserStorage(memory);
        storage.add(new User("Vasiliy"));
    }
    /**
     * Test.
     */
    @Test
    public void whenLoadMemoryStorageShouldGetMemoryStorageFromContext() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        MemoryStorage memory = context.getBean(MemoryStorage.class);
        assertNotNull(memory);
    }
    /**
     * Test.
     */
    @Test
    public void whenLoadUserStorageShouldGetItFromContext() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserStorage memory = context.getBean(UserStorage.class);
        memory.add(new User("Ivan"));
        assertNotNull(memory);
    }
}