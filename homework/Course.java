package User;

    public class Course {
    private String ID;
    private String name;
    private String classes;
    private String teacher;
    private String place;
    private String date;
    private String time;

    public Course() {
    }

    public Course(String ID, String name, String classes, String teacher, String place, String date, String time) {
        this.ID = ID;
        this.name = name;
        this.classes = classes;
        this.teacher = teacher;
        this.place = place;
        this.date = date;
        this.time = time;
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

    public String getClasses() {
        return this.classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getTeacher() {
        return this.teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getPlace() {
        return this.place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String fileString() {
        return this.ID + " " + this.name + " " + this.classes + " " + this.teacher + " " + this.place + " " + this.date + " " + this.time;
    }
}