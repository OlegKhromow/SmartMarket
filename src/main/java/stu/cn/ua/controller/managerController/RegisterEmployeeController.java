package stu.cn.ua.controller.managerController;

import stu.cn.ua.dao.HibernateUtil;
import stu.cn.ua.model.Employee;
import stu.cn.ua.model.PostsENUM;
import stu.cn.ua.model.SuperMarket;
import stu.cn.ua.view.ManagerView;
import stu.cn.ua.view.panels.EmployeesPanel;
import stu.cn.ua.view.panels.RegisterNewEmployeePanel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class RegisterEmployeeController {
    private final RegisterNewEmployeePanel registerNewEmployeePanel;
    private final ManagerView managerView;
    private SuperMarket superMarket;
    private int previousPanel;
    private Employee old_employee;

    public RegisterEmployeeController(RegisterNewEmployeePanel registerNewEmployeePanel, int previousPanel, ManagerView managerView, SuperMarket superMarket, Employee old_employee) {
        this.registerNewEmployeePanel = registerNewEmployeePanel;
        this.managerView = managerView;
        this.superMarket = superMarket;
        this.old_employee = old_employee;
        this.previousPanel = previousPanel;
        if (old_employee != null){
            registerNewEmployeePanel.initEditedFields(old_employee);
        }
        initiallizeListeners();
    }

    private void initiallizeListeners() {
        registerNewEmployeePanel.getCancelButton().addActionListener(e -> goToPreviousPanel());

        registerNewEmployeePanel.getPostComboBox().addActionListener(e -> {
            PostsENUM post = (PostsENUM) registerNewEmployeePanel.getPostComboBox().getSelectedItem();
            if (post == PostsENUM.Loader || post == PostsENUM.Cleaner || post == PostsENUM.Security){
                registerNewEmployeePanel.getEducationTextField().setText("");
                registerNewEmployeePanel.getEducationTextField().setEnabled(false);
            } else
                registerNewEmployeePanel.getEducationTextField().setEnabled(true);
        });
        if (old_employee != null)
          registerNewEmployeePanel.getDeleteButton().addActionListener(e -> deleteEmployee());

        registerNewEmployeePanel.getSaveButton().addActionListener(e -> getData());
    }

    private void deleteEmployee() {
        HibernateUtil.getInstance().getEmployeeDao().deleteEmployee(old_employee.getId());
        JOptionPane.showMessageDialog(new JFrame(), "Employee was deleted.", "Delete", JOptionPane.INFORMATION_MESSAGE);
        goToPreviousPanel();
    }

    private void getData() {
        boolean error = false;
        String name = registerNewEmployeePanel.getNameField().getText();
        if (name.isEmpty()) {
            registerNewEmployeePanel.getNameField().setBorder(new LineBorder(Color.red, 1));
            error = true;
        } else
            registerNewEmployeePanel.getNameField().setBorder(null);

        String address = registerNewEmployeePanel.getAddressField().getText();
        if (address.isEmpty()) {
            registerNewEmployeePanel.getAddressField().setBorder(new LineBorder(Color.red, 1));
            error = true;
        } else
            registerNewEmployeePanel.getAddressField().setBorder(null);

        PostsENUM post = (PostsENUM) registerNewEmployeePanel.getPostComboBox().getSelectedItem();
        String education = null;
        if (post == PostsENUM.Manager || post == PostsENUM.Cashier || post == PostsENUM.Merchandiser) {
            education = registerNewEmployeePanel.getEducationTextField().getText();
            if (education.isEmpty()) {
                registerNewEmployeePanel.getEducationTextField().setBorder(new LineBorder(Color.red, 1));
                error = true;
            } else
                registerNewEmployeePanel.getEducationTextField().setBorder(null);
        }

        if (error)
            JOptionPane.showMessageDialog(new JFrame(), "Some fields are empty", "Error", JOptionPane.ERROR_MESSAGE);
        else
            saveEmployee(name, address, education, post);
    }

    private void saveEmployee(String name, String address, String education, PostsENUM post) {
        if (old_employee == null) {
            Employee employee = new Employee(name, address, education, post, superMarket);
            HibernateUtil.getInstance().getEmployeeDao().saveOrUpdateEmployee(employee);
            JOptionPane.showMessageDialog(new JFrame(), "Please remember employee info:\n" +
                    "Login: " + employee.getId() + "\nPassword: " + employee.getPassword(), "Employee registered", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            old_employee.setName(name);
            old_employee.setAddress(address);
            old_employee.setEducation(education);
            old_employee.setPost(post);
            HibernateUtil.getInstance().getEmployeeDao().saveOrUpdateEmployee(old_employee);
            JOptionPane.showMessageDialog(new JFrame(), "Employee info is updated.", "Update", JOptionPane.INFORMATION_MESSAGE);
        }
        goToPreviousPanel();
    }

    private void goToPreviousPanel(){
        switch (previousPanel){
            case 0 -> managerView.changeJPanel(managerView.getMainPanel());
            case 1 -> {
                EmployeesPanel employeesPanel = new EmployeesPanel();
                managerView.changeJPanel(employeesPanel.getEmployeesPanel());
                new EmployeesController(employeesPanel, managerView, superMarket, null);
            }
            case 2 -> {
                EmployeesPanel employeesPanel = new EmployeesPanel();
                managerView.changeJPanel(employeesPanel.getEmployeesPanel());
                new EmployeesController(employeesPanel, managerView, superMarket, old_employee.getPost());
            }
        }
    }

}
