package ru.job4j.service;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.domain.Car;
import ru.job4j.domain.modules.*;
import ru.job4j.web.CarController;

import java.util.ArrayList;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Class
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 09.12.2017.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CarController.class)
public class CarControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CarService service;

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void whenGetCarsThenPageCars() throws Exception {
        given(
                this.service.getAll()
        ).willReturn(
                new ArrayList<Car>(Lists.newArrayList(
                        new Car(new Body("Sedan"),
                        new Producer("BMV"),
                        new Engine("1.8", new Fuel("Gasolin")),
                        new Transmission("Mechanics"))))
        );
        this.mvc.perform(
                get("/cars").accept(MediaType.TEXT_HTML)
        ).andExpect(
                status().isOk()
        ).andExpect(
                view().name("cars")
        );
    }

}
