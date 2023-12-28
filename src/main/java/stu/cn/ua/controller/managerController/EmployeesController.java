package stu.cn.ua.controller.managerController;

import stu.cn.ua.dao.HibernateUtil;
import stu.cn.ua.model.Employee;
import stu.cn.ua.model.PostsENUM;
import stu.cn.ua.model.SuperMarket;
import stu.cn.ua.view.ManagerView;
import stu.cn.ua.view.panels.EmployeesPanel;
import stu.cn.ua.view.panels.RegisterNewEmployeePanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class EmployeesController {
    private EmployeesPanel employeesPanel;
    private ManagerView managerView;
    private SuperMarket superMarket;
    private PostsENUM post;


    public EmployeesController(EmployeesPanel employeesPanel, ManagerView managerView, SuperMarket superMarket, PostsENUM post) {
        this.employeesPanel = employeesPanel;
        this.managerView = managerView;
        this.superMarket = superMarket;
        this.post = post;
        List<Employee> employees;
        if (post != null){
            employeesPanel.getPostComboBox().setVisible(true);
            employeesPanel.getPostComboBox().setSelectedItem(post);
            employeesPanel.getSearchTextField().setEnabled(false);
            employeesPanel.getSearchButton().setVisible(false);
            employeesPanel.getSearchLabel().setVisible(false);
            employees = HibernateUtil.getInstance().getEmployeeDao().getEmployeesInSupermarketByPost(superMarket, post);

        }else
            employees = HibernateUtil.getInstance().getEmployeeDao().getEmployeesInSupermarket(superMarket);
        fillTable(employees);
        initiallizeListeners();
    }

    private void fillTable(List<Employee> employees) {
        String[] title = {"ID", "Full name", "Post"};
        DefaultTableModel model = new DefaultTableModel(title, employees.size());
        AtomicInteger rownum = new AtomicInteger();
        employees.forEach(employee -> {
            model.setValueAt(employee.getId(), rownum.get(), 0);
            model.setValueAt(employee.getName(), rownum.get(), 1);
            model.setValueAt(employee.getPost(), rownum.getAndIncrement(), 2);
        });
        employeesPanel.getTable().setModel(model);
        employeesPanel.getTable().setDefaultEditor(employeesPanel.getTable().getColumnClass(0), null);
    }

    private void initiallizeListeners() {
        employeesPanel.getCancelButton().addActionListener(e -> cleanSearchOrExit());

        employeesPanel.getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Employee employee = HibernateUtil.getInstance().getEmployeeDao().getEmployeeById((Long) employeesPanel.getTable().getValueAt(employeesPanel.getTable().getSelectedRow(), 0));
                RegisterNewEmployeePanel registerNewEmployeePanel = new RegisterNewEmployeePanel(Long.toString(superMarket.getId()));
                managerView.changeJPanel(registerNewEmployeePanel);
                new RegisterEmployeeController(registerNewEmployeePanel, post != null ? 2 : 1, managerView, superMarket, employee);
            }
        });

        if (post != null)
          employeesPanel.getPostComboBox().addActionListener(e -> fillTable(HibernateUtil.getInstance().getEmployeeDao().getEmployeesInSupermarketByPost(superMarket, (PostsENUM) employeesPanel.getPostComboBox().getSelectedItem())));
        else
          employeesPanel.getSearchButton().addActionListener(e -> getData());
    }

    private void cleanSearchOrExit() {
        if(employeesPanel.getSearchTextField().getText().isEmpty())
            managerView.changeJPanel(managerView.getMainPanel());
        else {
            employeesPanel.getSearchTextField().setText("");
            fillTable(HibernateUtil.getInstance().getEmployeeDao().getEmployeesInSupermarket(superMarket));
        }
    }

    private void getData() {
        String searchString = employeesPanel.getSearchTextField().getText();
        if (searchString.isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Search field is empty", "Error", JOptionPane.ERROR_MESSAGE);
            fillTable(HibernateUtil.getInstance().getEmployeeDao().getEmployeesInSupermarket(superMarket));
            return;
        }
        boolean error = false;
        if (searchString.matches("\\d+")){
            Employee employee = HibernateUtil.getInstance().getEmployeeDao().getEmployeeById(Long.parseLong(searchString));
            error = employee == null;
            if (!error)
                fillTable(List.of(employee));
        }else {
            List<Employee> employees = HibernateUtil.getInstance().getEmployeeDao().getEmployeeByName(searchString);
            error = employees.isEmpty();
            if (!error)
                fillTable(employees);
        }
        if (error) {
            JOptionPane.showMessageDialog(new JFrame(), "No such employee was found", "Error", JOptionPane.ERROR_MESSAGE);
            employeesPanel.getSearchTextField().setText("");
        }
    }
}
