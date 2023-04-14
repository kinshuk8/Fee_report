import java.util.*;
import javax.swing.*;

public class DueFee {
    JFrame frame = new JFrame("Due Fee");
    public DueFee() {
        List<Student> list = StudentDB.due();
        int size = list.size();

        String[][] data = new String[size][12];
        int row = 0;
        for(Student s:list) {
            data[row][0] = String.valueOf(s.getRollno());
            data[row][1] = s.getName();
            data[row][2] = s.getEmail();
            data[row][3] = s.getCourse();
            data[row][4] = String.valueOf(s.getFee());
            data[row][5] = String.valueOf(s.getPaid());
            data[row][6] = String.valueOf(s.getDue());
            data[row][7] = s.getAddress();
            data[row][8] = s.getCity();
            data[row][9] = s.getState();
            data[row][10] = s.getCountry();
            data[row][11] = s.getContact();

            row++;
        }

        String[] columnNames = {"Roll no.","Name","Email","Course","Fee","Paid","Due","Address","City","State","Country","Contact No."};
        JTable table = new JTable(data, columnNames);
        JScrollPane pane = new JScrollPane(table);
        frame.add(pane);

        frame.setBounds(100, 100, 800, 400);
        frame.setVisible(true);
        frame.setLayout(null);
    }

    public static void main(String[] args) {
        new DueFee();
    }
}
