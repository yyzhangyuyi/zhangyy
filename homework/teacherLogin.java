package examManage;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class teacherLogin extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    JFrame frame = new JFrame();
    JPanel panel_1 = new JPanel();
    JPanel panel_2 = new JPanel();
    JLabel label_1 = new JLabel("请选择您要使用的功能：");
    JButton button_1 = new JButton("考试、监考总安排查看");
    JButton button_2 = new JButton("监考替换申请");
    JButton button_3 = new JButton("返回");

    public teacherLogin() {
        this.frame.setLayout(new GridLayout(2, 1));
        this.panel_1.add(this.label_1);
        this.panel_2.add(this.button_1);
        this.panel_2.add(this.button_2);
        this.panel_2.add(this.button_3);
        this.frame.add(this.panel_1, "Center");
        this.frame.add(this.panel_2, "South");
        this.frame.setTitle("教师界面");
        this.frame.setSize(800, 300);
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
        this.button_1.addActionListener(e -> new showCourse());
        this.button_2.addActionListener(e -> {
            teacherLogin.this.frame.setVisible(false);
            new addApply();
        });
        this.button_3.addActionListener(e -> {
            teacherLogin.this.frame.setVisible(false);
            new userLogin();
        });
    }

    public void actionPerformed(ActionEvent e) {
    }
}
