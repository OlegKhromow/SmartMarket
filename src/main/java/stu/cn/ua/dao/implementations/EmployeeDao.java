package stu.cn.ua.dao.implementations;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import stu.cn.ua.dao.interfaces.EmployeeDaoInterface;
import stu.cn.ua.model.Employee;
import stu.cn.ua.model.PostsENUM;
import stu.cn.ua.model.SuperMarket;

import java.util.List;

public class EmployeeDao implements EmployeeDaoInterface {
    private final Session session;

    public EmployeeDao(Session session) {
        this.session = session;
    }

    @Override
    public void saveOrUpdateEmployee(Employee employee) {
        Transaction transaction = session.beginTransaction();
        session.persist(employee);
        transaction.commit();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return session.find(Employee.class, id);
    }

    @Override
    public List<Employee> getEmployeeByName(String name) {
        Query<Employee> query = session.createQuery("from Employee where name like :employeeName", Employee.class);
        return query.setParameter("employeeName", "%" + name + "%").list();
    }

    @Override
    public List<Employee> getEmployeesInSupermarket(SuperMarket market) {
        Query<Employee> query = session.createQuery("from Employee where supermarket = :market", Employee.class);
        return query.setParameter("market", market).list();
    }

    @Override
    public long getEmployeesCountInSupermarket(SuperMarket market) {
        Query<Long> query = session.createQuery("select count (*) from Employee where supermarket = :market", Long.class);
        return query.setParameter("market", market).uniqueResult();
    }

    @Override
    public List<Employee> getEmployeesInSupermarketByPost(SuperMarket market, PostsENUM postsENUM) {
        Query<Employee> query = session.createQuery("from Employee where supermarket = :market and post = :post", Employee.class);
        return query.setParameter("market", market).setParameter("post", postsENUM).list();
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = getEmployeeById(id);
        Transaction transaction = session.beginTransaction();
        session.remove(employee);
        transaction.commit();
    }
}
