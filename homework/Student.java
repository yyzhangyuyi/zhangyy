package User;

    public class Student {
    private String ID;
    private String name;
    private String sex;
    private String age;
    private String classes;

    public Student() {
    }

    public Student(String ID, String name, String sex, String age, String classes) {
        this.ID = ID;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.classes = classes;
    }

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

        public void setName(String name) {
        this.name = name;
    }

        public void setSex(String sex) {
        this.sex = sex;
    }

        public void setAge(String age) {
        this.age = age;
    }

        public void setClasses(String classes) {
        this.classes = classes;
    }

    public String fileString() {
        return this.ID + " " + this.name + " " + this.sex + " " + this.age + " " + this.classes;
    }
}