import com.sun.jdi.request.MethodExitRequest;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;

class DBConnection {
    Connection con;
    PreparedStatement ps;
    Statement statement;
    ResultSet rs;

    DBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://@localhost:3306/feereport",
                    "root","Azulic_2003");
            statement = con.createStatement();
            System.out.println("Connection Established!!");
        }   catch(Exception e) {
            e.printStackTrace();
        }
    }

    boolean search(String username, String password) throws SQLException {
        ps = con.prepareStatement("SELECT * FROM admin_login WHERE username = ? AND password = ?");
        ps.setString(1, username);
        ps.setString(2, username);
        rs = ps.executeQuery();
        return rs.next();
    }

    void insert(String username, String password) throws SQLException {
        ps = con.prepareStatement("INSERT INTO admin_login(username, password) VALUES(?, ?)");
        ps.setString(1, username);
        ps.setString(2, password);
        ps.executeUpdate();
    }
}

public class AdminLogin extends Component {

    private final JFrame frame = new JFrame("Admin Login");
    private final JPanel panel = new JPanel();
    private final JLabel label = new JLabel("Admin Login");
    private final JButton login = new JButton("Login");
    private final JLabel name = new JLabel("Name:");
    private final JTextField nameText = new JTextField(20);
    private final JLabel password = new JLabel("Password:");
    private final JTextField passwordText = new JTextField(20);

    public AdminLogin() {
        frame.setSize(420, 350);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);

        label.setFont(new Font("Serif", Font.PLAIN, 20));
        label.setBounds(145, 15, 120, 25);
        login.setBounds(150, 175, 80, 25);
        login.addActionListener(e -> {
            boolean matched = false;
            String username = nameText.getText();
            String pwd = passwordText.getText();
            if(username.equals("admin") && pwd.equals("admin123")) {
                AdminSection.main(new String[]{});
                frame.dispose();
            }
            else {
                JOptionPane.showMessageDialog(AdminLogin.this,"Username or Password didn't match, please try again");
                nameText.setText("");
                passwordText.setText("");
            }
        });
        panel.setLayout(null);
        name.setBounds(10, 75, 80, 25);
        nameText.setBounds(120, 75, 165, 25);
        password.setBounds(10, 115, 80, 25);
        passwordText.setBounds(120, 115, 165, 25);

        panel.add(label);
        panel.add(name);
        panel.add(nameText);
        panel.add(password);
        panel.add(passwordText);
        panel.add(login);
    }
    public static void main(String[] args) {
        new AdminLogin();
    }
}