package test;

import Bean.Student;
import Data.StudentDAO;
import manage.StudentsManage;

import java.util.Scanner;

import static java.lang.System.out;

public class test {
    public static void main(String[] args)throws Exception {
        StudentsManage studentsManage=new StudentsManage();
        StudentDAO dao = new StudentDAO(
                "jdbc:mysql://localhost:3306/db_student?" +
                        "useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false",
                "root", "******");
        Scanner console = new Scanner(System.in);
        while (true) {
            out.print("(1)遍历数据表后，显示所有学生及成绩信息\n" +
                    "（2）新增学生信息\n (3)按ID号查找学生成绩信息\n （4）遍历数据表，并输出学生成绩统计信息\n");
            switch (Integer.parseInt(console.nextLine())) {
                case 1:
                    dao.get(studentsManage);
                    studentsManage.printAllStudents();
                    break;
                case 2:
                    //id,name,sex,grade,classname,score
                    int id;String name;String sexString;int grade;String classname;int score;
                    out.print("id: ");id=Integer.parseInt(console.nextLine());
                    out.print("name: ");name=console.nextLine();
                    out.print("sex(MALE/FEMALE/UNKNOWN): ");sexString=console.nextLine();
                    out.print("grade: ");grade=Integer.parseInt(console.nextLine());
                    out.print("classname: ");classname=console.nextLine();
                    out.print("score: ");score=Integer.parseInt(console.nextLine());
                    dao.add(new Student(id,name,sexString,grade,classname,score));
                    break;
                case 3:
                    int queryId;
                    out.print("id: ");queryId=Integer.parseInt(console.nextLine());
                    Student student=dao.queryById(queryId);
                    out.print(student);
                    break;
                case 4:
                    dao.get(studentsManage);
                    out.printf("学生总数：%d\n",studentsManage.getCount());
                    out.printf("平均成绩：%.2f\n",studentsManage.getAverage());
                    out.printf("最高成绩：%d\n",studentsManage.getHighest());
            }
        }
    }
}
