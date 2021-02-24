package modelsDAO;

import manager.DAO;
import models.HallInfo;
import org.hibernate.criterion.Restrictions;

import java.util.List;


public class HallInfoDAO {

    public static List<?> getList(int num) {
        return DAO.getSession().createCriteria(HallInfo.class).setMaxResults(num).list();
    }

    public static HallInfo findById(int ID) {
        return (HallInfo) DAO.getSession().createCriteria(HallInfo.class).
                add(Restrictions.eq("hallCode", ID)).uniqueResult();
    }
}
