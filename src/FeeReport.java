import  javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;





public class FeeReport {

    private JFrame frame = new JFrame("Fee Report");
    private JLabel label;
    private JButton jbAdminLogin;
    private JButton jbAccountantLogin;

    public FeeReport() {

        label = new JLabel("Fee Report");

        jbAdminLogin = new JButton("Admin Login");
        jbAdminLogin.setBounds(150, 100, 150, 50);
        jbAdminLogin.addActionListener(e -> {
            AdminLogin.main(new String[]{});
            frame.dispose();              //After the press the Login Button it closes the previous tab
        });

        jbAccountantLogin = new JButton("Accountant Login");
        jbAccountantLogin.setBounds(150, 185, 150, 50);
        jbAccountantLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccountantLogin.main(new String[]{});
                frame.dispose();
            }
        });

        label.setText("Fee Report");
        frame.setBounds(170, 15, 250, 75);
        frame.setFont(new Font("Serif", Font.PLAIN, 25));

        frame.add(label);
        frame.add(jbAdminLogin);
        frame.add(jbAccountantLogin);
        frame.setSize(480, 320);
        frame.setLayout(null);
        frame.setVisible(true);


    }
    public static void main(String[] args) {
        new FeeReport();
    }
}