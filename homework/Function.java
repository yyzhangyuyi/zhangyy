package examManage;

import User.Course;
import User.Student;
import User.Teacher;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Function {
    ArrayList<Student> studentArray = new ArrayList<>();
    ArrayList<Teacher> teacherArray = new ArrayList<>();
    ArrayList<Course> courseArray = new ArrayList<>();

    public Function() {
        this.readFile();
    }

    public void readFile() {
        this.readTeacherFile();
        this.readStudentFile();
        this.readCourseFile();
    }

    public void writeFile() {
        this.writeTeacherFile();
        this.writeStudentFile();
        this.writeCourseFile();
    }

    public void readTeacherFile() {
        String line;

        try {
            FileReader fr = new FileReader("C:\\Users\\admin\\Desktop\\untitled\\src\\teacher.txt");
            BufferedReader br = new BufferedReader(fr);
            this.teacherArray.clear();

            while((line = br.readLine()) != null) {
                String[] s = line.split("\\s+");
                Teacher teacher = new Teacher(s[0], s[1], s[2], s[3], s[4]);
                this.teacherArray.add(teacher);
            }

            fr.close();
            br.close();
        } catch (IOException var6) {
            var6.printStackTrace();
        }

    }

    public void readStudentFile() {
        String line;

        try {
            FileReader fr = new FileReader("C:\\Users\\admin\\Desktop\\untitled\\src\\student.txt");
            BufferedReader br = new BufferedReader(fr);
            this.studentArray.clear();

            while((line = br.readLine()) != null) {
                String[] s = line.split("\\s+");
                Student student = new Student(s[0], s[1], s[2], s[3], s[4]);
                this.studentArray.add(student);
            }

            fr.close();
            br.close();
        } catch (IOException var6) {
            var6.printStackTrace();
        }

    }

    public void readCourseFile() {
        String line;

        try {
            FileReader fr = new FileReader("C:\\Users\\admin\\Desktop\\untitled\\src\\course.txt");
            BufferedReader br = new BufferedReader(fr);
            this.courseArray.clear();

            while((line = br.readLine()) != null) {
                String[] s = line.split("\\s+");
                Course course = new Course(s[0], s[1], s[2], s[3], s[4], s[5], s[6]);
                this.courseArray.add(course);
            }

            fr.close();
            br.close();
        } catch (IOException var6) {
            var6.printStackTrace();
        }

    }

    public void writeTeacherFile() {
        FileWriter fw;
        BufferedWriter out;

        try {
            fw = new FileWriter("C:\\Users\\admin\\Desktop\\untitled\\src\\teacher.txt");
            out = new BufferedWriter(fw);

            for(int i = 0; i < this.teacherArray.size(); ++i) {
                String s = (this.teacherArray.get(i)).fileString();
                out.write(s);
                out.newLine();
            }

            out.close();
            fw.close();
        } catch (IOException var5) {
            var5.printStackTrace();
        }

    }

    public void writeStudentFile() {
        FileWriter fw;
        BufferedWriter out;

        try {
            fw = new FileWriter("C:\\Users\\admin\\Desktop\\untitled\\src\\student.txt");
            out = new BufferedWriter(fw);

            for(int i = 0; i < this.studentArray.size(); ++i) {
                String s = (this.studentArray.get(i)).fileString();
                out.write(s);
                out.newLine();
            }

            out.close();
            fw.close();
        } catch (IOException var5) {
            var5.printStackTrace();
        }

    }

    public void writeCourseFile() {
        FileWriter fw;
        BufferedWriter out;

        try {
            fw = new FileWriter("C:\\Users\\admin\\Desktop\\untitled\\src\\course.txt");
            out = new BufferedWriter(fw);

            for(int i = 0; i < this.courseArray.size(); ++i) {
                String s = (this.courseArray.get(i)).fileString();
                out.write(s);
                out.newLine();
            }

            out.close();
            fw.close();
        } catch (IOException var5) {
            var5.printStackTrace();
        }

    }

    public int findTeacher(String ID) {
        for(int i = 0; i < this.teacherArray.size(); ++i) {
            if ((this.teacherArray.get(i)).getID().equals(ID)) {
                return i;
            }
        }

        return -1;
    }

    public int findStudent(String ID) {
        for(int i = 0; i < this.studentArray.size(); ++i) {
            if ((this.studentArray.get(i)).getID().equals(ID)) {
                return i;
            }
        }

        return -1;
    }

    public int findCourse(String ID) {
        for(int i = 0; i < this.courseArray.size(); ++i) {
            if ((this.courseArray.get(i)).getID().equals(ID)) {
                return i;
            }
        }

        return -1;
    }

    public String returnApply(String ID) {
        int flag = this.findTeacher(ID);
        return (this.teacherArray.get(flag)).getApply();
    }

    public String returnTeacher(String ID) {
        int flag = this.findCourse(ID);
        return (this.courseArray.get(flag)).getTeacher();
    }

    public String returnName(String ID) {
        int flag = this.findCourse(ID);
        return (this.courseArray.get(flag)).getName();
    }

    public String returnClasses(String ID) {
        int flag = this.findCourse(ID);
        return (this.courseArray.get(flag)).getClasses();
    }

    public String returnPlace(String ID) {
        int flag = this.findCourse(ID);
        return (this.courseArray.get(flag)).getPlace();
    }

    public String returnDate(String ID) {
        int flag = this.findCourse(ID);
        return (this.courseArray.get(flag)).getDate();
    }

    public String returnTime(String ID) {
        int flag = this.findCourse(ID);
        return (this.courseArray.get(flag)).getTime();
    }

    public String returnTeaName(String ID) {
        int flag = this.findTeacher(ID);
        return (this.teacherArray.get(flag)).getName();
    }

    public String returnTeaSex(String ID) {
        int flag = this.findTeacher(ID);
        return (this.teacherArray.get(flag)).getSex();
    }

    public String returnTeaAge(String ID) {
        int flag = this.findTeacher(ID);
        return (this.teacherArray.get(flag)).getAge();
    }

    public int checkCourse(String place, String date, String time) {
        for(int i = 0; i < this.courseArray.size(); ++i) {

            if ((this.courseArray.get(i)).getPlace().equals(place) && (this.courseArray.get(i)).getDate().equals(date) && (this.courseArray.get(i)).getTime().equals(time)) {
                return -1;
            }
        }

        return 1;
    }

    public int checkCourse(String ID, String teacher) {
        int flag = this.findCourse(ID);
        String date = (this.courseArray.get(flag)).getDate();
        String time = (this.courseArray.get(flag)).getTime();

        for(int i = 0; i < this.courseArray.size(); ++i) {
            if ((this.courseArray.get(i)).getTeacher().equals(teacher) && (this.courseArray.get(i)).getDate().equals(date) && (this.courseArray.get(i)).getTime().equals(time)) {
                return -1;
            }
        }

        return 1;
    }

    public int checkTeacher(String ID) {
        int flag = this.findCourse(ID);
        return (this.courseArray.get(flag)).getTeacher().equals("未安排监考老师") ? -1 : 1;
    }

    public int checkTeacherAndCourse(String teaID, String couID) {
        int flag = this.findCourse(couID);
        return (this.courseArray.get(flag)).getTeacher().equals(teaID) ? -1 : 1;
    }

    public int checkApply(String ID) {
        int flag = this.findTeacher(ID);
        return (this.teacherArray.get(flag)).getApply().equals("未申请监考替换") ? -1 : 1;
    }

    public void addStudent(Student student) {
        this.studentArray.add(student);
    }

    public void addTeacher(Teacher teacher) {
        this.teacherArray.add(teacher);
    }

    public void addCourse(Course course) {
        this.courseArray.add(course);
    }

    public void deleteTeacher(String ID) {
        this.teacherArray.remove(this.findTeacher(ID));
    }

    public void deleteStudent(String ID) {
        this.studentArray.remove(this.findStudent(ID));
    }

    public void deleteCourse(String ID) {
        this.courseArray.remove(this.findCourse(ID));
    }

    public void changeTeacher(Teacher teacher) {
        int flag = this.findTeacher(teacher.getID());
        this.teacherArray.set(flag, teacher);
    }

    public void changeStudent(Student student) {
        int flag = this.findStudent(student.getID());
        this.studentArray.set(flag, student);
    }

    public void changeCourse(Course course) {
        int flag = this.findCourse(course.getID());
        this.courseArray.set(flag, course);
    }
}
