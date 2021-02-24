package modelsDAO;

import manager.DAO;
import models.Cinema;
import org.hibernate.criterion.Restrictions;

import java.util.List;


public class CinemaDAO {

    public static List<?> getList(int num) {
        return DAO.getSession().createCriteria(Cinema.class).setMaxResults(num).list();
    }

    public static Cinema findById(String ID) {
        return (Cinema) DAO.getSession().createCriteria(Cinema.class)
                .add(Restrictions.eq("cinemaCode", ID)).uniqueResult();
    }

    public static List<?> searcher(String keyword) {
        keyword = '%' + keyword + '%';
        return DAO.getSession().createCriteria(Cinema.class)
                .add(Restrictions.or(
                        (Restrictions.like("cinemaCode", keyword)),
                        (Restrictions.like("name", keyword)),
                        (Restrictions.like("address", keyword)),
                        (Restrictions.like("phoneNumber", keyword)))).list();
    }

    public static List<?> findAll() {
        return DAO.getSession().createCriteria(Cinema.class).list();
    }

    public static List<?> findByName(String name) {
        return DAO.getSession().createCriteria(Cinema.class)
                .add(Restrictions.eq("name", name)).list();
    }

    public static String insert(Cinema obj) {
        var tmp =  checker(obj);
        if(!tmp.equals("")) return tmp;
        DAO.getSession().merge(obj);
        return "";
    }

    public static void delete(Cinema obj) {
        DAO.getSession().delete(obj);
    }

    public static String checker(Cinema obj){
        var a = obj.getCinemaCode().length();
        var b = obj.getCinemaCode().equals("");
        if (obj.getCinemaCode().equals("") || obj.getCinemaCode().length() > 4)
            return  "Некорректный ID";
        if (obj.getName().equals(""))
            return "Invalid name";
        if (obj.getAddress().equals(""))
            return "Invalid address";
        if (obj.getPhoneNumber().equals("") || !obj.getPhoneNumber().contains("+7"))
            return "Некорректный номер телефона";
        return "";
    }
}
