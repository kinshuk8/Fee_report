import javax.swing.*;
import java.awt.*;

public class AdminSection{

    private JFrame frame = new JFrame("Admin Section");
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel("Admin Section");
    private JButton addBtn = new JButton("Add Accountant");
    private JButton viewBtn = new JButton("View Accountant");
    private JButton logoutBtn = new JButton("Logout");

    public AdminSection() {
        frame.setSize(420, 350);
        frame.setVisible(true);
        panel.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        label.setBounds(145, 15, 150, 20);
        label.setFont(new Font("Serif", Font.PLAIN, 20));

        addBtn.setBounds(130, 80, 150, 30);
        viewBtn.setBounds(130, 140, 150, 30);
        logoutBtn.setBounds(130, 200, 150, 30);

        addBtn.addActionListener(e -> {
            AddAccountant.main(new String[]{});
            frame.dispose();
        });

        viewBtn.addActionListener(e -> {
            ViewAccountant.main(new String[]{});
            frame.dispose();
        });

        logoutBtn.addActionListener(e -> {
            FeeReport.main(new String[]{});
            frame.dispose();
        });

        panel.add(label);
        panel.add(addBtn);
        panel.add(viewBtn);
        panel.add(logoutBtn);
        frame.add(panel);

    }

    public static void main(String[] args) {
        new AdminSection();
    }
}
