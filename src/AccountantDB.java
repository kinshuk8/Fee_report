import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountantDB {
    public static Connection getCon() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/feereport",
                    "root", "Azulic_2003"
            );
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
    public static boolean validate(String username, String password) {
        boolean status = false;
        try {
            Connection con = getCon();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM accountant WHERE username = ? AND password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static int save(Accountant acc) {
        int status = 0;
        try {
            Connection con = getCon();
            PreparedStatement ps = con.prepareStatement("INSERT INTO accountant(username, password, email, contact) VALUES(?, ?, ?, ?)");
            ps.setString(1, acc.getName());
            ps.setString(2, acc.getPassword());
            ps.setString(3, acc.getEmail());
            ps.setString(4, acc.getContact());
            status = ps.executeUpdate();
            con.close();
        }   catch (Exception e) {
            System.out.println(e);
        }

        return status;
    }

    public static List<Accountant> view() {
        List<Accountant> list = new ArrayList<>();
        try {
            Connection con = getCon();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM accountant");
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Accountant acc = new Accountant();
                acc.setName(rs.getString(1));
                acc.setPassword(rs.getString(2));
                acc.setEmail(rs.getString(3));
                acc.setContact(rs.getString(4));
                list.add(acc);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
