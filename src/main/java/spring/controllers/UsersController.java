package spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring.security.users.UserService;

@Controller
public class UsersController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ModelAndView userList() {
        ModelAndView mav = new ModelAndView("users");
        mav.addObject("allUsers", userService.allUsers());
        return mav;
    }

    @PostMapping("/users")
    public String deleteUser(@RequestParam int userId,
                             @RequestParam String action) {
        if (action.equals("delete")) {
            userService.deleteUser(userId);
        }
        return "redirect:/users";
    }
}
