package ru.job4j.inheritence;

import org.junit.Test;
import ru.job4j.inheritance.Doctor;
import ru.job4j.inheritance.Engineer;
import ru.job4j.inheritance.Person;
import ru.job4j.inheritance.Teacher;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class for testing Professions.
 * @author gkuznetsov.
 * @since 19.09.17.
 * @version 0.1.
 */

public class ProfessionTest {
    /**
     * Testing teacher job.
     */
    @Test
    public void whenTeacherTeachPersonThenGetMessage() {
        Teacher teacher = new Teacher("Федор");
        Person person = new Person("Иван");
        String result = teacher.teachStudent(person);
        String expected = "Учитель Федор учит Ивана";
        assertThat(result, is(expected));
    }

    /**
     * Testing doctor job.
     */
    @Test
    public void whenDoctorTreatPersonThenGetMessage() {
        Doctor doctor = new Doctor("Андрей");
        Person person = new Person("Владимир");
        String result = doctor.treatPatient(person);
        String expected = "Доктор Андрей лечит Владимира";
        assertThat(result, is(expected));
    }

    /**
     * Testing engineer job.
     */
    @Test
    public void whenEngineerGetPersonForJobThenGetMessage() {
        Engineer engineer = new Engineer("Александр");
        Person person = new Person("Иван");
        String result = engineer.getNewSpecialist(person);
        String expected = "Инженер Александр берёт на работу Ивана";
        assertThat(result, is(expected));
    }
}
