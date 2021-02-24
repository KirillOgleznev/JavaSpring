import manager.DAO;
import models.*;
import modelsDAO.CinemaDAO;
import modelsDAO.HallDAO;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.myapp.garden.ConfigurationFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public class main {

    public static void main(String[] args) {


//        DAO.begin();
//
//        //Cinema edit = CinemaDAO.findById("1");
//        Cinema qwe = new Cinema();
//        qwe.setCinemaCode("1");
//        qwe.setName("2");
//        qwe.setAddress("2");
//        qwe.setPhoneNumber("2");
//
//
//        //CinemaDAO.delete(edit);
//
//
//        DAO.getSession().update(qwe);
//
//        DAO.commit();
//        DAO.close();


//        Cinema entity = CinemaDAO.findById("TEST");
//        Hall test = new Hall();
//        test.setCinemaCode("TEST");
//        test.setName("test");
//        test.setCondition(false);
//        HallDAO.insert(test);
//
//        //entity.delete();
//        System.out.println("-----------------------------------------------------------\n\n\n");
//        List<?> tmp = CinemaDAO.searcher("TEST","TEST","TEST","TEST");
//        for (Object item : tmp)
//            System.out.println(item);
//
//        int ID = entity.getHalls().iterator().next().getHallCode();
//        HallDAO.delete(HallDAO.findById(ID));
//        entity.getHalls().forEach(System.out::println);
//
//        List<?> tmpList = DAO.getSession().createCriteria(Hall.class).add(Restrictions.eq("name", "test")).list();
//        for (Object item : tmpList)
//            System.out.println(item);
        ArrayList<int> list = new ArrayList<int>();

    }
    static void increase(int x){

        x *= 3;

    }
}
