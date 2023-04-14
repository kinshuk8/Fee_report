import javax.management.remote.JMXAuthenticator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.Kernel;

public class AddStudent{
    private  JFrame frame = new JFrame("Add Student");
    private  JPanel panel = new JPanel();
    private  JLabel label = new JLabel("Add Student");
    private  JLabel name = new JLabel("Name: ");
    JLabel email = new JLabel("Email: ");
    private  JLabel course = new JLabel("Course:");
    private  JLabel fee = new JLabel("Fee: ");
    private  JLabel paid = new JLabel("Paid:");
    private  JLabel due = new JLabel("Due: ");
    private  JLabel address = new JLabel("Address:");
    private  JLabel city = new JLabel("City:");
    private  JLabel state = new JLabel("State:");
    private  JLabel country = new JLabel("Country:");
    private  JLabel contact = new JLabel("Country No.:");

    JTextField nameText = new JTextField();
    JTextField emailText = new JTextField();
    JTextField courseText = new JTextField();
    JTextField feeText = new JTextField();
    JTextField paidText = new JTextField();
    JTextField dueText = new JTextField();
    JTextArea addressText = new JTextArea(5, 10);
    JTextField cityText = new JTextField();
    JTextField stateText = new JTextField();
    JTextField countryText = new JTextField();
    JTextField contactText = new JTextField();
    JButton addBtn = new JButton("Add Student");
    JButton back = new JButton("back");

    public AddStudent() {
        frame.setSize(480, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        label.setBounds(170, 15, 150, 20);
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        name.setBounds(35, 65, 80, 30);
        nameText.setBounds(135, 71, 200, 20);
        email.setBounds(35, 100, 80, 30);
        emailText.setBounds(135, 106, 200, 20);
        course.setBounds(35, 135, 80, 30);
        courseText.setBounds(135, 141, 200, 20);
        fee.setBounds(35, 170, 80, 30);
        feeText.setBounds(135, 176, 200, 20);
        paid.setBounds(35, 205, 80, 30);
        paidText.setBounds(135, 211, 200, 20);
        due.setBounds(35, 240, 80, 30);
        dueText.setBounds(135, 246, 200, 20);
        address.setBounds(35, 275, 80, 30);
        addressText.setBounds(135, 281, 200, 50);
        city.setBounds(35, 346, 80, 30);
        cityText.setBounds(135, 352, 200, 20);
        state.setBounds(35, 387, 80, 30);
        stateText.setBounds(135, 393, 200, 20);
        country.setBounds(35, 422, 80, 30);
        countryText.setBounds(135, 428, 200, 20);
        contact.setBounds(35, 457,80,30);
        contactText.setBounds(135, 463, 200, 20);
        addBtn.setBounds(105, 503, 150, 30);
        back.setBounds(275, 503, 80, 30);

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = nameText.getText();
                String email = emailText.getText();
                String course = courseText.getText();
                int fee = Integer.parseInt(feeText.getText());
                int paid = Integer.parseInt(paidText.getText());
                int due = Integer.parseInt(dueText.getText());
                String address = addressText.getText();
                String city = cityText.getText();
                String state = stateText.getText();
                String country = countryText.getText();
                String contact = contactText.getText();

                Student stud = new Student(username, email, course, fee, paid, due, address, city, state, country, contact);
                int status = StudentDB.save(stud);

                if (status > 0) {
                    JOptionPane.showMessageDialog(frame, "Student added successfully");
                    nameText.setText("");
                    emailText.setText("");
                    courseText.setText("");
                    feeText.setText("");
                    paidText.setText("");
                    dueText.setText("");
                    addressText.setText("");
                    cityText.setText("");
                    countryText.setText("");
                    contactText.setText("");
                }
                else {
                    JOptionPane.showMessageDialog(frame, "Sorry, Unable to add Student");
                }
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccountantSection.main(new String[]{});
                frame.dispose();
            }
        });

        panel.add(label);
        panel.add(name);
        panel.add(nameText);
        panel.add(email);
        panel.add(emailText);
        panel.add(course);
        panel.add(courseText);
        panel.add(fee);
        panel.add(feeText);
        panel.add(paid);
        panel.add(paidText);
        panel.add(due);
        panel.add(dueText);
        panel.add(address);
        panel.add(addressText);
        panel.add(city);
        panel.add(cityText);
        panel.add(state);
        panel.add(stateText);
        panel.add(course);
        panel.add(courseText);
        panel.add(country);
        panel.add(countryText);
        panel.add(contact);
        panel.add(contactText);
        panel.add(addBtn);
        panel.add(back);
    }

    public static void main(String[] args) {
        new AddStudent();
    }
}
