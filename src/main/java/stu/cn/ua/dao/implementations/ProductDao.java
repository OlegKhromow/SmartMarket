package stu.cn.ua.dao.implementations;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import stu.cn.ua.dao.interfaces.ProductDaoInterface;
import stu.cn.ua.model.Category;
import stu.cn.ua.model.Product;
import stu.cn.ua.model.SuperMarket;

import java.util.List;

public class ProductDao implements ProductDaoInterface {
    private final Session session;

    public ProductDao(Session session) {
        this.session = session;
    }


    @Override
    public void saveOrUpdateProduct(Product product) {
        Transaction transaction = session.beginTransaction();
        session.persist(product);
        transaction.commit();
    }

    @Override
    public Product getProductById(int id) {
        return session.find(Product.class, id);
    }

    @Override
    public List<Product> getProductsInSupermarketByCategory(SuperMarket market, Category category) {
        Query<Product> query = session.createQuery("from Product where supermarket = :market and category = :categ", Product.class);
        return query.setParameter("market", market).setParameter("categ", category).list();
    }

    @Override
    public List<Product> getAllProductsInSupermarket(SuperMarket market) {
        Query<Product> query = session.createQuery("from Product where supermarket = :market", Product.class);
        return query.setParameter("market", market).list();
    }

    @Override
    public long getProductsCountInSupermarket(SuperMarket market) {
        Query<Long> query = session.createQuery("select count(*) from Product where supermarket = :market", Long.class);
        return query.setParameter("market", market).uniqueResult();
    }

    @Override
    public long cleanExpiredProductsInSupermarket(SuperMarket market) {
        Query<Product> query = session.createQuery("from Product where expirationDate < current_date and supermarket = :market", Product.class);
        List<Product> productList = query.setParameter("market", market).list();
        productList.forEach(product -> {
            product.setCount(0);
            product.setExpirationDate(null);
            saveOrUpdateProduct(product);
        });
        return productList.size();
    }

    @Override
    public List<Product> getEndedProductsInSupermarket(SuperMarket market) {
        Query<Product> query = session.createQuery("from Product where supermarket = :market and count < 5", Product.class);
        return query.setParameter("market", market).list();
    }

    @Override
    public void deleteProduct(int id) {
        Product product = getProductById(id);
        Transaction transaction = session.beginTransaction();
        session.remove(product);
        transaction.commit();
    }
}
