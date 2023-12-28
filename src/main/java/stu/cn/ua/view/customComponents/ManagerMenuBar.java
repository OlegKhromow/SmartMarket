package stu.cn.ua.view.customComponents;

import javax.swing.*;
import java.awt.*;

public class ManagerMenuBar extends JMenuBar {

    private final JMenuItem profileJMenuItem;
    private final JMenuItem superMarketJMenuItem;
    private final JMenuItem logOutJMenuItem;
    private final JMenuItem exitMenuItem;
    private final JMenuItem registerEmployeeJMenuItem;
    private final JMenuItem allEmployeesInSupermarketJMenuItem;
    private final JMenuItem employeesByPostInSupermarketJMenuItem;
    private final JMenuItem showProductsJMenuItem;
    private final JMenuItem cleanProductsJMenuItem;
    private final JMenuItem endedProductsJMenuItem;
    private final JMenuItem categoriesJMenuItem;
    private final JMenuItem salesJMenuItem;
    private final JMenuItem deliveryProductsJMenuItem;
    private final JMenuItem documentationJMenuItem;
    private final JMenuItem contactDevelopersJMenuItem;
    private final JMenuItem welcomeJMenuItem;

    public ManagerMenuBar() {
        Font font = new Font("Consolas", Font.PLAIN, 14);

        // create a menu
        JMenu fileMenu = new JMenu("File");
        fileMenu.setFont(font);
        // create menu-items
        welcomeJMenuItem = new JMenuItem("Welcome screen");
        welcomeJMenuItem.setFont(font);
        profileJMenuItem = new JMenuItem("Profile");
        profileJMenuItem.setFont(font);
        superMarketJMenuItem = new JMenuItem("Supermarket");
        superMarketJMenuItem.setFont(font);
        logOutJMenuItem = new JMenuItem("Log Out");
        logOutJMenuItem.setFont(font);
        exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setFont(font);
        // add menu items to menu
        fileMenu.add(welcomeJMenuItem);
        fileMenu.add(profileJMenuItem);
        fileMenu.add(superMarketJMenuItem);
        fileMenu.add(logOutJMenuItem);
        fileMenu.add(exitMenuItem);

        // create a menu
        JMenu employeeMenu = new JMenu("Employees");
        employeeMenu.setFont(font);
        // create menu-items
        registerEmployeeJMenuItem = new JMenuItem("Register new employee");
        registerEmployeeJMenuItem.setFont(font);
        JMenu showEmployeesJMenu = new JMenu("Show employees");
        showEmployeesJMenu.setFont(font);
        //submenu
        allEmployeesInSupermarketJMenuItem = new JMenuItem("All employees in supermarket");
        allEmployeesInSupermarketJMenuItem.setFont(font);
        employeesByPostInSupermarketJMenuItem = new JMenuItem("Employees with particular post");
        employeesByPostInSupermarketJMenuItem.setFont(font);
        showEmployeesJMenu.add(allEmployeesInSupermarketJMenuItem);
        showEmployeesJMenu.add(employeesByPostInSupermarketJMenuItem);
        // add menu items to menu
        employeeMenu.add(registerEmployeeJMenuItem);
        employeeMenu.add(showEmployeesJMenu);

        // create a menu
        JMenu productMenu = new JMenu("Products");
        productMenu.setFont(font);
        // create menu-items
        showProductsJMenuItem = new JMenuItem("Show products");
        showProductsJMenuItem.setFont(font);
        cleanProductsJMenuItem = new JMenuItem("Clean expired products");
        cleanProductsJMenuItem.setFont(font);
        endedProductsJMenuItem = new JMenuItem("Show products that ended");
        endedProductsJMenuItem.setFont(font);
        categoriesJMenuItem = new JMenuItem("Show categories list");
        categoriesJMenuItem.setFont(font);
        // add menu items to menu
        productMenu.add(showProductsJMenuItem);
        productMenu.add(cleanProductsJMenuItem);
        productMenu.add(endedProductsJMenuItem);
        productMenu.add(categoriesJMenuItem);

        // create a menu
        JMenu reportsMenu = new JMenu("Reports");
        reportsMenu.setFont(font);
        // create menu-items
        salesJMenuItem = new JMenuItem("Show sales in period");
        salesJMenuItem.setFont(font);
        deliveryProductsJMenuItem = new JMenuItem("Create a product delivery report");
        deliveryProductsJMenuItem.setFont(font);
        // add menu items to menu
        reportsMenu.add(salesJMenuItem);
        reportsMenu.add(deliveryProductsJMenuItem);

        // create a menu
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setFont(font);
        // create menu-items
        documentationJMenuItem = new JMenuItem("Documentation");
        documentationJMenuItem.setFont(font);
        contactDevelopersJMenuItem = new JMenuItem("Contact Developers");
        contactDevelopersJMenuItem.setFont(font);
        // add menu items to menu
        helpMenu.add(documentationJMenuItem);
        helpMenu.add(contactDevelopersJMenuItem);

        // add menu to menu bar
        add(fileMenu);
        add(employeeMenu);
        add(productMenu);
        add(reportsMenu);
        add(helpMenu);
    }

    public JMenuItem getWelcomeJMenuItem() {
        return welcomeJMenuItem;
    }

    public JMenuItem getProfileJMenuItem() {
        return profileJMenuItem;
    }

    public JMenuItem getSuperMarketJMenuItem() {
        return superMarketJMenuItem;
    }

    public JMenuItem getLogOutJMenuItem() {
        return logOutJMenuItem;
    }

    public JMenuItem getExitMenuItem() {
        return exitMenuItem;
    }

    public JMenuItem getRegisterEmployeeJMenuItem() {
        return registerEmployeeJMenuItem;
    }

    public JMenuItem getAllEmployeesInSupermarketJMenuItem() {
        return allEmployeesInSupermarketJMenuItem;
    }

    public JMenuItem getEmployeesByPostInSupermarketJMenuItem() {
        return employeesByPostInSupermarketJMenuItem;
    }

    public JMenuItem getShowProductsJMenuItem() {
        return showProductsJMenuItem;
    }

    public JMenuItem getCleanProductsJMenuItem() {
        return cleanProductsJMenuItem;
    }

    public JMenuItem getEndedProductsJMenuItem() {
        return endedProductsJMenuItem;
    }

    public JMenuItem getCategoriesJMenuItem() {
        return categoriesJMenuItem;
    }

    public JMenuItem getSalesJMenuItem() {
        return salesJMenuItem;
    }

    public JMenuItem getDeliveryProductsJMenuItem() {
        return deliveryProductsJMenuItem;
    }

    public JMenuItem getDocumentationJMenuItem() {
        return documentationJMenuItem;
    }

    public JMenuItem getContactDevelopersJMenuItem() {
        return contactDevelopersJMenuItem;
    }
}
