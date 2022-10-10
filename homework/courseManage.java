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

public class courseManage extends JFrame implements ActionListener {
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
    JLabel label = new JLabel("请按照提示依次输入考试信息！删除考试只需填写考试编号！");
    JTextField ID = new JTextField(20);
    JTextField name = new JTextField(20);
    JTextField classes = new JTextField(20);
    JTextField place = new JTextField(20);
    JTextField date = new JTextField(20);
    JRadioButton morning;
    JRadioButton afternoon;
    JRadioButton evening;
    ButtonGroup Time;
    JButton add;
    JButton delete;
    JButton change;
    JButton show;
    JButton clear;
    JButton back;

    public courseManage() {
        super("考试管理");
        this.Time = new ButtonGroup();
        this.morning = new JRadioButton("9:00-11:00");
        this.afternoon = new JRadioButton("15:00-17:00");
        this.evening = new JRadioButton("19:00-21:00");
        this.Time.add(this.morning);
        this.Time.add(this.afternoon);
        this.Time.add(this.evening);
        this.add = new JButton("添加考试");
        this.delete = new JButton("删除考试");
        this.change = new JButton("修改考试");
        this.clear = new JButton("清空已填");
        this.show = new JButton("显示所有考试");
        this.back = new JButton("返回");
        this.p1.add(this.label, 0);
        this.p2.setLayout(new GridLayout(6, 1));
        this.p3.setLayout(new GridLayout(6,1));
        this.panel_1.add(new JLabel("考试编号：", SwingConstants.CENTER));
        this.panel_1.add(this.ID);
        this.panel_2.add(new JLabel("考试名称：", SwingConstants.CENTER));
        this.panel_2.add(this.name);
        this.panel_3.add(new JLabel("考试班级：", SwingConstants.CENTER));
        this.panel_3.add(this.classes);
        this.panel_4.add(new JLabel("考试地点：", SwingConstants.CENTER));
        this.panel_4.add(this.place);
        this.panel_5.add(new JLabel("考试日期：", SwingConstants.CENTER));
        this.panel_5.add(this.date);
        this.panel_6.add(new JLabel("考试时间：", SwingConstants.CENTER));
        this.panel_6.add(this.morning);
        this.panel_6.add(this.afternoon);
        this.panel_6.add(this.evening);
        this.p2.add(this.panel_1);
        this.p2.add(this.panel_2);
        this.p2.add(this.panel_3);
        this.p2.add(this.panel_4);
        this.p2.add(this.panel_5);
        this.p2.add(this.panel_6);
        this.p3.add(this.add);
        this.p3.add(this.delete);
        this.p3.add(this.change);
        this.p3.add(this.clear);
        this.p3.add(this.show);
        this.p3.add(this.back);
        this.container.setLayout(new BorderLayout());
        this.container.add(this.p1, "North");
        this.container.add(this.p2, "Center");
        this.container.add(this.p3, "East");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(800, 300, 900, 600);
        this.setVisible(true);
        new Teacher();
        new Student();
        final Course cou = new Course();
        new ArrayList();
        new ArrayList();
        new ArrayList();
        this.add.addActionListener(e -> {
            String sID = courseManage.this.ID.getText();
            String sName = courseManage.this.name.getText();
            String sClasses = courseManage.this.classes.getText();
            String sPlace = courseManage.this.place.getText();
            String sDate = courseManage.this.date.getText();
            String sTime = null;
            if (courseManage.this.morning.isSelected()) {
                sTime = courseManage.this.morning.getText();
            } else if (courseManage.this.afternoon.isSelected()) {
                sTime = courseManage.this.afternoon.getText();
            } else if (courseManage.this.evening.isSelected()) {
                sTime = courseManage.this.evening.getText();
            }

            if (courseManage.this.fieldIsEmpty(sID, sName, sClasses, sPlace, sDate)) {
                if (courseManage.this.courseIsExist(sID)) {
                    JOptionPane.showMessageDialog(null, "该考试已经存在！");
                    courseManage.this.Clear();
                } else if (courseManage.this.timeIsConflict(sPlace, sDate, sTime)) {
                    courseManage.this.Clear();
                } else {
                    cou.setID(sID);
                    cou.setName(sName);
                    cou.setClasses(sClasses);
                    cou.setTeacher("未安排监考老师");
                    cou.setPlace(sPlace);
                    cou.setDate(sDate);
                    cou.setTime(sTime);
                    courseManage.this.function.addCourse(cou);
                    courseManage.this.function.writeFile();
                    JOptionPane.showMessageDialog(null, "录入成功！！！");
                    courseManage.this.setVisible(false);
                    new managerLogin();
                }
            }
        });
        this.delete.addActionListener(e -> {
            String sID = courseManage.this.ID.getText();
            if (!courseManage.this.fieldIsEmpty(sID)) {
                if (courseManage.this.courseIsExist(sID)) {
                    courseManage.this.function.deleteCourse(sID);
                    courseManage.this.function.writeFile();
                    JOptionPane.showMessageDialog(null, "删除成功！！！");
                    courseManage.this.setVisible(false);
                    new managerLogin();
                } else {
                    JOptionPane.showMessageDialog(null, "未找到该考试！");
                    courseManage.this.Clear();
                }
            }
        });
        this.change.addActionListener(e -> {
            String sID = courseManage.this.ID.getText();
            String sName = courseManage.this.name.getText();
            String sClasses = courseManage.this.classes.getText();
            String sTeacher = courseManage.this.function.returnTeacher(sID);
            String sPlace = courseManage.this.place.getText();
            String sDate = courseManage.this.date.getText();
            String sTime = null;
            if (courseManage.this.morning.isSelected()) {
                sTime = courseManage.this.morning.getText();
            } else if (courseManage.this.afternoon.isSelected()) {
                sTime = courseManage.this.afternoon.getText();
            } else if (courseManage.this.evening.isSelected()) {
                sTime = courseManage.this.evening.getText();
            }

            if (courseManage.this.fieldIsEmpty(sID, sName, sClasses, sPlace, sDate)) {
                if (courseManage.this.timeIsConflict(sPlace, sDate, sTime)) {
                    courseManage.this.Clear();
                } else if (courseManage.this.courseIsExist(sID)) {
                    cou.setID(sID);
                    cou.setName(sName);
                    cou.setClasses(sClasses);
                    cou.setTeacher(sTeacher);
                    cou.setPlace(sPlace);
                    cou.setDate(sDate);
                    cou.setTime(sTime);
                    courseManage.this.function.changeCourse(cou);
                    courseManage.this.function.writeFile();
                    JOptionPane.showMessageDialog(null, "修改成功！！！");
                    courseManage.this.setVisible(false);
                    new managerLogin();
                } else {
                    JOptionPane.showMessageDialog(null, "未找到该考试！");
                    courseManage.this.Clear();
                }
            }
        });
        this.show.addActionListener(e -> new showCourse());
        this.clear.addActionListener(e -> courseManage.this.Clear());
        this.back.addActionListener(e -> {
            courseManage.this.setVisible(false);
            new managerLogin();
        });
    }

