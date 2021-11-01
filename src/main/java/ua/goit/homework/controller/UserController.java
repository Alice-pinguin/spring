package ua.goit.homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ua.goit.homework.entity.User;
import ua.goit.homework.service.UserService;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping(path = "/user")

public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "registration";
        }
        userService.register (user);
        return "redirect:/login";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(path = "/findAllUsers")
    public ModelAndView showAllUsersPage(ModelAndView model) {
        Iterable<User> users = userService.getRepository ().findAll ();
        model.addObject ("users", users);
        model.setViewName ("findAllUsers");
        return model;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(path = "/delete")
    public RedirectView delete(@RequestParam("id") UUID uuid) {
        Optional<User> user = userService.getRepository ().findById (uuid);
        userService.getRepository ().delete (user.get ());
        return new RedirectView ("/user/findAllUsers");
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(path = "/findUserById")
    public ModelAndView findUserById(@RequestParam("id") UUID uuid, ModelAndView model) {
        Optional<User> user = userService.getRepository ().findById (uuid);
        model.addObject ("user", user);
        model.setViewName ("findUserById");
        return model;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(path = "/form/save")
    public String showUpdateUserForm(@RequestParam("id") UUID uuid, Model model) {
        Optional<User> user = userService.getRepository ().findById (uuid);
        model.addAttribute ("user", user);
        return "updateUserForm";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(path = "/form/save")
    public RedirectView save(User user) {
        userService.save (user);
        return new RedirectView ("/user/findAllUsers");
    }

    @ModelAttribute("userForm")
    public User defaultUser() {
        return new User ();
    }
}
