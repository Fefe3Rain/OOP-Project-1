package system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.DefaultTableCellRenderer;
import java.util.ArrayList;

public class MyFrame extends JFrame implements ActionListener{

    private JTable table;
    private DefaultTableModel model;
    JButton Add_But;
    private JLabel enrolledCountLabel;
    private JLabel passedCountLabel;
    private JLabel failedCountLabel;

    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
            setText("Delete");
            setFont(new Font("Arial", Font.BOLD, 14));
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return this;
        }
    }

    class ButtonEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
        private JButton button;
        private JTable table;
        private int row;
        private Student studentToDelete;

        public ButtonEditor(JTable table) {
            this.table = table;
            button = new JButton("Delete");
            button.setOpaque(true);
            button.setFont(new Font("Arial", Font.BOLD, 14));
            button.addActionListener(this);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            this.row = row;
            String studentId = (String) table.getModel().getValueAt(row, 0);
            studentToDelete = DataHandling.getStudentById(studentId);
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            return "Delete";
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (studentToDelete != null) {
                int dialogResult = JOptionPane.showConfirmDialog(table, 
                    "Are you sure you want to delete the record for " + studentToDelete.getName() + "?",
                    "Confirm Deletion", JOptionPane.YES_NO_OPTION);
                
                if (dialogResult == JOptionPane.YES_OPTION) {
                    DataHandling.removeStudent(studentToDelete);
                    fireEditingStopped(); 
                    ((MyFrame) SwingUtilities.getWindowAncestor(table)).refreshTable();
                } else {
                    fireEditingStopped(); 
                }
            }
        }
    }

    class RemarkRenderer extends DefaultTableCellRenderer {
        
        private static final Color PASS_COLOR = new Color(144, 238, 144);
        private static final Color FAIL_COLOR = new Color(255, 102, 102);
        
        @Override
        public java.awt.Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            
            java.awt.Component c = super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);

            setHorizontalAlignment(CENTER);

            String remarks = (String) value;

            if (!isSelected) {
                if (remarks != null) {
                    if (remarks.equals("Failed")) {
                        c.setBackground(FAIL_COLOR);
                        c.setForeground(java.awt.Color.BLACK);
                    } else {
                        c.setBackground(PASS_COLOR);
                        c.setForeground(java.awt.Color.BLACK);
                    }
                } else {
                    c.setBackground(table.getBackground());
                    c.setForeground(table.getForeground());
                }
            }
            return c;
        }
    }
    MyFrame(){
        ImageIcon icon = new ImageIcon("C:\\Users\\Rain Sidney\\OneDrive\\Documents\\BSIT College Files\\2nd Year 1st Sem\\OOP\\Project 1\\src\\system\\Images\\Student Record Logo.png");
        this.setIconImage(icon.getImage());

        this.setTitle("SturSync");
        this.setSize(1920, 1080);
        this.setResizable(true);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(0xF5FFFA));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        JPanel Nav_Panel = new JPanel();
        Nav_Panel.setLayout(null);
        Nav_Panel.setBackground(new Color(0x5170ff));
        Nav_Panel.setBounds(0, 0, 1920, 70);

        ImageIcon Logo = new ImageIcon("C:\\Users\\Rain Sidney\\OneDrive\\Documents\\BSIT College Files\\2nd Year 1st Sem\\OOP\\Project 1\\src\\system\\Images\\Student Record Logo Revert.png");
        Image scaledLogo = Logo.getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaledLogo);

        JLabel LogoName = new JLabel();
        LogoName.setText("SturSync");
        LogoName.setForeground(Color.WHITE);
        LogoName.setFont(new Font("Sogoe UI", Font.BOLD, 40));
        LogoName.setIcon(resizedIcon);
        LogoName.setBounds(30, 5, 400, 60);

        ImageIcon Profile = new ImageIcon("C:\\Users\\Rain Sidney\\OneDrive\\Documents\\BSIT College Files\\2nd Year 1st Sem\\OOP\\Project 1\\src\\system\\Images\\New Formal Picture.png");
        Image scaledProfile = Profile.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon resizedProfile = new ImageIcon(scaledProfile);
        JLabel ProfilePic = new JLabel();
        ProfilePic.setIcon(resizedProfile);
        ProfilePic.setBounds(1340, 10, 50, 50);

        JLabel ProfileName = new JLabel();
        ProfileName.setText("Rain Sidney");
        ProfileName.setForeground(Color.WHITE);
        ProfileName.setFont(new Font("Sogoe UI", Font.PLAIN, 18));
        ProfileName.setBounds(1400, 15, 400, 20);

        ImageIcon Online = new ImageIcon("C:\\Users\\Rain Sidney\\OneDrive\\Documents\\BSIT College Files\\2nd Year 1st Sem\\OOP\\Project 1\\src\\system\\Images\\Online.png");
        Image Active = Online.getImage().getScaledInstance(13, 13, Image.SCALE_SMOOTH);
        ImageIcon OnActive = new ImageIcon(Active);
        JLabel OnStat = new JLabel();
        OnStat.setIcon(OnActive);
        OnStat.setBounds(1400, 37, 13, 13);

        JLabel Status = new JLabel();
        Status.setText("Online");
        Status.setForeground(Color.WHITE);
        Status.setFont(new Font("Sogoe UI", Font.PLAIN, 12));
        Status.setBounds(1415, 37, 100, 12);

        Nav_Panel.add(ProfilePic);
        Nav_Panel.add(LogoName);
        Nav_Panel.add(ProfileName);
        Nav_Panel.add(OnStat);
        Nav_Panel.add(Status);
        this.add(Nav_Panel);

        JPanel Menu_Panel = new JPanel();
        Menu_Panel.setBackground(new Color(0xFF3D5AFE));
        Menu_Panel.setBounds(0, 70, 300, 1080);
        Menu_Panel.setLayout(null);

        JButton Add_But = new JButton();
        Add_But.setBackground(new Color(0x27379b));
        Add_But.setBounds(5, 5, 290, 100);
        Add_But.setText("Add Student");
        Add_But.setForeground(Color.WHITE);
        Add_But.setFont(new Font("Sogoe UI", Font.BOLD, 38));
        Add_But.setFocusable(false);
        Add_But.addActionListener(this);
        Menu_Panel.add(Add_But);
        this.add(Menu_Panel);

        JPanel Enrolled_Panel = new JPanel();
        Enrolled_Panel.setBackground(new Color(0x0FF3D5AFE));
        Enrolled_Panel.setBounds(350, 110, 380, 120);
        Enrolled_Panel.setLayout(null);
        this.add(Enrolled_Panel);

        ImageIcon Enrolled = new ImageIcon("C:\\Users\\Rain Sidney\\OneDrive\\Documents\\BSIT College Files\\2nd Year 1st Sem\\OOP\\Project 1\\src\\system\\Images\\5.png");
        Image scaledEnr = Enrolled.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        ImageIcon resizedenr = new ImageIcon(scaledEnr);

        JLabel EnrStu = new JLabel();
        EnrStu.setIcon(resizedenr);
        JLabel EnrStud = new JLabel();
        EnrStud.setText("Total Enrolled Students:");
        EnrStud.setForeground(Color.WHITE);
        EnrStud.setFont(new Font("Sogoe UI", Font.BOLD, 22));
        enrolledCountLabel = new JLabel("0");
        enrolledCountLabel.setForeground(Color.WHITE);
        enrolledCountLabel.setFont(new Font("Sogoe UI", Font.BOLD, 40));
        EnrStu.setBounds(20, 25, 75, 75);
        EnrStud.setBounds(105, 30, 400, 24);
        enrolledCountLabel.setBounds(108, 55, 100, 40);
        Enrolled_Panel.add(EnrStu);
        Enrolled_Panel.add(EnrStud);
        Enrolled_Panel.add(enrolledCountLabel);

        JPanel Passed_Panel = new JPanel();
        Passed_Panel.setBackground(new Color(0x0FF3D5AFE));
        Passed_Panel.setBounds(760, 110, 350, 120);
        Passed_Panel.setLayout(null);
        this.add(Passed_Panel);

        ImageIcon Passed = new ImageIcon("C:\\Users\\Rain Sidney\\OneDrive\\Documents\\BSIT College Files\\2nd Year 1st Sem\\OOP\\Project 1\\src\\system\\Images\\6.png");
        Image scaledpss = Passed.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        ImageIcon resizedpss = new ImageIcon(scaledpss);

        JLabel PssStu = new JLabel();
        PssStu.setIcon(resizedpss);
        JLabel PStud = new JLabel();
        PStud.setText("Total Passed Students:");
        PStud.setForeground(Color.WHITE);
        PStud.setFont(new Font("Sogoe UI", Font.BOLD, 20));
        passedCountLabel = new JLabel("0");
        passedCountLabel.setForeground(Color.WHITE);
        passedCountLabel.setFont(new Font("Sogoe UI", Font.BOLD, 40));
        PssStu.setBounds(20, 25, 75, 75);
        PStud.setBounds(100, 30, 400, 20);
        passedCountLabel.setBounds(108, 55, 100, 40);
        Passed_Panel.add(PssStu);
        Passed_Panel.add(PStud);
        Passed_Panel.add(passedCountLabel);

        JPanel Failed_Panel = new JPanel();
        Failed_Panel.setBackground(new Color(0x0FF3D5AFE));
        Failed_Panel.setBounds(1140, 110, 350, 120);
        Failed_Panel.setLayout(null);
        this.add(Failed_Panel);

        ImageIcon Failed = new ImageIcon("C:\\Users\\Rain Sidney\\OneDrive\\Documents\\BSIT College Files\\2nd Year 1st Sem\\OOP\\Project 1\\src\\system\\Images\\7.png");
        Image scaledfld = Failed.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        ImageIcon resizedfld = new ImageIcon(scaledfld);

        JLabel FldStu = new JLabel();
        FldStu.setIcon(resizedfld);
        JLabel FStud = new JLabel();
        FStud.setText("Total Failed Students:");
        FStud.setForeground(Color.WHITE);
        FStud.setFont(new Font("Sogoe UI", Font.BOLD, 20));
        failedCountLabel = new JLabel("0");
        failedCountLabel.setForeground(Color.WHITE);
        failedCountLabel.setFont(new Font("Sogoe UI", Font.BOLD, 40));
        FldStu.setBounds(20, 25, 75, 75);
        FStud.setBounds(100, 30, 400, 20);
        failedCountLabel.setBounds(108, 55, 100, 40);
        Failed_Panel.add(FldStu);
        Failed_Panel.add(FStud);
        Failed_Panel.add(failedCountLabel);

        JPanel Dis_Board = new JPanel();
        Dis_Board.setBackground(new Color(0xc6cbec));
        Dis_Board.setBounds(350, 260, 1140, 540);
        Dis_Board.setLayout(null);
        this.add(Dis_Board);

        String[] columnNames = {"ID Number", "Name", "Course & Year/Section", "GWA", "Remarks", "Actions"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);

        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(30);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
        table.setBackground(Color.WHITE);
        table.setFillsViewportHeight(true);
        table.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(table));
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setCellRenderer(new RemarkRenderer());

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 20, 1100, 500);
        Dis_Board.add(scrollPane);

        refreshTable();
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand().equals("Add Student")){
            new AddStudentFrame(this);
        }
    }
    public void refreshTable() {
        model.setRowCount(0); 

        ArrayList<Student> students = DataHandling.getAllStudents();
        int enrolledCount = students.size(); 
        int passedCount = 0;
        int failedCount = 0;

        for (Student s : students) {
        String remarks = s.getRemarks();
            if (remarks.equals("Failed")) {
                failedCount++;
            } else {
                passedCount++;
            }
            model.addRow(new Object[]{
                s.getId(),
                s.getName(),
                s.getCourse(),
                String.format("%.2f", s.getGwa()),
                remarks,
                "Delete"
            });
        }
    enrolledCountLabel.setText(String.valueOf(enrolledCount));
    passedCountLabel.setText(String.valueOf(passedCount));
    failedCountLabel.setText(String.valueOf(failedCount));
    }
}