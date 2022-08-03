
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class LoginForm extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel userLabel = new JLabel("المستخدم");
    JLabel passwordLabel = new JLabel("كلمه المرور");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("تسجيل الدخول");

    LoginForm() {

        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {

        userLabel.setBounds(50, 100, 100, 30);
        userLabel.setFont(new Font("Arial", Font.BOLD, 17));

        passwordLabel.setBounds(50, 170, 100, 30);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 17));

        userTextField.setBounds(150, 100, 150, 30);
        userTextField.setFont(new Font("Arial", Font.BOLD, 17));

        passwordField.setBounds(150, 170, 150, 30);
        passwordField.setFont(new Font("Arial", Font.BOLD, 17));

        loginButton.setBounds(135, 250, 100, 30);
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));

    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(loginButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();

            Tahwela tahwela = new Tahwela();

            if (userText.equals("التحويله")) {

                tahwela.setVisible(true);
                tahwela.frame.setVisible(false);

            } // add Afroa
            else if (userText.equals("النظم") || userText.equals("الافراد")
                    || userText.equals("التجنيد") || userText.equals("القومسيون")
                    || userText.equals("المجمع") || userText.equals("التخطيط")
                    || userText.equals("الامن")) {

                Afroa afroa = new Afroa(userText);
                afroa.setVisible(true);
                afroa.setTitle("فاكسات " + userText);
                tahwela.frame.setVisible(false);

            } else {

                JOptionPane.showMessageDialog(this, "Invalid Username or Password");

            }

        }
    }

}
