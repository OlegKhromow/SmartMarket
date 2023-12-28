package stu.cn.ua.dao.interfaces;

import stu.cn.ua.model.Category;
import stu.cn.ua.model.Product;
import stu.cn.ua.model.SuperMarket;

import java.util.List;

public interface ProductDaoInterface {
    void saveOrUpdateProduct(Product product);

    Product getProductById(int id);

    List<Product> getProductsInSupermarketByCategory(SuperMarket market, Category category);

    List<Product> getAllProductsInSupermarket(SuperMarket market);

    List<Product> getEndedProductsInSupermarket(SuperMarket market);

    long getProductsCountInSupermarket(SuperMarket market);

    long cleanExpiredProductsInSupermarket(SuperMarket market);

    void deleteProduct(int id);
}
