package stu.cn.ua.dao.interfaces;

import stu.cn.ua.model.Employee;
import stu.cn.ua.model.PostsENUM;
import stu.cn.ua.model.SuperMarket;

import java.util.List;

public interface EmployeeDaoInterface {
    void saveOrUpdateEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    List<Employee> getEmployeeByName(String name);

    List<Employee> getEmployeesInSupermarket(SuperMarket market);

    long getEmployeesCountInSupermarket(SuperMarket market);

    List<Employee> getEmployeesInSupermarketByPost(SuperMarket market, PostsENUM postsENUM);

    void deleteEmployee(Long id);
}
