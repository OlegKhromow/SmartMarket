package stu.cn.ua.dao.implementations;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import stu.cn.ua.dao.interfaces.CategoryDaoInterface;
import stu.cn.ua.model.Category;

import java.util.List;

public class CategoryDao implements CategoryDaoInterface {
    private final Session session;

    public CategoryDao(Session session) {
        this.session = session;
    }

    @Override
    public void saveOrUpdateCategory(Category category) {
        Transaction transaction = session.beginTransaction();
        session.persist(category);
        transaction.commit();
    }

    @Override
    public Category getCategoryById(int id) {
        return session.find(Category.class, id);
    }

    @Override
    public List<Category> getCategoryByName(String name) {
        Query<Category> query = session.createQuery("from Category where name like :categoryName", Category.class);
        return query.setParameter("categoryName", "%" + name + "%").list();
    }

    @Override
    public List<Category> getAllCategories() {
        return session.createQuery("from Category", Category.class).list();
    }

    @Override
    public void deleteCategory(int id) {
        Category category = getCategoryById(id);
        Transaction transaction = session.beginTransaction();
        session.remove(category);
        transaction.commit();
    }
}
