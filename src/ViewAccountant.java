import javax.swing.*;
import java.util.List;

public class ViewAccountant {
    private JFrame frame = new JFrame("View Accountant");

    public ViewAccountant() {
        List<Accountant> list = AccountantDB.view();
        int size = list.size();

        String[][] data = new String[size][4];
        int row = 0;

        for(Accountant acc:list) {
            data[row][0] = acc.getName();
            data[row][1] = acc.getPassword();
            data[row][2] = acc.getEmail();;
            data[row][3] = acc.getContact();
            row++;
        }

        String[] columnNames = {
                 "Name", "Password", "Email", "Contact No."
        };

        JTable table = new JTable(data, columnNames);
        JScrollPane pane = new JScrollPane(table);
        frame.add(pane);

        frame.setBounds(100, 100, 800, 400);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ViewAccountant();
    }

}
