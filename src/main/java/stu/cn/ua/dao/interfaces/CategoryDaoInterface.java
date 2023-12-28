package stu.cn.ua.dao.interfaces;

import stu.cn.ua.model.Category;

import java.util.List;

public interface CategoryDaoInterface {
    void saveOrUpdateCategory(Category category);

    Category getCategoryById(int id);

    List<Category> getCategoryByName(String name);

    List<Category> getAllCategories();

    void deleteCategory(int id);

}
