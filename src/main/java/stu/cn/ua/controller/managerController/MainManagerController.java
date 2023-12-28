package stu.cn.ua.controller.managerController;

import stu.cn.ua.controller.LogginController;
import stu.cn.ua.model.Employee;
import stu.cn.ua.model.PostsENUM;
import stu.cn.ua.view.LoggingView;
import stu.cn.ua.view.ManagerView;
import stu.cn.ua.view.panels.EmployeesPanel;
import stu.cn.ua.view.panels.RegisterNewEmployeePanel;

import java.awt.event.WindowEvent;

public class MainManagerController {
    private final Employee manager;
    private final ManagerView managerView;

    public MainManagerController(ManagerView managerView, Employee manager) {
        this.managerView = managerView;
        this.manager = manager;
        setManagerViewListeners();
    }

    private void setManagerViewListeners(){
        managerView.getCustomMenuBar().getWelcomeJMenuItem().addActionListener(e -> goToWelcomePanel());
        managerView.getRegisterNewEmployeeButton().addActionListener(e -> registerEmployee(null));
        managerView.getCustomMenuBar().getRegisterEmployeeJMenuItem().addActionListener(e -> registerEmployee(null));
        managerView.getExitButton().addActionListener(e -> managerView.dispatchEvent(new WindowEvent(managerView, WindowEvent.WINDOW_CLOSING)));
        managerView.getCustomMenuBar().getExitMenuItem().addActionListener(e -> managerView.dispatchEvent(new WindowEvent(managerView, WindowEvent.WINDOW_CLOSING)));
        managerView.getLogOutButton().addActionListener(e -> logOut());
        managerView.getCustomMenuBar().getLogOutJMenuItem().addActionListener(e -> logOut());
        managerView.getAllEmployeesButton().addActionListener(e -> getEmployeesList(null));
        managerView.getCustomMenuBar().getAllEmployeesInSupermarketJMenuItem().addActionListener(e -> getEmployeesList(null));
        managerView.getEmployeesByPostButton().addActionListener(e -> getEmployeesList(PostsENUM.Manager));
        managerView.getCustomMenuBar().getEmployeesByPostInSupermarketJMenuItem().addActionListener(e -> getEmployeesList(PostsENUM.Manager));
    }

    private void getEmployeesList(PostsENUM post) {
        EmployeesPanel employeesPanel = new EmployeesPanel();
        managerView.changeJPanel(employeesPanel.getEmployeesPanel());
        new EmployeesController(employeesPanel, managerView, manager.getSupermarket(), post);
    }

    private void goToWelcomePanel() {
        if(managerView.getContentPane() != managerView.getMainPanel()){
            managerView.changeJPanel(managerView.getMainPanel());
        }
    }

    private void logOut() {
        managerView.dispose();
        new LogginController(new LoggingView());
    }

    private void registerEmployee(Employee old_employee) {
        RegisterNewEmployeePanel registerNewEmployeePanel = new RegisterNewEmployeePanel(Long.toString(manager.getSupermarket().getId()));
        managerView.changeJPanel(registerNewEmployeePanel);
        new RegisterEmployeeController(registerNewEmployeePanel, 0, managerView, manager.getSupermarket(), old_employee);
    }


}
