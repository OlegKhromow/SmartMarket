package stu.cn.ua.controller;

import stu.cn.ua.controller.managerController.MainManagerController;
import stu.cn.ua.dao.HibernateUtil;
import stu.cn.ua.model.Employee;
import stu.cn.ua.view.LoggingView;
import stu.cn.ua.view.ManagerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class LogginController {
    private final LoggingView loggingView;
    private String login;
    private String password ;

    public LogginController(LoggingView loggingView) {
        this.loggingView = loggingView;
        loggingView.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (getData())
                    searchUserInDB();
            }
        });
    }

    private void goToNextScreen(Employee employee){
        loggingView.dispose();
        switch (employee.getPost()){
            case Manager -> {
                new MainManagerController(new ManagerView(), employee);
            }
            case Cashier -> {
                //TODO
            }
        }
    }

    private void searchUserInDB() {
        Employee employee = HibernateUtil.getInstance().getEmployeeDao().getEmployeeById(Long.parseLong(login));
        if (employee == null){
            loggingView.showErrorDialog("There is no user in system with this login", "Wrong login", 1);
            return;
        }
        if (!Objects.equals(employee.getPassword(), password)){
            loggingView.showErrorDialog("Password is wrong. Try again", "Wrong password", 2);
            return;
        }
        goToNextScreen(employee);
    }

    private boolean getData() {
        login = loggingView.getLogginTextField().getText();
        password = String.valueOf(loggingView.getPasswordField().getPassword());
        loggingView.getLogginTextField().setBorder(null);
        loggingView.getPasswordField().setBorder(null);
        if(login.isEmpty() || password.isEmpty()){
            if (login.isEmpty() && password.isEmpty())
                loggingView.showErrorDialog("Login and password didn't entered", "Login and password error", 3);
            else {
                if (login.isEmpty())
                    loggingView.showErrorDialog("Login didn't entered", "Login error", 1);
                if (password.isEmpty())
                    loggingView.showErrorDialog("Password didn't entered", "Password error", 2);
            }
            return false;
        }
        return true;
    }
}
