package ru.job4j.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.job4j.models.User;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


/**
 * Class for cr.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 05.12.2017.
 */
@Controller
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    final List<User> userList = new CopyOnWriteArrayList<User>();

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String showItems(ModelMap model) {
        model.addAttribute("users", this.userList);
        return "users";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String addItem(@ModelAttribute User user) {
        this.userList.add(user);
        return "redirect:users.do";
    }

}
