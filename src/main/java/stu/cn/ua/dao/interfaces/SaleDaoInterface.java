package stu.cn.ua.dao.interfaces;

import stu.cn.ua.model.Sale;
import stu.cn.ua.model.SuperMarket;

import java.sql.Timestamp;
import java.util.List;

public interface SaleDaoInterface {
    void saveOrUpdateSales(Sale sale);

    Sale getSaleById(int id);

    List<Sale> getSalesOnPeriodInSupermarket(SuperMarket market, Timestamp from, Timestamp to);

    void deleteSale(int id);
}
