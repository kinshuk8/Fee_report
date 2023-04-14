import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountantSection {
    private JFrame frame = new JFrame("Accountant Section");
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel("Accountant Section");
    private JButton addBtn = new JButton("Add Student");
    private JButton editBtn = new JButton("Edit Student");
    private JButton viewBtn = new JButton("View Student");
    private JButton dueBtn = new JButton("Due Fee");
    private JButton logoutBtn = new JButton("Logout");

    public AccountantSection() {
        frame.setSize(420, 350);
        frame.add(panel);
        panel.setLayout(null);
        frame.setVisible(true);

        label.setBounds(125, 15, 200, 30);
        label.setFont(new Font("Serif", Font.PLAIN, 20));

        addBtn.setBounds(35, 95, 150, 30);
        viewBtn.setBounds(225, 95, 150, 30);
        editBtn.setBounds(35, 152, 150, 30);
        dueBtn.setBounds(225, 152, 150, 30);
        logoutBtn.setBounds(135, 205, 150, 30);

        addBtn.addActionListener(e -> {
            AddStudent.main(new String[]{});
            frame.dispose();
        });

        viewBtn.addActionListener(e -> {
            ViewStudent.main(new String[]{});
        });

        editBtn.addActionListener(e -> {
            EditStudent.main(new String[]{});
            frame.dispose();
        });

        dueBtn.addActionListener(e -> DueFee.main(new String[]{}));

        logoutBtn.addActionListener(e -> {
            FeeReport.main(new String[]{});
            frame.dispose();
        });

        panel.add(label);
        panel.add(addBtn);
        panel.add(viewBtn);
        panel.add(editBtn);
        panel.add(dueBtn);
        panel.add(logoutBtn);
    }

    public static void main(String[] args) {
        new AccountantSection();
    }
}
