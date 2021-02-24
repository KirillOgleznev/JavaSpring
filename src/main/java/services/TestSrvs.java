package services;

import manager.DAO;


public class TestSrvs extends DAO {

    public static String getName()
    {
        String query = "SELECT name FROM halls WHERE hall_code = :id";
        return getSession().createSQLQuery(query).setInteger("id", 1).list().get(0).toString();
    }

    public static String getRange()
    {
        String query = "SELECT name FROM halls WHERE hall_code BETWEEN :startID AND :endID";
        return getSession().createSQLQuery(query).setInteger("startID", 1).setInteger("endID", 1000).list().toString();
    }

    public static void createNew()
    {
        String query = "INSERT INTO halls (cinema_code, hall_code, name, active) VALUES ('A24', DEFAULT, 'Тестовый зал', DEFAULT)";
        getSession().createSQLQuery(query).executeUpdate();
        begin();
        commit();
    }
}
