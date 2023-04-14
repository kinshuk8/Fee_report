import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountantLogin {

    private JFrame frame = new JFrame("Accountant Login");
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel("Accountant Login");
    private JButton login = new JButton("Login");
    private JButton back = new JButton("Back");
    private JLabel name = new JLabel("Name:");
    private JTextField nameText = new JTextField(20);
    private JLabel password = new JLabel("Password:");
    private JTextField passwordText = new JTextField(20);

    public AccountantLogin() {
        frame.setSize(420, 350);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);

        label.setBounds(125, 15, 160, 25);
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        login.setBounds(125, 175, 80, 25);
        panel.setLayout(null);
        name.setBounds(10, 75, 80, 25);
        nameText.setBounds(120, 75, 165, 25);
        password.setBounds(10, 115, 80, 25);
        passwordText.setBounds(120, 115, 165, 25);
        back.setBounds(225, 175, 80, 25);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameText.getText();
                String password = passwordText.getText();
                boolean status = AccountantDB.validate(name, password);

                if (status) {
                    AccountantSection.main(new String[]{});
                    frame.dispose();
                }
                else {
                    JOptionPane.showMessageDialog(frame, "Sorry, incorrect details!", "Login Error!", JOptionPane.ERROR_MESSAGE);

                }
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FeeReport.main(new String[]{});
                frame.dispose();
            }
        });

        panel.add(label);
        panel.add(name);
        panel.add(nameText);
        panel.add(password);
        panel.add(passwordText);
        panel.add(login);
        panel.add(back);
    }

    public static void main(String[] args) {
        new AccountantLogin();
    }

}
