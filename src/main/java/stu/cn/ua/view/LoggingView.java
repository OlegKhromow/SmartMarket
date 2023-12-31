package stu.cn.ua.view;

import com.intellij.uiDesigner.core.Spacer;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;

public class LoggingView extends JFrame {
    private JPanel mainPanel;
    private JLabel label1;
    private JButton loginButton;
    private JPanel formPanel;
    private JTextField logginTextField;
    private JPasswordField passwordField;

    public LoggingView() {
        $$$setupUI$$$();
        setContentPane(mainPanel);
        setTitle("Login");
        setVisible(true);
        setSize(600, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JTextField getLogginTextField() {
        return logginTextField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public void showErrorDialog(String msg, String title, int flag) {
        switch (flag) {
            case 1 -> {
                logginTextField.setText("");
                logginTextField.setBorder(new LineBorder(Color.red, 1));
                passwordField.setBorder(null);

            }
            case 2 -> {
                passwordField.setText("");
                passwordField.setBorder(new LineBorder(Color.red, 1));
                logginTextField.setBorder(null);
            }
            case 3 -> {
                logginTextField.setText("");
                logginTextField.setBorder(new LineBorder(Color.red, 1));
                passwordField.setText("");
                passwordField.setBorder(new LineBorder(Color.red, 1));
            }
        }
        JOptionPane.showMessageDialog(new JFrame(), msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new FormLayout("fill:d:grow", "center:d:grow,top:4dlu:noGrow,center:d:noGrow,top:4dlu:noGrow,center:d:grow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:4dlu:noGrow,center:d:grow"));
        Font mainPanelFont = this.$$$getFont$$$("Consolas", -1, 18, mainPanel.getFont());
        if (mainPanelFont != null) mainPanel.setFont(mainPanelFont);
        formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        CellConstraints cc = new CellConstraints();
        mainPanel.add(formPanel, cc.xy(1, 3, CellConstraints.CENTER, CellConstraints.DEFAULT));
        label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("Consolas", Font.PLAIN, 16, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setText("Enter login:");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(label1, gbc);
        final JLabel label2 = new JLabel();
        Font label2Font = this.$$$getFont$$$("Consolas", Font.PLAIN, 16, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setText("Enter password:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        formPanel.add(label2, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        formPanel.add(spacer1, gbc);
        logginTextField = new JTextField();
        Font logginTextFieldFont = this.$$$getFont$$$("Consolas", Font.PLAIN, 16, logginTextField.getFont());
        if (logginTextFieldFont != null) logginTextField.setFont(logginTextFieldFont);
        logginTextField.setPreferredSize(new Dimension(200, 35));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(logginTextField, gbc);
        passwordField = new JPasswordField();
        Font passwordFieldFont = this.$$$getFont$$$("Consolas", Font.PLAIN, 16, passwordField.getFont());
        if (passwordFieldFont != null) passwordField.setFont(passwordFieldFont);
        passwordField.setPreferredSize(new Dimension(200, 35));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(passwordField, gbc);
        loginButton = new JButton();
        Font loginButtonFont = this.$$$getFont$$$("Consolas", Font.PLAIN, 16, loginButton.getFont());
        if (loginButtonFont != null) loginButton.setFont(loginButtonFont);
        loginButton.setPreferredSize(new Dimension(200, 38));
        loginButton.setText("Log In");
        mainPanel.add(loginButton, cc.xy(1, 7, CellConstraints.CENTER, CellConstraints.DEFAULT));
        final Spacer spacer2 = new Spacer();
        mainPanel.add(spacer2, cc.xy(1, 1, CellConstraints.DEFAULT, CellConstraints.CENTER));
        final Spacer spacer3 = new Spacer();
        mainPanel.add(spacer3, cc.xy(1, 9, CellConstraints.DEFAULT, CellConstraints.FILL));
        final Spacer spacer4 = new Spacer();
        mainPanel.add(spacer4, cc.xy(1, 6, CellConstraints.DEFAULT, CellConstraints.FILL));
        final Spacer spacer5 = new Spacer();
        mainPanel.add(spacer5, cc.xy(1, 5, CellConstraints.DEFAULT, CellConstraints.FILL));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }

}
