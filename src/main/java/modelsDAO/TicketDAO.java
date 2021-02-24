package modelsDAO;
import manager.DAO;
import models.Ticket;
import org.hibernate.criterion.Restrictions;

import java.util.List;


public class TicketDAO {

    public static List<?> getList(int num) {
        return DAO.getSession().createCriteria(Ticket.class).setMaxResults(num).list();
    }

    public static Ticket findById(int ID) {
        return (Ticket) DAO.getSession().createCriteria(Ticket.class).
                add(Restrictions.eq("ticketCode", ID)).uniqueResult();

    }
}
