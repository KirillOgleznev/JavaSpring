package modelsDAO;
import manager.DAO;

import models.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;


public class SessionDAO {

    public static List<?> getList(int num) {
        return DAO.getSession().createCriteria(Session.class).setMaxResults(num).list();
    }

    public static Session findById(int ID) {
        return (Session) DAO.getSession().createCriteria(Session.class).
                add(Restrictions.eq("sessionCode", ID)).uniqueResult();
    }
}
