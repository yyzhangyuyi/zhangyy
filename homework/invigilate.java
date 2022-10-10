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

class invigilateManage extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    Function function = new Function();
    Container container = this.getContentPane();
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel panel_1 = new JPanel();
    JPanel panel_2 = new JPanel();
    JLabel label = new JLabel("请按照提示依次输入监考信息！ 删除监考只需填写考试编号！ 通过监考替换申请只需填写监考教师工号！");
    JTextField ID = new JTextField(20);
    JTextField teacher = new JTextField(20);
    JButton add = new JButton("添加监考");
    JButton delete = new JButton("删除监考");
    JButton change = new JButton("修改监考");
    JButton show = new JButton("展示考试信息");
    JButton show_1= new JButton("展示教师申请信息");
    JButton apply = new JButton("通过监考替换申请");
    JButton clear = new JButton("清空已填");
    JButton back = new JButton("返回");

    public invigilateManage() {
        super("监考管理");
        this.p1.add(this.label, 0);
        this.p2.setLayout(new GridLayout(2, 1));
        this.p3.setLayout(new GridLayout(8,1));
        this.panel_1.add(new JLabel("考试编号：", SwingConstants.CENTER));
        this.panel_1.add(this.ID);
        this.panel_2.add(new JLabel("监考教师：", SwingConstants.CENTER));
        this.panel_2.add(this.teacher);
        this.p2.add(this.panel_1);
        this.p2.add(this.panel_2);
        this.p3.add(this.add);
        this.p3.add(this.delete);
        this.p3.add(this.change);
        this.p3.add(this.show);
        this.p3.add(this.show_1);
        this.p3.add(this.apply);
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
        new Student();
        final Course cou = new Course();
        new ArrayList();
        new ArrayList();
        new ArrayList();
        this.add.addActionListener(e -> {
            String sID = invigilateManage.this.ID.getText();
            String sTeacher = invigilateManage.this.teacher.getText();
            if (invigilateManage.this.fieldIsEmpty(sID, sTeacher)) {
                if (invigilateManage.this.courseIsNotExist(sID)) {
                    JOptionPane.showMessageDialog(null, "未找到该考试！");
                    invigilateManage.this.Clear();
                } else if (invigilateManage.this.teacherIsNotExist(sTeacher)) {
                    JOptionPane.showMessageDialog(null, "未找到该教师！");
                    invigilateManage.this.Clear();
                } else if (invigilateManage.this.teacherIsNotEmpty(sID)) {
                    JOptionPane.showMessageDialog(null, "该考试已有监考老师！");
                    invigilateManage.this.Clear();
                } else if (invigilateManage.this.timeIsConflict(sID, sTeacher)) {
                    invigilateManage.this.Clear();
                } else {
                    String sName = invigilateManage.this.function.returnName(sID);
                    String sClasses = invigilateManage.this.function.returnClasses(sID);
                    String sPlace = invigilateManage.this.function.returnPlace(sID);
                    String sDate = invigilateManage.this.function.returnDate(sID);
                    String sTime = invigilateManage.this.function.returnTime(sID);
                    cou.setID(sID);
                    cou.setName(sName);
                    cou.setClasses(sClasses);
                    cou.setTeacher(sTeacher);
                    cou.setPlace(sPlace);
                    cou.setDate(sDate);
                    cou.setTime(sTime);
                    invigilateManage.this.function.changeCourse(cou);
                    invigilateManage.this.function.writeFile();
                    JOptionPane.showMessageDialog(null, "录入成功！！！");
                    invigilateManage.this.setVisible(false);
                    new managerLogin();
                }
            }
        });
        this.delete.addActionListener(e -> {
            String sID = invigilateManage.this.ID.getText();
            if (invigilateManage.this.fieldIsEmpty(sID)) {
                if (invigilateManage.this.courseIsNotExist(sID)) {
                    JOptionPane.showMessageDialog(null, "未找到该考试！");
                    invigilateManage.this.Clear();
                } else if (invigilateManage.this.teacherIsEmpty(sID)) {
                    JOptionPane.showMessageDialog(null, "该考试无监考老师！");
                    invigilateManage.this.Clear();
                } else {
                    String sName = invigilateManage.this.function.returnName(sID);
                    String sClasses = invigilateManage.this.function.returnClasses(sID);
                    String sPlace = invigilateManage.this.function.returnPlace(sID);
                    String sDate = invigilateManage.this.function.returnDate(sID);
                    String sTime = invigilateManage.this.function.returnTime(sID);
                    cou.setID(sID);
                    cou.setName(sName);
                    cou.setClasses(sClasses);
                    cou.setTeacher("未安排监考老师");
                    cou.setPlace(sPlace);
                    cou.setDate(sDate);
                    cou.setTime(sTime);
                    invigilateManage.this.function.changeCourse(cou);
                    invigilateManage.this.function.writeFile();
                    JOptionPane.showMessageDialog(null, "删除成功！！！");
                    invigilateManage.this.setVisible(false);
                    new managerLogin();
                }
            }
        });
        this.change.addActionListener(e -> {
            String sID = invigilateManage.this.ID.getText();
            String sTeacher = invigilateManage.this.teacher.getText();
            if (invigilateManage.this.fieldIsEmpty(sID, sTeacher)) {
                if (invigilateManage.this.courseIsNotExist(sID)) {
                    JOptionPane.showMessageDialog(null, "未找到该考试！");
                    invigilateManage.this.Clear();
                } else if (invigilateManage.this.teacherIsNotExist(sTeacher)) {
                    JOptionPane.showMessageDialog(null, "未找到该教师！");
                    invigilateManage.this.Clear();
                } else if (invigilateManage.this.teacherIsEmpty(sID)) {
                    JOptionPane.showMessageDialog(null, "该考试无监考老师！");
                    invigilateManage.this.Clear();
                } else if (invigilateManage.this.timeIsConflict(sID, sTeacher)) {
                    invigilateManage.this.Clear();
                } else {
                    String sName = invigilateManage.this.function.returnName(sID);
                    String sClasses = invigilateManage.this.function.returnClasses(sID);
                    String sPlace = invigilateManage.this.function.returnPlace(sID);
                    String sDate = invigilateManage.this.function.returnDate(sID);
                    String sTime = invigilateManage.this.function.returnTime(sID);
                    cou.setID(sID);
                    cou.setName(sName);
                    cou.setClasses(sClasses);
                    cou.setTeacher(sTeacher);
                    cou.setPlace(sPlace);
                    cou.setDate(sDate);
                    cou.setTime(sTime);
                    invigilateManage.this.function.changeCourse(cou);
                    invigilateManage.this.function.writeFile();
                    JOptionPane.showMessageDialog(null, "删除成功！！！");
                    invigilateManage.this.setVisible(false);
                    new managerLogin();
                }
            }
        });
        this.show.addActionListener(e -> new showCourse());
        this.show_1.addActionListener(e -> new showTeacher());
        this.apply.addActionListener(e -> {
            String sTeacher = invigilateManage.this.teacher.getText();
            if (invigilateManage.this.fieldIsEmpty(sTeacher)) {
                if (invigilateManage.this.teacherIsNotExist(sTeacher)) {
                    JOptionPane.showMessageDialog(null, "未找到该教师！");
                    invigilateManage.this.Clear();
                } else if (invigilateManage.this.applyIsNull(sTeacher)) {
                    invigilateManage.this.Clear();
                } else {
                    String couID = invigilateManage.this.function.returnApply(sTeacher);
                    String couName = invigilateManage.this.function.returnName(couID);
                    String couClasses = invigilateManage.this.function.returnClasses(couID);
                    String couTeacher = "未安排监考老师";
                    String couPlace = invigilateManage.this.function.returnPlace(couID);
                    String couDate = invigilateManage.this.function.returnDate(couID);
                    String couTime = invigilateManage.this.function.returnTime(couID);
                    cou.setID(couID);
                    cou.setName(couName);
                    cou.setClasses(couClasses);
                    cou.setTeacher(couTeacher);
                    cou.setPlace(couPlace);
                    cou.setDate(couDate);
                    cou.setTime(couTime);
                    String teaName = invigilateManage.this.function.returnTeaName(sTeacher);
                    String teaSex = invigilateManage.this.function.returnTeaSex(sTeacher);
                    String teaAge = invigilateManage.this.function.returnTeaAge(sTeacher);
                    String teaApply = "未申请监考替换";
                    tea.setID(sTeacher);
                    tea.setName(teaName);
                    tea.setSex(teaSex);
                    tea.setAge(teaAge);
                    tea.setApply(teaApply);
                    invigilateManage.this.function.changeCourse(cou);
                    invigilateManage.this.function.changeTeacher(tea);
                    invigilateManage.this.function.writeFile();
                    JOptionPane.showMessageDialog(null, "审核成功！！！");
                    invigilateManage.this.setVisible(false);
                    new managerLogin();
                }
            }
        });
        this.clear.addActionListener(e -> invigilateManage.this.Clear());
        this.back.addActionListener(e -> {
            invigilateManage.this.setVisible(false);
            new managerLogin();
        });
    }

    void Clear() {
        this.ID.setText("");
        this.teacher.setText("");
    }

    boolean courseIsNotExist(String sID) {
        return this.function.findCourse(sID) == -1;
    }

    boolean teacherIsNotExist(String sTeacher) {
        return this.function.findTeacher(sTeacher) == -1;
    }

    boolean teacherIsNotEmpty(String sID) {
        return this.function.checkTeacher(sID) != -1;
    }

    boolean teacherIsEmpty(String sID) {
        return this.function.checkTeacher(sID) == -1;
    }

    boolean fieldIsEmpty(String sID, String sTeacher) {
        if (sID.equals("")) {
            JOptionPane.showMessageDialog(null, "输入考试编号为空！");
            return false;
        } else if (sTeacher.equals("")) {
            JOptionPane.showMessageDialog(null, "输入监考教师学号为空！");
            return false;
        } else {
            return true;
        }
    }

    boolean fieldIsEmpty(String sID) {
        if (sID.equals("")) {
            JOptionPane.showMessageDialog(null, "输入考试编号为空！");
            return false;
        } else {
            return true;
        }
    }

    boolean timeIsConflict(String sID, String sTeacher) {
        int flag = this.function.checkCourse(sID, sTeacher);
        if (flag == -1) {
            JOptionPane.showMessageDialog(null, "监考时间冲突！");
            return true;
        } else {
            return false;
        }
    }

    boolean applyIsNull(String sTeacher) {
        if (this.function.checkApply(sTeacher) == -1) {
            JOptionPane.showMessageDialog(null, "该教师未申请监考替换！");
            return true;
        } else {
            return false;
        }
    }

    public void actionPerformed(ActionEvent e) {
    }
}