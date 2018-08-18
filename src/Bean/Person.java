package Bean;

public class Person {
    private int id;
    private String name;
    private Sex sex;

    Person(){this.sex= new Sex(SexEnum.UNKNOWN);}
    public Person(int id, String name, SexEnum sexEnum){
        setId(id);setName(name);
        setSex(sexEnum);
    }
    public Person(int id,String name,String sexString){
        setId(id);setName(name);
        setSex(sexString);
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSex(SexEnum sexEnum){
        this.sex=new Sex(sexEnum);
    }
    public void setSex(String string){
        if(string.equals(Sex.male))this.sex=new Sex(SexEnum.MALE);
        if(string.equals(Sex.female))this.sex=new Sex(SexEnum.FEMALE);
        else this.sex=new Sex(SexEnum.UNKNOWN);
    }
    public int getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    public Sex getSex() {
        return sex;
    }

    //便于集合操作
    @Override
    public boolean equals(Object obj) {
        return this.id == ((Person)obj).getId();
    }
    @Override
    public int hashCode() {
        return id%47;
    }

    @Override
    public String toString() {
        return "id:"+id+",name:"+name+",sex:"+sex;
    }
}
enum SexEnum{
    MALE,FEMALE,UNKNOWN
}
class Sex{
    public static String male= "MALE",
        female="FEMALE",unknown="UNKNOWN";
    private SexEnum sexEnum;
    public Sex(){}
    public Sex(SexEnum sexEnum){this.sexEnum=sexEnum;}

    public void setSexEnum(String string){
        if(string.equals(male))this.sexEnum=SexEnum.MALE;
        if(string.equals(female))this.sexEnum=SexEnum.FEMALE;
        if(string.equals(unknown))this.sexEnum=SexEnum.UNKNOWN;
    }
    public String getSex() {
        switch (sexEnum){
            case MALE:
                return male;
            case FEMALE:
                return female;
            case UNKNOWN:
                return unknown;
            default:
                return unknown;
        }
    }
}
