package User;

    public class Teacher {
    private String ID;
    private String name;
    private String sex;
    private String age;
    private String apply;

    public Teacher() {
    }

    public Teacher(String ID, String name, String sex, String age, String apply) {
        this.ID = ID;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.apply = apply;
    }

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getApply() {
        return this.apply;
    }

    public void setApply(String apply) {
        this.apply = apply;
    }

    public String fileString() {
        return this.ID + " " + this.name + " " + this.sex + " " + this.age + " " + this.apply;
    }
}