package Data;

import Bean.Student;
import manage.StudentsManage;

import java.sql.*;
import java.util.HashSet;

public class StudentDAO {
    private String url;
    private String user;
    private String passWord;

    public StudentDAO(String url,String user,String passWord){
        this.url=url;
        this.user=user;
        this.passWord=passWord;
    }

    public void add(Student student){
        try(Connection conn=DriverManager.getConnection(url,user,passWord);
        Statement statement=conn.createStatement()){
            String sql=String.format(
                    "INSERT INTO t_student(id,name,sex,grade,classname,score) VALUES ('%d','%s','%s','%d','%s','%d')",
                    student.getId(),student.getName(),student.getSex(),student.getGrade(),student.getClassName(),student.getScore()
            );

            statement.executeUpdate(sql);
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    public void get(StudentsManage studentsManage){
        HashSet<Student> students=studentsManage.getStudents();
        try(Connection conn=DriverManager.getConnection(url,user,passWord);
            Statement statement=conn.createStatement()){
            String sql="SELECT * FROM t_student";
            ResultSet result =
                    statement.executeQuery(sql);
            while(result.next()){
                Student student=toStudent(result);
                students.add(student);
            }

        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }
    public Student queryById(int id){
        try(Connection conn=DriverManager.getConnection(url,user,passWord);
            PreparedStatement statement=conn.prepareStatement("SELECT * FROM t_student WHERE id=?")){
        statement.setInt(1,id);
        ResultSet result=statement.executeQuery();
        result.next();
        return toStudent(result);

        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }

    private Student toStudent(ResultSet result) throws SQLException{
        Student student=new Student();
        //id,name,sex,grade,classname,score
        student.setId(result.getInt(1));
        student.setName(result.getString(2));
        student.setSex(result.getString(3));
        student.setGrade(result.getInt(4));
        student.setClassName(result.getString(5));
        student.setScore(result.getInt(6));

        return student;
    }
}
