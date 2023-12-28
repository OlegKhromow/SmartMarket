package stu.cn.ua.dao.interfaces;

import stu.cn.ua.model.SuperMarket;

import java.util.List;

public interface SuperMarketDaoInterface {
    void saveOrUpdateSuperMarket(SuperMarket superMarket);

    SuperMarket getSuperMarketById(int id);

    List<SuperMarket> getSuperMarketByName(String name);

    List<SuperMarket> getAllSuperMarkets();

    void deleteSuperMarket(int id);
}
