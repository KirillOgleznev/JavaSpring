package spring.controllers;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring.security.users.User;
import spring.security.users.UserService;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public ModelAndView registration() {
        ModelAndView mav = new ModelAndView("registration");
        mav.addObject("userForm", new User());

        return mav;
    }

    @PostMapping("/registration")
    public ModelAndView addUser(@ModelAttribute("userForm") @Valid User userForm, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView("registration");
        if (bindingResult.hasErrors()) {
            return mav;
        }
        if (!userService.saveUser(userForm)) {
            mav.addObject("usernameError", "Пользователь с таким именем уже существует");
            return mav;
        }
        mav.setViewName("redirect:/");
        return mav;
    }
}
