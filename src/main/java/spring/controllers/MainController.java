package spring.controllers;

import manager.DAO;
import models.Cinema;
import modelsDAO.CinemaDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {

    @GetMapping("/")
    public ModelAndView allCinemas(@RequestParam(required = false) String id) {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("cinemaList", CinemaDAO.findAll());

        if (CinemaDAO.findById(id) != null)
            mav.addObject("cinema", CinemaDAO.findById(id));
        else
            mav.addObject("cinema", new Cinema());
        return mav;
    }

    @PostMapping(value = "/")
    public ModelAndView updateCinema(@ModelAttribute("cinema") Cinema cinema) {
        ModelAndView mav = new ModelAndView("redirect:/#");
        var err = CinemaDAO.insert(cinema);
        if (!err.equals("")) {
            mav.setViewName("index");
            mav.addObject("cinemaList", CinemaDAO.findAll());
            mav.addObject("cinema", cinema);

            switch (err) {
                case "Некорректный ID" -> mav.addObject("errID", err);
                case "Invalid name" -> mav.addObject("errName", err);
                case "Invalid address" -> mav.addObject("errAddress", err);
                case "Некорректный номер телефона" -> mav.addObject("errNumber", err);
            }
            return mav;
        }
        DAO.transaction();
        return mav;
    }

//    @RequestMapping("/new")
//    public ModelAndView newCinema() {
//        ModelAndView mav = new ModelAndView("new");
//        mav.addObject("cinema", new Cinema());
//        return mav;
//    }
//
//    @RequestMapping(value = "/new", method = RequestMethod.POST)
//    public ModelAndView saveCinema(@ModelAttribute("cinema") Cinema cinema) {
//        ModelAndView mav = new ModelAndView("new");
//        var err = CinemaDAO.insert(cinema);
//        if (!err.equals("")) {
//            mav.addObject("err", err);
//            return mav;
//        }
//        DAO.transaction();
//        mav.setViewName("redirect:/");
//        return mav;
//    }

//    @RequestMapping(value = "/edit")
//    public ModelAndView editCinema(@RequestParam String id) {
//        ModelAndView mav = new ModelAndView("edit");
//        mav.addObject("cinema", CinemaDAO.findById(id));
//        return mav;
//    }

    @PostMapping("/delete")
    public String deleteCustomerForm(@RequestParam String Id,
                                           @RequestParam String action) {
        if (action.equals("delete")) {
            CinemaDAO.delete(CinemaDAO.findById(Id));
            DAO.transaction();
        }
        return "redirect:/";
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam String keyword) {
        var result = CinemaDAO.searcher(keyword);
        ModelAndView mav = new ModelAndView("search");
        mav.addObject("result", result);
        return mav;
    }
}