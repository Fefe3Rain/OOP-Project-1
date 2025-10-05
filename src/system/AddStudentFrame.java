package system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddStudentFrame extends JFrame implements ActionListener {

    private JTextField IDfield, namefield, cysfield;
    private JTextField[] prelimFields;
    private JTextField[] midtermFields;
    private JTextField[] finalFields;

    private JButton SaveBut;
    private MyFrame parentFrame;

    Font labelFont = new Font("Segoe UI", Font.BOLD, 26);
    Font fieldFont = new Font("Segoe UI", Font.PLAIN, 20);

    private String[] subjects = {"Science", "Math", "Language", "History", "Arts", "P.E.", "Music", "Values"};

    public AddStudentFrame(MyFrame parent) {
        this.parentFrame = parent;
        ImageIcon icon = new ImageIcon("C:\\Users\\Rain Sidney\\OneDrive\\Documents\\BSIT College Files\\2nd Year 1st Sem\\OOP\\Project 1\\src\\system\\Images\\Student Record Logo.png");
        this.setIconImage(icon.getImage());

        this.setTitle("SturSync Add Student Page");
        this.setSize(1920, 1080);
        this.setResizable(true);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(0xF5FFFA));
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

        JLabel AddHeader = new JLabel();
        AddHeader.setText("Add Student");
        AddHeader.setFont(new Font("Sogoe UI", Font.BOLD, 60));
        AddHeader.setBounds(100, 120, 400, 60);
        this.add(AddHeader);

        JPanel Line = new JPanel();
        Line.setBackground(new Color(0x192586));
        Line.setBounds(100, 200, 1300, 3);
        this.add(Line);

        JLabel IDno = new JLabel();
        IDno.setText("ID Number: ");
        IDno.setFont(new Font("Sogoe UI", Font.PLAIN, 28));
        IDno.setBounds(100, 240, 200, 35);
        this.add(IDno);

        IDfield = new JTextField();
        IDfield.setBounds(255, 243, 120, 35);
        IDfield.setFont(new Font("Sogoe UI", Font.PLAIN, 16));
        this.add(IDfield);

        JLabel Name = new JLabel();
        Name.setText("Full Name: ");
        Name.setFont(new Font("Sogoe UI", Font.PLAIN, 28));
        Name.setBounds(400, 240, 200, 35);
        this.add(Name);

        namefield = new JTextField();
        namefield.setBounds(540, 243, 400, 35);
        namefield.setFont(new Font("Sogoe UI", Font.PLAIN, 20));
        this.add(namefield);

        JLabel CrsYrSec = new JLabel();
        CrsYrSec.setText("Course, Year, & Section: ");
        CrsYrSec.setFont(new Font("Sogoe UI", Font.PLAIN, 26));
        CrsYrSec.setBounds(960, 240, 300, 35);
        this.add(CrsYrSec);

        cysfield = new JTextField();
        cysfield.setBounds(1250, 243, 150, 35);
        cysfield.setFont(new Font("Sogoe UI", Font.PLAIN, 20));
        this.add(cysfield);

        JLabel subjHeader = new JLabel("Subject");
        subjHeader.setFont(labelFont);
        subjHeader.setBounds(100, 320, 200, 40);
        this.add(subjHeader);

        JLabel preHeader = new JLabel("Prelim");
        preHeader.setFont(labelFont);
        preHeader.setBounds(420, 320, 120, 40);
        this.add(preHeader);

        JLabel midHeader = new JLabel("Midterm");
        midHeader.setFont(labelFont);
        midHeader.setBounds(620, 320, 120, 40);
        this.add(midHeader);

        JLabel finHeader = new JLabel("Final");
        finHeader.setFont(labelFont);
        finHeader.setBounds(840, 320, 120, 40);
        this.add(finHeader);

        prelimFields = new JTextField[subjects.length];
        midtermFields = new JTextField[subjects.length];
        finalFields = new JTextField[subjects.length];

        Font subjFont = new Font("Segoe UI", Font.PLAIN, 24);
        int startY = 370;
        int gap = 50;

        for (int i = 0; i < subjects.length; i++) {
            int y = startY + (i * gap);

            JLabel subj = new JLabel(subjects[i]);
            subj.setFont(subjFont);
            subj.setBounds(100, y, 200, 35);
            this.add(subj);

            prelimFields[i] = new JTextField();
            prelimFields[i].setBounds(400, y, 120, 35);
            prelimFields[i].setFont(fieldFont);
            this.add(prelimFields[i]);

            midtermFields[i] = new JTextField();
            midtermFields[i].setBounds(600, y, 120, 35);
            midtermFields[i].setFont(fieldFont);
            this.add(midtermFields[i]);

            finalFields[i] = new JTextField();
            finalFields[i].setBounds(820, y, 120, 35);
            finalFields[i].setFont(fieldFont);
            this.add(finalFields[i]);
        }

        SaveBut = new JButton("Save");
        SaveBut.setBackground(new Color(0x27379b));
        SaveBut.setBounds(1250, 700, 150, 50);
        SaveBut.setText("Save");
        SaveBut.setForeground(Color.WHITE);
        SaveBut.setFont(new Font("Sogoe UI", Font.BOLD, 34));
        SaveBut.setFocusable(false);
        SaveBut.addActionListener(this);
        this.add(SaveBut);  

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SaveBut) {
            try {
                String id = IDfield.getText().trim();
                String name = namefield.getText().trim();
                String course = cysfield.getText().trim();

                if (id.isEmpty() || name.isEmpty() || course.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please fill in all student details.", "Missing Info", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                double[] prelims = new double[subjects.length];
                double[] midterms = new double[subjects.length];
                double[] finals = new double[subjects.length];

                for (int i = 0; i < subjects.length; i++) {
                    prelims[i] = Double.parseDouble(prelimFields[i].getText());
                    midterms[i] = Double.parseDouble(midtermFields[i].getText());
                    finals[i] = Double.parseDouble(finalFields[i].getText());
                }

                Student s = new Student(
                        id, name, course,
                        prelims[0], midterms[0], finals[0],
                        prelims[1], midterms[1], finals[1],
                        prelims[2], midterms[2], finals[2],
                        prelims[3], midterms[3], finals[3],
                        prelims[4], midterms[4], finals[4],
                        prelims[5], midterms[5], finals[5],
                        prelims[6], midterms[6], finals[6],
                        prelims[7], midterms[7], finals[7]
                );

                DataHandling.addStudent(s);

                if (parentFrame != null) {
                    parentFrame.refreshTable();
                }

                JOptionPane.showMessageDialog(this, "Student saved successfully!");

                IDfield.setText("");
                namefield.setText("");
                cysfield.setText("");
                for (int i = 0; i < subjects.length; i++) {
                    prelimFields[i].setText("");
                    midtermFields[i].setText("");
                    finalFields[i].setText("");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numeric grades.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
    }
}
