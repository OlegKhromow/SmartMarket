package stu.cn.ua.dao.implementations;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import stu.cn.ua.dao.interfaces.SuperMarketDaoInterface;
import stu.cn.ua.model.SuperMarket;

import java.util.List;

public class SuperMarketDao implements SuperMarketDaoInterface {
    private final Session session;

    public SuperMarketDao(Session session) {
        this.session = session;
    }

    @Override
    public void saveOrUpdateSuperMarket(SuperMarket superMarket) {
        Transaction transaction = session.beginTransaction();
        session.persist(superMarket);
        transaction.commit();
    }

    @Override
    public SuperMarket getSuperMarketById(int id) {
        return session.find(SuperMarket.class, id);
    }

    @Override
    public List<SuperMarket> getSuperMarketByName(String name) {
        Query<SuperMarket> query = session.createQuery("from SuperMarket where name like :marketName", SuperMarket.class);
        return query.setParameter("marketName", "%" + name + "%").list();
    }

    @Override
    public List<SuperMarket> getAllSuperMarkets() {
        return session.createQuery("from SuperMarket ", SuperMarket.class).list();
    }

    @Override
    public void deleteSuperMarket(int id) {
        SuperMarket superMarket = getSuperMarketById(id);
        Transaction transaction = session.beginTransaction();
        session.remove(superMarket);
        transaction.commit();
    }
}
