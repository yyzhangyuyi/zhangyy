package examManage;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class managerLogin extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    JFrame frame = new JFrame();
    JPanel panel_1 = new JPanel();
    JPanel panel_2 = new JPanel();
    JPanel panel_3 = new JPanel();
    JPanel panel_4 = new JPanel();
    JPanel panel_5 = new JPanel();
    JLabel label_1 = new JLabel("请选择您要使用的功能：");
    JLabel label_2 = new JLabel("（增加删除修改用户）");
    JLabel label_3 = new JLabel("（增加删除修改考试，安排考试时间）");
    JLabel label_4 = new JLabel("（安排、修改监考）");
    JButton button_1 = new JButton("用户管理");
    JButton button_2 = new JButton("考试管理");
    JButton button_3 = new JButton("监考管理");
    JButton button_4 = new JButton("返回");

    public managerLogin() {
        this.frame.setLayout(new GridLayout(5, 1));
        this.panel_1.add(this.label_1);
        this.panel_2.add(this.button_1);
        this.panel_2.add(this.label_2);
        this.panel_3.add(this.button_2);
        this.panel_3.add(this.label_3);
        this.panel_4.add(this.button_3);
        this.panel_4.add(this.label_4);
        this.panel_5.add(this.button_4);
        this.frame.add(this.panel_1);
        this.frame.add(this.panel_2);
        this.frame.add(this.panel_3);
        this.frame.add(this.panel_4);
        this.frame.add(this.panel_5);
        this.frame.setTitle("教务员界面");
        this.frame.setSize(800, 600);
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
        this.button_1.addActionListener(e -> {
            managerLogin.this.frame.setVisible(false);
            new userManage();
        });
        this.button_2.addActionListener(e -> {
            managerLogin.this.frame.setVisible(false);
            new courseManage();
        });
        this.button_3.addActionListener(e -> {
            managerLogin.this.frame.setVisible(false);
            new invigilateManage();
        });
        this.button_4.addActionListener(e -> {
            managerLogin.this.frame.setVisible(false);
            new userLogin();
        });
    }

    public void actionPerformed(ActionEvent e) {
    }
}