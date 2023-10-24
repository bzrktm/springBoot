package ru.bzrktm.springBoot.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.bzrktm.springBoot.models.User;
import ru.bzrktm.springBoot.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String start() {
        return "index";
    }

    @GetMapping("/user-id")
    public String getById(@RequestParam(value = "id", required = false) long id, Model model) {
        model.addAttribute("user", userService.getById(id));
    return "users/id";
    }

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "users/all";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/new";
        }
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("update/id")
    public String edit(@RequestParam("id") long id, Model model){
        model.addAttribute("user", userService.getById(id));
        return "users/update";
    }

    @PatchMapping("id")
    public String updateUser(@RequestParam("id") long id, @ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "users/update";
        }
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("id") long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
