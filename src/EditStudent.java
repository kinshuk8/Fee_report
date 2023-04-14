import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.Kernel;

public class EditStudent {
    private JFrame frame = new JFrame("Edit Student");
    private JPanel panel = new JPanel();
    private JLabel roll = new JLabel("Roll No.:");
    private JLabel name = new JLabel("Name:");
    private JLabel email = new JLabel("Email:");
    private JLabel course = new JLabel("Course:");
    private JLabel fee = new JLabel("Fee");
    private JLabel paid = new JLabel("Paid: ");
    private JLabel due = new JLabel("Due");
    private JLabel address = new JLabel("Address:");
    private JLabel city = new JLabel("City:");
    private JLabel state = new JLabel("State:");
    private JLabel country = new JLabel("Country:");
    private JLabel contact = new JLabel("Contact No: ");
    private JTextField rollText = new JTextField();
    private  JTextField nameText = new JTextField();
    private JTextField emailText = new JTextField();
    private JTextField courseText = new JTextField();
    private  JTextField feeText = new JTextField();
    private JTextField paidText = new JTextField();
    private JTextField dueText = new JTextField();
    private JTextArea addressText = new JTextArea(5, 10);
    private JTextField cityText = new JTextField();
    private JTextField stateText = new JTextField();
    private JTextField countryText = new JTextField();
    private JTextField contactText = new JTextField();
    private JButton load = new JButton("Load Record");
    private JButton update = new JButton("Update Student");
    private JButton back = new JButton("back");



    public EditStudent() {
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
        panel.setLayout(null);

        roll.setBounds(35, 15, 80, 30);
        rollText.setBounds(135, 21, 200, 20);
        load.setBounds(345, 15, 115, 25);

        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setBounds(35, 55, 360, 10);

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
        update.setBounds(105, 503, 150, 30);
        back.setBounds(275, 503, 80, 30);

        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sroll = rollText.getText();
                if(sroll == null || sroll.trim().equals("")) {
                    JOptionPane.showMessageDialog(frame, "Please Enter the Roll Number");
                }
                else {
                    int roll = Integer.parseInt(sroll);
                    Student s = StudentDB.getStudentByRoll(roll);
                    nameText.setText(s.getName());
                    emailText.setText(s.getEmail());
                    courseText.setText(s.getCourse());
                    feeText.setText(String.valueOf(s.getFee()));
                    paidText.setText(String.valueOf(s.getPaid()));
                    dueText.setText(String.valueOf(s.getDue()));
                    addressText.setText(s.getAddress());
                    cityText.setText(s.getCity());
                    stateText.setText(s.getState());
                    countryText.setText(s.getCountry());
                    contactText.setText(s.getContact());
                }
            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameText.getText();
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
                int roll = Integer.parseInt(rollText.getText());

                Student stud = new Student(roll,name,email,course,fee,paid,due,address,city,state,country,contact);
                int status = StudentDB.update(stud);

                if (status > 0) {
                    JOptionPane.showMessageDialog(frame, "Student Updated Successfully!");
                    AccountantSection.main(new String[]{});
                    frame.dispose();
                }
                else {
                    JOptionPane.showMessageDialog(frame, "Sorry, Unable to add Student!");
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

        panel.add(roll);
        panel.add(rollText);
        panel.add(separator);
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
        panel.add(update);
        panel.add(back);
        panel.add(load);
    }

    public static void main(String[] args) {
        new EditStudent();
    }
}
