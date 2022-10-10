package examManage;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class userLogin extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    JFrame frame = new JFrame();
    JPanel panel_1 = new JPanel();
    JPanel panel_2 = new JPanel();
    JLabel label_1 = new JLabel("请选择您的身份：");
    JButton button_1 = new JButton("教务员");
    JButton button_2 = new JButton("教师");
    JButton button_3 = new JButton("学生");

    public userLogin() {
        this.frame.setLayout(new GridLayout(3, 1));
        this.panel_1.add(this.label_1);
        this.panel_2.add(this.button_1);
        this.panel_2.add(this.button_2);
        this.panel_2.add(this.button_3);
        this.frame.add(this.panel_1, "Center");
        this.frame.add(this.panel_2, "South");
        this.frame.setTitle("用户登录");
        this.frame.setSize(800, 300);
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
        this.button_1.addActionListener(e -> {
            userLogin.this.frame.setVisible(false);
            new managerLogin();
        });
        this.button_2.addActionListener(e -> {
            userLogin.this.frame.setVisible(false);
            new teacherLogin();
        });
        this.button_3.addActionListener(e -> {
            userLogin.this.frame.setVisible(false);
            new studentLogin();
        });
    }

    public void actionPerformed(ActionEvent e) {
    }
}