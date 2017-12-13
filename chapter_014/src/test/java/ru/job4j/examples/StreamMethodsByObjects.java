package ru.job4j.examples;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for test examples.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 12.12.2017.
 */
public class StreamMethodsByObjects {
    /**
     *List.
     */
    private List<Person> people = Arrays.asList(
        new Person("Вася", 16, Sex.MEN),
        new Person("Петя", 23, Sex.MEN),
        new Person("Елена", 42, Sex.WOMEN),
        new Person("Иван Иванович", 69, Sex.MEN)
    );

    /**
     * Test.
     */
    @Test
    public void getMenFrom18To27() {
        List<Person> personList = people.stream().filter(p -> p.getAge() >= 18 && p.getAge() < 27 && p.getSex() == Sex.MEN).collect(Collectors.toList());
        assertThat(personList.get(0).getName(), is("Петя"));
    }
    /**
     * Test.
     */
    @Test
    public void findAvgAgeFromMen() {
        Double avgMenAge = people.stream().filter(p -> p.getSex() == Sex.MEN).mapToInt(Person::getAge).average().getAsDouble();
        assertThat(avgMenAge, is(36.0));
    }
    /**
     * Test.
     */
    @Test
    public void getWorkPeople() {
        long countOfPeople = people.stream()
                .filter(p -> p.getAge() >= 18)
                .filter(p -> (p.getSex() == Sex.WOMEN && p.getAge() < 55) || (p.getSex() == Sex.MEN && p.getAge() < 60))
                .count();
        assertThat(countOfPeople, is(2L));
    }
}
