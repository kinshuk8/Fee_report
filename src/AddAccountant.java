import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAccountant {
    private JFrame frame = new JFrame("Add Accountant");
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel("Add Accountant");
    private JLabel name = new JLabel("Name: ");
    private JLabel password = new JLabel("Password: ");
    private JLabel email = new JLabel("Email: ");
    private JLabel contact = new JLabel("Contact No.: ");
    private JTextField nameText = new JTextField();
    private JTextField passwordText = new JTextField();
    private JTextField emailText = new JTextField();
    private JTextField contactText = new JTextField();
    private JButton addBtn = new JButton("Add Accountant");
    private JButton back = new JButton("back");

    public AddAccountant() {
        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(420, 380);
        frame.setVisible(true);
        panel.setLayout(null);

        label.setBounds(135, 15, 150, 20);
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        name.setBounds(35, 65, 80, 30);
        nameText.setBounds(135,65, 200, 30);
        password.setBounds(35, 115, 80, 30);
        passwordText.setBounds(135, 115, 200, 30);
        email.setBounds(35, 165, 80, 30);
        emailText.setBounds(135, 165, 200, 30);
        contact.setBounds(35, 215, 80, 30);
        contactText.setBounds(135, 215, 200, 30);

        addBtn.setBounds(105, 275, 150, 30);
        back.setBounds(300, 275, 80, 30);

        addBtn.addActionListener(e -> {
            String name = nameText.getText();
            String password = passwordText.getText();
            String email = emailText.getText();
            String contact = contactText.getText();

            Accountant acc = new Accountant(name, password, email, contact);
            int status = AccountantDB.save(acc);

            if(status > 0) {
                JOptionPane.showMessageDialog(frame, "Accountant added successfully!");
                nameText.setText("");
                passwordText.setText("");
                emailText.setText("");
                contactText.setText("");
            }
            else {
                JOptionPane.showMessageDialog(frame, "Unable to add Accountant");
            }
        });

        back.addActionListener(e -> {
            AdminSection.main(new String[]{});
            frame.dispose();
        });

        panel.add(label);
        panel.add(name);
        panel.add(nameText);
        panel.add(password);
        panel.add(passwordText);
        panel.add(email);
        panel.add(emailText);
        panel.add(contact);
        panel.add(contactText);
        panel.add(addBtn);
        panel.add(back);
    }

    public static void main(String[] args) {
        new AddAccountant();
    }
}
