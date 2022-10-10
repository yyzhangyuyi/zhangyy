
package examManage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    JFrame frame = new JFrame();
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JLabel label = new JLabel("欢迎使用考试信息管理系统！");
    JButton button;

    public Login() {
        this.p2.add(this.label, 0);
        Font font=new Font("宋体",Font.PLAIN,20);
        label.setFont(font);
        this.button = new JButton("进入系统");
        this.p3.add(this.button);
        this.frame.add(this.p1, "North");
        this.frame.add(this.p2, "Center");
        this.frame.add(this.p3, "South");
        this.frame.setTitle("考试信息管理系统");
        this.frame.setSize(800, 200);
        this.frame.setLocationRelativeTo(null);//窗口居中
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
        this.button.addActionListener(e -> {
            Login.this.frame.setVisible(false);
            new userLogin();
        });
    }

    public void actionPerformed(ActionEvent e) {
    }
}