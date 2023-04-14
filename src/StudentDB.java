import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDB {
    public static int save(Student stud) {
        int status = 0;
        try {
            Connection con = AccountantDB.getCon();
            PreparedStatement ps = con.prepareStatement("INSERT INTO student(name, email, course, fee, paid, due, address, city, state, country, contactno) values(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, stud.getName());
            ps.setString(2, stud.getEmail());
            ps.setString(3, stud.getCourse());
            ps.setInt(4, stud.getFee());
            ps.setInt(5, stud.getPaid());
            ps.setInt(6, stud.getDue());
            ps.setString(7, stud.getAddress());
            ps.setString(8, stud.getCity());
            ps.setString(9, stud.getState());
            ps.setString(10, stud.getCountry());
            ps.setString(11, stud.getContact());
            status=ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static int update(Student stud) {
        int status = 0;
        try {
            Connection con = AccountantDB.getCon();
            PreparedStatement ps = con.prepareStatement("UPDATE STUDENT SET name=?,email=?,course=?,fee=?,paid=?,due=?,address=?,city=?,state=?,country=?,contactno=? where rollno=?");
            ps.setString(1, stud.getName());
            ps.setString(2, stud.getEmail());
            ps.setString(3, stud.getCourse());
            ps.setInt(4, stud.getFee());
            ps.setInt(5, stud.getPaid());
            ps.setInt(6, stud.getDue());
            ps.setString(7, stud.getAddress());
            ps.setString(8, stud.getCity());
            ps.setString(9, stud.getState());
            ps.setString(10, stud.getCountry());
            ps.setString(11, stud.getContact());
            ps.setInt(12, stud.getRollno());
            status = ps.executeUpdate();
            con.close();
        }   catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    public static List<Student> view() {
        List<Student> list = new ArrayList<Student>();
        try {
            Connection con = AccountantDB.getCon();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM STUDENT");
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Student s = new Student();
                s.setRollno(rs.getInt("rollno"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setCourse(rs.getString("course"));
                s.setFee(rs.getInt("fee"));
                s.setPaid(rs.getInt("paid"));
                s.setDue(rs.getInt("due"));
                s.setAddress(rs.getString("address"));
                s.setCity(rs.getString("city"));
                s.setState(rs.getString("state"));
                s.setCountry(rs.getString("country"));
                s.setContact(rs.getString("contactno"));
                list.add(s);
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    public static Student getStudentByRoll(int roll){
        Student stud = new Student();
        try{
            Connection con=AccountantDB.getCon();
            PreparedStatement ps=con.prepareStatement("select * from student where rollno=?");
            ps.setInt(1,roll);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                stud.setRollno(rs.getInt("rollno"));
                stud.setName(rs.getString("name"));
                stud.setEmail(rs.getString("email"));
                stud.setCourse(rs.getString("course"));
                stud.setFee(rs.getInt("fee"));
                stud.setPaid(rs.getInt("paid"));
                stud.setDue(rs.getInt("due"));
                stud.setAddress(rs.getString("address"));
                stud.setCity(rs.getString("city"));
                stud.setState(rs.getString("state"));
                stud.setCountry(rs.getString("country"));
                stud.setContact(rs.getString("contactno"));
            }
            con.close();
        }catch(Exception e){System.out.println(e);}
        return stud;
    }
    public static List<Student> due(){
        List<Student> list=new ArrayList<Student>();
        try{
            Connection con=AccountantDB.getCon();
            PreparedStatement ps=con.prepareStatement("select * from student where due>0");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Student stud = new Student();
                stud.setRollno(rs.getInt("rollno"));
                stud.setName(rs.getString("name"));
                stud.setEmail(rs.getString("email"));
                stud.setCourse(rs.getString("course"));
                stud.setFee(rs.getInt("fee"));
                stud.setPaid(rs.getInt("paid"));
                stud.setDue(rs.getInt("due"));
                stud.setAddress(rs.getString("address"));
                stud.setCity(rs.getString("city"));
                stud.setState(rs.getString("state"));
                stud.setCountry(rs.getString("country"));
                stud.setContact(rs.getString("contactno"));
                list.add(stud);
            }
            con.close();
        }catch(Exception e){System.out.println(e);}
        return list;
    }
}
