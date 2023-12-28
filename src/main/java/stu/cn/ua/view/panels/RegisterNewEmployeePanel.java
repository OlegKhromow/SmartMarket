package stu.cn.ua.view.panels;

import stu.cn.ua.model.Employee;
import stu.cn.ua.model.PostsENUM;

import javax.swing.*;
import java.awt.*;

public class RegisterNewEmployeePanel extends JPanel {
    private JTextField nameField;
    private JTextField addressField;
    private JComboBox<PostsENUM> postComboBox;
    private JTextField educationTextField;
    private JTextField supermarketTextField;
    private JButton saveButton;
    private JButton cancelButton;
    private JButton deleteButton;

    public RegisterNewEmployeePanel(String supermarket_id) {
        initUI();
        supermarketTextField.setText(supermarket_id);
        postComboBox.addItem(PostsENUM.Manager);
        postComboBox.addItem(PostsENUM.Cashier);
        postComboBox.addItem(PostsENUM.Merchandiser);
        postComboBox.addItem(PostsENUM.Loader);
        postComboBox.addItem(PostsENUM.Security);
        postComboBox.addItem(PostsENUM.Cleaner);
    }

    public void initEditedFields(Employee old_employee){
        nameField.setText(old_employee.getName());
        addressField.setText(old_employee.getAddress());
        postComboBox.setSelectedItem(old_employee.getPost());
        if (old_employee.getEducation() == null)
            educationTextField.setEnabled(false);
        else
            educationTextField.setText(old_employee.getEducation());
        deleteButton.setVisible(true);
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JTextField getAddressField() {
        return addressField;
    }

    public JComboBox<PostsENUM> getPostComboBox() {
        return postComboBox;
    }

    public JTextField getEducationTextField() {
        return educationTextField;
    }

    public JTextField getSupermarketTextField() {
        return supermarketTextField;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    private void initUI(){
        this.setLayout(new GridBagLayout());
        Font font = new Font("Consolas", Font.PLAIN, 16);
        final JLabel label1 = new JLabel();
        label1.setText("Enter full name:");
        label1.setFont(font);
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        this.add(label1, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipadx = 10;
        this.add(spacer1, gbc);
        final JPanel spacer2 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        this.add(spacer2, gbc);
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(200, 35));
        nameField.setFont(font);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(nameField, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("Enter the registration address:");
        label2.setFont(font);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        this.add(label2, gbc);
        addressField = new JTextField();
        addressField.setFont(font);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(addressField, gbc);
        final JLabel label3 = new JLabel();
        label3.setFont(font);
        label3.setText("Choose post:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        this.add(label3, gbc);
        postComboBox = new JComboBox<PostsENUM>();
        postComboBox.setFont(font);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(postComboBox, gbc);
        final JLabel label4 = new JLabel();
        label4.setText("Enter education:");
        label4.setFont(font);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.EAST;
        this.add(label4, gbc);
        educationTextField = new JTextField();
        educationTextField.setFont(font);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(educationTextField, gbc);
        final JLabel label5 = new JLabel();
        label5.setText("Supermarket #:");
        label5.setFont(font);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.EAST;
        this.add(label5, gbc);
        supermarketTextField = new JTextField();
        supermarketTextField.setFont(font);
        supermarketTextField.setEditable(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(supermarketTextField, gbc);
        final JPanel spacer3 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.VERTICAL;
        this.add(spacer3, gbc);
        final JPanel spacer4 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.VERTICAL;
        this.add(spacer4, gbc);
        final JPanel spacer5 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.VERTICAL;
        this.add(spacer5, gbc);
        final JPanel spacer6 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 10;
        gbc.ipady = 10;
        gbc.fill = GridBagConstraints.VERTICAL;
        this.add(spacer6, gbc);
        final JPanel spacer7 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 10;
        gbc.ipadx = 10;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(spacer7, gbc);

        saveButton = new JButton();
        saveButton.setFont(new Font("Consolas", Font.PLAIN, 16));
        saveButton.setPreferredSize(new Dimension(150, 38));
        saveButton.setText("Save");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 11;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(saveButton, gbc);

        final JPanel spacer8 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 11;
        gbc.ipadx = 10;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(spacer8, gbc);

        deleteButton = new JButton();
        deleteButton.setFont(new Font("Consolas", Font.PLAIN, 16));
        deleteButton.setPreferredSize(new Dimension(150, 38));
        deleteButton.setText("Delete");
        gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 11;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(deleteButton, gbc);
        deleteButton.setVisible(false);

        final JPanel spacer9 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 12;
        gbc.ipadx = 10;
        gbc.fill = GridBagConstraints.VERTICAL;
        this.add(spacer9, gbc);

        cancelButton = new JButton();
        cancelButton.setFont(new Font("Consolas", Font.PLAIN, 16));
        cancelButton.setPreferredSize(new Dimension(150, 38));
        cancelButton.setText("Cancel");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 13;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(cancelButton, gbc);
    }
}