    void Clear() {
        this.ID.setText("");
        this.name.setText("");
        this.classes.setText("");
        this.place.setText("");
        this.date.setText("");
        this.Time.clearSelection();
    }

    boolean courseIsExist(String sID) {
        return this.function.findCourse(sID) != -1;
    }

    boolean fieldIsEmpty(String sID) {
        if (sID.equals("")) {
            JOptionPane.showMessageDialog(null, "输入考生编号为空！");
            return true;
        } else {
            return false;
        }
    }

    boolean fieldIsEmpty(String sID, String sName, String sClasses, String sPlace, String sDate) {
        if (sID.equals("")) {
            JOptionPane.showMessageDialog(null, "输入考试编号为空！");
            return false;
        } else if (sName.equals("")) {
            JOptionPane.showMessageDialog(null, "输入考试名称为空！");
            return false;
        } else if (sClasses.equals("")) {
            JOptionPane.showMessageDialog(null, "输入考试班级为空！");
            return false;
        } else if (sPlace.equals("")) {
            JOptionPane.showMessageDialog(null, "输入考试地点为空！");
            return false;
        } else if (sDate.equals("")) {
            JOptionPane.showMessageDialog(null, "输入考试日期为空！");
            return false;
        } else {
            return true;
        }
    }

    boolean timeIsConflict(String sPlace, String sDate, String sTime) {
        int flag = this.function.checkCourse(sPlace, sDate, sTime);
        if (flag == -1) {
            JOptionPane.showMessageDialog(null, "考试时间冲突！");
            return true;
        } else {
            return false;
        }
    }

    public void actionPerformed(ActionEvent e) {
    }
}