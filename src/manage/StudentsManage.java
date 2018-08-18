package manage;

import Bean.Student;
import java.util.HashSet;
import java.util.Iterator;

public class StudentsManage {
    private HashSet<Student> students=new HashSet<>();

    public HashSet<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student){
        students.add(student);
    }
    public void printAllStudents() {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student next = iterator.next();
            System.out.println(next);
        }
    }
    public int getCount() {
        return students.size();
    }

    public double getAverage(){
        double sum=0;
        for(Student student:students){
            sum +=student.getScore();
        }
        return sum/students.size();
    }
    public int getHighest(){
        int max=0;
        for(Student student:students)
            if(student.getScore()>max)max=student.getScore();
        return max;
    }
}
