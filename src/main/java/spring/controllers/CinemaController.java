package spring.controllers;

import manager.DAO;
import models.Cinema;
import models.Hall;
import modelsDAO.CinemaDAO;
import modelsDAO.HallDAO;
import org.json.HTTP;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cinema")
public class CinemaController {

    @GetMapping
    public String list() {
        Cinema entity = CinemaDAO.findById("TEST");
        JSONObject answer = new JSONObject();

        answer.put("Method", "");
        answer.put("Request-URI", "");
        answer.put("HTTP-Version", "");

        answer.put("Кинотеатр: ", entity.toString());

        Hall test = new Hall();
        test.setCinemaCode("TEST");
        test.setName("test");
        test.setCondition(false);
        HallDAO.insert(test);

        var item = entity.getHalls();
        for (var i = 0; i < item.size(); i++)
            answer.put("Зал: " + i, item.toString());

        DAO.begin();
        DAO.commit();
        DAO.close();

        return HTTP.toString(answer);
    }
}
