package examManage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class showStudent extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    JTable table;
    DefaultTableModel model;

    public showStudent() {
        JFrame frame = new JFrame("显示所有学生用户（点击表头可切换升降序）");
        JPanel panel = new JPanel();
        Vector<String> columnNames = this.createColumnNames();
        Vector<Vector<String>> data = this.createTableModelData();
        this.model = new DefaultTableModel(data, columnNames);
        this.table = new JTable(this.model);
        this.table.setPreferredScrollableViewportSize(new Dimension(400, 80));
        new JScrollPane(this.table);
        this.table.setForeground(Color.BLACK);
        this.table.setFont(new Font(null, Font.PLAIN, 14));
        this.table.setSelectionForeground(Color.DARK_GRAY);
        this.table.setSelectionBackground(Color.LIGHT_GRAY);
        this.table.setGridColor(Color.GRAY);
        this.table.getTableHeader().setFont(new Font(null, Font.BOLD, 14));
        this.table.getTableHeader().setForeground(Color.RED);
        this.table.getTableHeader().setResizingAllowed(false);
        this.table.getTableHeader().setReorderingAllowed(false);
        this.table.setRowHeight(40);
        this.table.getColumnModel().getColumn(0).setPreferredWidth(40);
        this.table.setPreferredScrollableViewportSize(new Dimension(900, 320));
        RowSorter<DefaultTableModel> sorter = new TableRowSorter<>(this.model);
        this.table.setRowSorter(sorter);
        new JScrollPane(this.table);
        JScrollPane scrollPane = new JScrollPane(this.table);
        panel.add(scrollPane);
        frame.setContentPane(panel);
        frame.pack();
        frame.setSize(900, 600);
        frame.add(scrollPane, "Center");
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(SwingConstants.CENTER);
        this.table.setDefaultRenderer(Object.class, r);
        frame.setLocationRelativeTo(null);
        int t = this.table.getRowCount();
        if (t <= 0) {
            JOptionPane.showMessageDialog(null, "暂无学生信息！！！");
            frame.setVisible(false);
        } else {
            frame.setVisible(true);
        }

    }

    private Vector<Vector<String>> createTableModelData() {
        Vector<Vector<String>> data = new Vector<>();
        String line;

        try {
            FileReader fr = new FileReader("C:\\Users\\admin\\Desktop\\untitled\\src\\student.txt");
            BufferedReader br = new BufferedReader(fr);

            while((line = br.readLine()) != null) {
                String[] s = line.split("\\s+");
                Vector<String> rowData = new Vector<>();
                rowData.add(s[0]);
                rowData.add(s[1]);
                rowData.add(s[2]);
                rowData.add(s[3]);
                rowData.add(s[4]);
                data.add(rowData);
            }

            fr.close();
            br.close();
        } catch (IOException var7) {
            var7.printStackTrace();
        }

        return data;
    }

    private Vector<String> createColumnNames() {
        Vector<String> columnNames = new Vector<>();
        columnNames.add("学号");
        columnNames.add("姓名");
        columnNames.add("性别");
        columnNames.add("年龄");
        columnNames.add("班级");
        return columnNames;
    }

    public void actionPerformed(ActionEvent e) {
    }
}
