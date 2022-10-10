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

public class userManage extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    Function function = new Function();
    Container container = this.getContentPane();
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel panel_1 = new JPanel();
    JPanel panel_2 = new JPanel();
    JPanel panel_3 = new JPanel();
    JPanel panel_4 = new JPanel();
    JPanel panel_5 = new JPanel();
    JPanel panel_6 = new JPanel();
    JLabel label = new JLabel("请按照提示依次输入用户信息！删除用户只需选择用户类型和填写学号！");
    JTextField ID = new JTextField(20);
    JTextField name = new JTextField(20);
    JTextField age = new JTextField(20);
    JTextField classes = new JTextField(20);
    JRadioButton teacher;
    JRadioButton student;
    JRadioButton male;
    JRadioButton female;
    ButtonGroup User;
    ButtonGroup Sex;
    JButton add;
    JButton delete;
    JButton change;
    JButton show;
    JButton clear;
    JButton back;

    public userManage() {
        super("用户管理");
        this.User = new ButtonGroup();
        this.teacher = new JRadioButton("教师");
        this.student = new JRadioButton("学生");
        this.User.add(this.teacher);
        this.User.add(this.student);
        this.Sex = new ButtonGroup();
        this.male = new JRadioButton("男");
        this.female = new JRadioButton("女");
        this.Sex.add(this.male);
        this.Sex.add(this.female);
        this.add = new JButton("添加用户");
        this.delete = new JButton("删除用户");
        this.change = new JButton("修改用户");
        this.show = new JButton("显示所有学生或教师用户");
        this.clear = new JButton("清空已填");
        this.back = new JButton("返回");
        this.p1.add(this.label, 0);
        this.p2.setLayout(new GridLayout(6, 1));
        this.p3.setLayout(new GridLayout(6,1));
        this.panel_1.add(new JLabel("用户类型：", SwingConstants.CENTER));
        this.panel_1.add(this.teacher);
        this.panel_1.add(this.student);
        this.panel_2.add(new JLabel("学/工号：", SwingConstants.CENTER));
        this.panel_2.add(this.ID);
        this.panel_3.add(new JLabel("姓名：", SwingConstants.CENTER));
        this.panel_3.add(this.name);
        this.panel_4.add(new JLabel("性别：", SwingConstants.CENTER));
        this.panel_4.add(this.male);
        this.panel_4.add(this.female);
        this.panel_5.add(new JLabel("年龄：", SwingConstants.CENTER));
        this.panel_5.add(this.age);
        this.panel_6.add(new JLabel("班级（教师无需填写）：", SwingConstants.CENTER));
        this.panel_6.add(this.classes);
        this.p2.add(this.panel_1);
        this.p2.add(this.panel_2);
        this.p2.add(this.panel_3);
        this.p2.add(this.panel_4);
        this.p2.add(this.panel_5);
        this.p2.add(this.panel_6);
        this.p3.add(this.add);
        this.p3.add(this.delete);
        this.p3.add(this.change);
        this.p3.add(this.show);
        this.p3.add(this.clear);
        this.p3.add(this.back);
        this.container.setLayout(new BorderLayout());
        this.container.add(this.p1, "North");
        this.container.add(this.p2, "Center");
        this.container.add(this.p3, "East");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(800, 500, 900, 450);
        this.setVisible(true);
        final Teacher tea = new Teacher();
        final Student stu = new Student();
        new Course();
        new ArrayList();
        new ArrayList();
        new ArrayList();
        this.add.addActionListener(e -> {
            String sID = userManage.this.ID.getText();
            String sName = userManage.this.name.getText();
            String sSex = null;
            if (userManage.this.male.isSelected()) {
                sSex = userManage.this.male.getText();
            } else if (userManage.this.female.isSelected()) {
                sSex = userManage.this.female.getText();
            }

            String sAge = userManage.this.age.getText();
            String sClasses = userManage.this.classes.getText();
            if (userManage.this.teacher.isSelected()) {
                if (userManage.this.fieldIsEmpty(sID, sName, sAge)) {
                    return;
                }

                if (userManage.this.teacherIsExist(sID)) {
                    JOptionPane.showMessageDialog(null, "该教师已经存在！");
                    userManage.this.Clear();
                    return;
                }

                tea.setID(sID);
                tea.setName(sName);
                tea.setSex(sSex);
                tea.setAge(sAge);
                tea.setApply("未申请监考替换");
                userManage.this.function.addTeacher(tea);
                userManage.this.function.writeFile();
            } else if (userManage.this.student.isSelected()) {
                if (userManage.this.fieldIsEmpty(sID, sName, sAge, sClasses)) {
                    return;
                }

                if (userManage.this.studentIsExist(sID)) {
                    JOptionPane.showMessageDialog(null, "该学生已经存在！");
                    userManage.this.Clear();
                    return;
                }

                stu.setID(sID);
                stu.setName(sName);
                stu.setSex(sSex);
                stu.setAge(sAge);
                stu.setClasses(sClasses);
                userManage.this.function.addStudent(stu);
                userManage.this.function.writeFile();
            }

            JOptionPane.showMessageDialog(null, "录入成功！！！");
            userManage.this.setVisible(false);
            new managerLogin();
        });
        this.delete.addActionListener(e -> {
            String sID = userManage.this.ID.getText();
            if (userManage.this.teacher.isSelected()) {
                if (sID.equals("")) {
                    JOptionPane.showMessageDialog(null, "输入学号为空！");
                    return;
                }

                if (!userManage.this.teacherIsExist(sID)) {
                    JOptionPane.showMessageDialog(null, "未找到该教师！");
                    userManage.this.Clear();
                    return;
                }

                userManage.this.function.deleteTeacher(sID);
                userManage.this.function.writeFile();
            } else if (userManage.this.student.isSelected()) {
                if (sID.equals("")) {
                    JOptionPane.showMessageDialog(null, "输入学号为空！");
                    return;
                }

                if (!userManage.this.studentIsExist(sID)) {
                    JOptionPane.showMessageDialog(null, "未找到该学生！");
                    userManage.this.Clear();
                    return;
                }

                userManage.this.function.deleteStudent(sID);
                userManage.this.function.writeFile();
            }

            JOptionPane.showMessageDialog(null, "删除成功！！！");
            userManage.this.setVisible(false);
            new managerLogin();
        });
        this.change.addActionListener(e -> {
            String sID = userManage.this.ID.getText();
            String sName = userManage.this.name.getText();
            String sSex = null;
            if (userManage.this.male.isSelected()) {
                sSex = userManage.this.male.getText();
            } else if (userManage.this.female.isSelected()) {
                sSex = userManage.this.female.getText();
            }

            String sAge = userManage.this.age.getText();
            String sClasses = userManage.this.classes.getText();
            String sApply = userManage.this.function.returnApply(sID);
            if (userManage.this.teacher.isSelected()) {
                if (userManage.this.fieldIsEmpty(sID, sName, sAge)) {
                    return;
                }

                if (!userManage.this.teacherIsExist(sID)) {
                    JOptionPane.showMessageDialog(null, "未找到该教师！");
                    userManage.this.Clear();
                    return;
                }

                tea.setID(sID);
                tea.setName(sName);
                tea.setSex(sSex);
                tea.setAge(sAge);
                tea.setApply(sApply);
                userManage.this.function.changeTeacher(tea);
                userManage.this.function.writeFile();
            } else if (userManage.this.student.isSelected()) {
                if (userManage.this.fieldIsEmpty(sID, sName, sAge, sClasses)) {
                    return;
                }

                if (!userManage.this.studentIsExist(sID)) {
                    JOptionPane.showMessageDialog(null, "未找到该学生！");
                    userManage.this.Clear();
                    return;
                }

                stu.setID(sID);
                stu.setName(sName);
                stu.setSex(sSex);
                stu.setAge(sAge);
                stu.setClasses(sClasses);
                userManage.this.function.changeStudent(stu);
                userManage.this.function.writeFile();
            }

            JOptionPane.showMessageDialog(null, "修改成功！！！");
            userManage.this.setVisible(false);
            new managerLogin();
        });
        this.show.addActionListener(e -> {
            if (userManage.this.teacher.isSelected()) {
                new showTeacher();
            }

            if (userManage.this.student.isSelected()) {
                new showStudent();
            }

        });
        this.clear.addActionListener(e -> userManage.this.Clear());
        this.back.addActionListener(e -> {
            userManage.this.setVisible(false);
            new managerLogin();
        });
    }

    void Clear() {
        this.ID.setText("");
        this.name.setText("");
        this.Sex.clearSelection();
        this.age.setText("");
        this.classes.setText("");
    }

    boolean teacherIsExist(String sID) {
        return this.function.findTeacher(sID) != -1;
    }

    boolean studentIsExist(String sID) {
        return this.function.findStudent(sID) != -1;
    }

    boolean fieldIsEmpty(String sID, String sName, String sAge) {
        if (sID.equals("")) {
            JOptionPane.showMessageDialog(null, "输入学号为空！");
            return true;
        } else if (sName.equals("")) {
            JOptionPane.showMessageDialog(null, "输入姓名为空！");
            return true;
        } else if (sAge.equals("")) {
            JOptionPane.showMessageDialog(null, "输入年龄为空！");
            return true;
        } else {
            return false;
        }
    }

    boolean fieldIsEmpty(String sID, String sName, String sAge, String sClasses) {
        if (sID.equals("")) {
            JOptionPane.showMessageDialog(null, "输入学号为空！");
            return true;
        } else if (sName.equals("")) {
            JOptionPane.showMessageDialog(null, "输入姓名为空！");
            return true;
        } else if (sAge.equals("")) {
            JOptionPane.showMessageDialog(null, "输入年龄为空！");
            return true;
        } else if (sClasses.equals("")) {
            JOptionPane.showMessageDialog(null, "输入班级为空！");
            return true;
        } else {
            return false;
        }
    }

    public void actionPerformed(ActionEvent e) {
    }
}