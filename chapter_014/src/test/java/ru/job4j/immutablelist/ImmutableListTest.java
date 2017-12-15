package ru.job4j.immutablelist;

import org.junit.Test;
import ru.job4j.examples.Person;
import ru.job4j.examples.Sex;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing immutable collection.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 14.12.2017.
 */
public class ImmutableListTest {
    /**
     * Test.
     */
    @Test
    public void whenGetObjectFromCollectionAndChangeItThenAtCollectionItDoesNotChange() {
        Person person1 = new Person("Vasya", 13, Sex.MEN);
        Person person2 = new Person("Lena", 18, Sex.WOMEN);
        Person person3 = new Person("Ivan", 9, Sex.MEN);

        Person[] people = new Person[] {person1, person2, person3};

        ImmutableList<Person> integers = new ImmutableList<>(people);
        integers.getElement(1).setName("Olga");

        assertThat(integers.getElement(1).getName(), is("Lena"));
    }
    /**
     * Test.
     */
    @Test
    public void whenCollectionAndChangeItThenCollectionItDoesNotChange() {
        Person person1 = new Person("Vasya", 13, Sex.MEN);
        Person person2 = new Person("Lena", 18, Sex.WOMEN);
        Person person3 = new Person("Ivan", 9, Sex.MEN);
        Person person4 = new Person("Nick", 22, Sex.MEN);

        Person[] people = new Person[] {person1, person2, person3, person4};

        ImmutableList<Person> integers = new ImmutableList<>(people);
        Person[] people1 = integers.getList();
        people1[0].setName("Fedor");

        assertThat(integers.getElement(0).getName(), is("Vasya"));
    }
}
