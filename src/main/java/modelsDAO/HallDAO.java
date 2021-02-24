package modelsDAO;
import manager.DAO;
import models.Cinema;
import models.Hall;
import org.hibernate.criterion.Restrictions;
import java.util.List;


public class HallDAO {

    public static List<?> getList(int num) {
        return DAO.getSession().createCriteria(Hall.class).setMaxResults(num).list();
    }

    public static Hall findById(int ID) {
        return (Hall) DAO.getSession().createCriteria(Hall.class).
                add(Restrictions.eq("hallCode", ID)).uniqueResult();
    }

    public static void insert(Hall ogj)
    {
        ogj.setCinemaCodeKey(CinemaDAO.findById(ogj.getCinemaCode()));
        DAO.getSession().merge(ogj);
        DAO.getSession().flush();
    }

    public static void delete(Hall ogj)
    {
        DAO.getSession().delete(ogj);
        DAO.getSession().flush();
    }
}
