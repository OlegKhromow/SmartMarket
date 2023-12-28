package stu.cn.ua.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import stu.cn.ua.dao.implementations.*;
import stu.cn.ua.dao.interfaces.*;

public class HibernateUtil {
    private static HibernateUtil instance;
    private Session session;

    private CategoryDaoInterface categoryDao;
    private EmployeeDaoInterface employeeDao;
    private SuperMarketDaoInterface superMarketDao;
    private ProductDaoInterface productDao;
    private SaleDaoInterface saleDao;


    public static HibernateUtil getInstance() {
        if(instance == null)
            instance = new HibernateUtil();
        return instance;
    }

    private Session getSession() {
        if (session == null){
            StandardServiceRegistry registry = null;
            try {
                registry = new StandardServiceRegistryBuilder().configure().build();
                MetadataSources sources = new MetadataSources(registry);
                Metadata metadata = sources.getMetadataBuilder().build();
                SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
                session = sessionFactory.openSession();
            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null)
                    StandardServiceRegistryBuilder.destroy(registry);
            }
        }
        return session;
    }

    public void closeSession() {
        if (session != null) {
            session.close();
        }
    }

    public CategoryDaoInterface getCategoryDao() {
        if (categoryDao == null)
            categoryDao = new CategoryDao(getSession());
        return categoryDao;
    }

    public EmployeeDaoInterface getEmployeeDao() {
        if (employeeDao == null)
            employeeDao = new EmployeeDao(getSession());
        return employeeDao;
    }

    public SuperMarketDaoInterface getSuperMarketDao() {
        if (superMarketDao == null)
            superMarketDao = new SuperMarketDao(getSession());
        return superMarketDao;
    }

    public ProductDaoInterface getProductDao() {
        if (productDao == null)
            productDao = new ProductDao(getSession());
        return productDao;
    }

    public SaleDaoInterface getSaleDao() {
        if (saleDao == null)
            saleDao = new SaleDao(getSession());
        return saleDao;
    }
}
