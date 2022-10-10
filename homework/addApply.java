package examManage;

import User.Course;
import User.Student;
import User.Teacher;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class addApply extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    Function function = new Function();
    Container container = this.getContentPane();
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel panel_1 = new JPanel();
    JPanel panel_2 = new JPanel();
    JLabel label = new JLabel("请按照提示依次输入教师学号和考试编号!");
    JTextField teacher = new JTextField(20);
    JTextField course = new JTextField(20);
    JButton apply = new JButton("提交申请");
    JButton clear = new JButton("清空已填");
    JButton back = new JButton("返回");

    public addApply() {
        super("监考替换申请");
        this.p1.add(this.label, 0);
        this.p2.setLayout(new GridLayout(2, 1));
        this.panel_1.add(new JLabel("教师学号："), 0);
        this.panel_1.add(this.teacher);
        this.panel_2.add(new JLabel("考试编号："), 0);
        this.panel_2.add(this.course);
        this.p2.add(this.panel_1);
        this.p2.add(this.panel_2);
        this.p3.add(this.apply);
        this.p3.add(this.clear);
        this.p3.add(this.back);
        this.container.setLayout(new BorderLayout());
        this.container.add(this.p1, "North");
        this.container.add(this.p2, "Center");
        this.container.add(this.p3, "South");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(800, 500, 900, 450);
        this.setVisible(true);
        final Teacher tea = new Teacher();
        new Student();
        final Course cou = new Course();
        new ArrayList();
        new ArrayList();
        new ArrayList();
        this.apply.addActionListener(e -> {
            String teaID = addApply.this.teacher.getText();
            String couID = addApply.this.course.getText();
            if (!addApply.this.fieldIsEmpty(teaID, couID)) {
                if (addApply.this.teacherIsNotExist(teaID)) {
                    JOptionPane.showMessageDialog(null, "未找到该教师！");
                    addApply.this.Clear();
                } else if (addApply.this.courseIsNotExist(couID)) {
                    JOptionPane.showMessageDialog(null, "未找到该考试！");
                    addApply.this.Clear();
                } else if (addApply.this.teacherAndCourse(teaID, couID)) {
                    JOptionPane.showMessageDialog(null, "该考试的监考教师不是该教师！");
                    addApply.this.Clear();
                } else if (addApply.this.applyIsNotNull(teaID)) {
                    JOptionPane.showMessageDialog(null, "该教师已申请监考替换！");
                    addApply.this.Clear();
                } else {
                    String couName = addApply.this.function.returnName(couID);
                    String couClasses = addApply.this.function.returnClasses(couID);
                    String couPlace = addApply.this.function.returnPlace(couID);
                    String couDate = addApply.this.function.returnDate(couID);
                    String couTime = addApply.this.function.returnTime(couID);
                    String teaName = addApply.this.function.returnTeaName(teaID);
                    String teaSex = addApply.this.function.returnTeaSex(teaID);
                    String teaAge = addApply.this.function.returnTeaAge(teaID);
                    cou.setID(couID);
                    cou.setName(couName);
                    cou.setClasses(couClasses);
                    cou.setTeacher(teaID);
                    cou.setPlace(couPlace);
                    cou.setDate(couDate);
                    cou.setTime(couTime);
                    tea.setID(teaID);
                    tea.setName(teaName);
                    tea.setSex(teaSex);
                    tea.setSex(teaSex);
                    tea.setAge(teaAge);
                    tea.setApply(couID);
                    addApply.this.function.changeCourse(cou);
                    addApply.this.function.changeTeacher(tea);
                    addApply.this.function.writeFile();
                    JOptionPane.showMessageDialog(null, "申请成功！！！");
                    addApply.this.setVisible(false);
                    new teacherLogin();
                }
            }
        });
        this.clear.addActionListener(e -> addApply.this.Clear());
        this.back.addActionListener(e -> {
            addApply.this.setVisible(false);
            new teacherLogin();
        });
    }

    void Clear() {
        this.teacher.setText("");
        this.course.setText("");
    }

    boolean fieldIsEmpty(String teaID, String couID) {
        if (teaID.equals("")) {
            JOptionPane.showMessageDialog(null, "输入教师学号为空！");
            return true;
        } else if (couID.equals("")) {
            JOptionPane.showMessageDialog(null, "输入考试编号为空！");
            return true;
        } else {
            return false;
        }
    }

    boolean teacherIsNotExist(String teaID) {
        return this.function.findTeacher(teaID) == -1;
    }

    boolean courseIsNotExist(String couID) {
        return this.function.findCourse(couID) == -1;
    }

    boolean applyIsNotNull(String teaID) {
        return this.function.checkApply(teaID) != -1;
    }

    boolean teacherAndCourse(String teaID, String couID) {
        return this.function.checkTeacherAndCourse(teaID, couID) != -1;
    }

    public void actionPerformed(ActionEvent e) {
    }
}
