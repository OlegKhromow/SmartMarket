package stu.cn.ua.dao.implementations;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import stu.cn.ua.dao.interfaces.SaleDaoInterface;
import stu.cn.ua.model.Sale;
import stu.cn.ua.model.SuperMarket;

import java.sql.Timestamp;
import java.util.List;

public class SaleDao implements SaleDaoInterface {
    private final Session session;

    public SaleDao(Session session) {
        this.session = session;
    }

    @Override
    public void saveOrUpdateSales(Sale sale) {
        Transaction transaction = session.beginTransaction();
        session.persist(sale);
        transaction.commit();
    }

    @Override
    public Sale getSaleById(int id) {
        return session.find(Sale.class, id);
    }

    @Override
    public List<Sale> getSalesOnPeriodInSupermarket(SuperMarket market, Timestamp from, Timestamp to) {
        Query<Sale> query = session.createQuery("from Sale where superMarket = :market and date between :from and :to", Sale.class);
        query.setParameter("market", market).setParameter("from", from).setParameter("to", to);
        return query.list();
    }

    @Override
    public void deleteSale(int id) {
        Sale sale = getSaleById(id);
        Transaction transaction = session.beginTransaction();
        session.remove(sale);
        transaction.commit();
    }
}
