package Bean;

public class Student extends Person {
    private int grade;//年级
    private String className;//班级
    private int score;//成绩

    public Student(){super();}
    public Student(int id, String name, SexEnum sexEnum, int grade, String className){
        super(id,name,sexEnum);
        setClassName(className);
        setGrade(grade);
    }
    public Student(int id, String name, String sexString, int grade, String className,int score){
        super(id,name,sexString);
        setClassName(className);
        setGrade(grade);
        setScore(score);
    }

    public void setScore(int score){this.score=score;}
    public void setGrade(int grade){
        this.grade=grade;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    public int getGrade() {
        return grade;
    }
    public String getClassName() {
        return className;
    }
    public int getScore(){return this.score;}


    @Override
    public String toString() {
        return super.toString()+",grade:"+grade+",className:"+className+",score:"+score;
    }

}
