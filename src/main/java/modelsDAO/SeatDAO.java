package modelsDAO;

import manager.DAO;
import models.Seat;
import org.hibernate.criterion.Restrictions;

import java.util.List;


public class SeatDAO {

    public static List<?> getList(int num) {
        return DAO.getSession().createCriteria(Seat.class).setMaxResults(num).list();
    }

    public static Seat findById(int hallCode, int row, int seatNum) {
        return (Seat) DAO.getSession().createCriteria(Seat.class).add(Restrictions.and(
                Restrictions.eq("hallCode", hallCode),
                Restrictions.eq("row", row),
                Restrictions.eq("seatNum", seatNum))).uniqueResult();
    }
}
