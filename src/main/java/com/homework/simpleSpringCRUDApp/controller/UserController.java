package com.homework.simpleSpringCRUDApp.controller;

import com.homework.simpleSpringCRUDApp.model.User;
import com.homework.simpleSpringCRUDApp.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Data
@Controller
public class UserController {
    private final UserService userService;// экземпляр для предоставления методов работы с User

    @Autowired

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user-list"; // Отображение списка пользователей.
    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create"; // Отображение формы для создания нового пользователя и передача данных.
    }

    @PostMapping("/user-create")
    public String addUser(User user) {
        userService.saveUser(user);
        return "redirect:/users"; // Перенаправление на страницу с обновлённым списком пользователей
    }

    @GetMapping("/user-delete/{id}")
    public String deleteUserById(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/users"; // Перенаправление на страницу с обновлённым списком пользователей
    }


    @GetMapping("/user-update/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-update"; // Отображение формы для обновления данных пользователя и передача данных.
    }

    @PostMapping("/user-update")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/users"; // Перенаправление на страницу с обновлённым списком пользователей
    }
}