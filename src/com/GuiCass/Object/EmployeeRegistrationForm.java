package com.GuiCass.Object;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EmployeeRegistrationForm extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JTextField t1,t2,t3,t4;
    JRadioButton r1,r2,r3;
    ButtonGroup bg;
    JTextArea ta,ta2,ta3;
    JComboBox day,month,year,edu,grad,country;
    JCheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8;
    JButton b1,b2;


    public EmployeeRegistrationForm()
    {
        //Buttons
        b1=new JButton("Submit");
        b2=new JButton("Refresh");

        //Labels
        l1=new JLabel("Employee Registration Form");
        l2=new JLabel("Employee ID:");
        l3=new JLabel("Name:");
        l4=new JLabel("Gender:");
        l5=new JLabel("Date Of Birth:");
        l6=new JLabel("Education:");
        l7=new JLabel("Graduation/PostGraduation (*if do):");
        l8=new JLabel("Experience:");
        l9=new JLabel("Languages Known:");
        l10=new JLabel("Country:");
        l11=new JLabel("Address:");
        l12=new JLabel("--Employee Details--");

        //TextFields
        t1=new JTextField();
        t2=new JTextField("First Name");
        t3=new JTextField("Middle Name");
        t4=new JTextField("Last Name");

        //Radio
        r1=new JRadioButton("Male");
        r2=new JRadioButton("Female");
        r3=new JRadioButton("Other");
        bg=new ButtonGroup();

        //ComboBox
        day = new JComboBox<>();
        month = new JComboBox<>();
        year = new JComboBox<>();
        edu = new JComboBox<>();
        grad = new JComboBox<>();
        country = new JComboBox<>();

        //For DOB
        for(int i = 1; i <= 31; i++)
        {
            day.addItem(String.valueOf(i));
        }

        for(int i = 1; i <= 12; i++)
        {
            month.addItem(String.valueOf(i));
        }

        for(int i = 1980; i <= 2026; i++)
        {
            year.addItem(String.valueOf(i));
        }

        //For Education
        String[] educations = {"Select","10th","12th","Graduation","Postgraduation"};
        for(int i = 0; i < educations.length; i++)
        {
            edu.addItem(educations[i]);
        }

        //For Graduation
        String[] graduation = {"Select","BCA","MCA","B-TECH","M-TECH","BSC-CS","MSC-CS","OTHER"};
        for(int i = 0; i < graduation.length; i++)
        {
            grad.addItem(graduation[i]);
        }

        //For Country
        String[] cntry = {"Select","India","Pakistan","China","Korea","Dubai","Other"};
        for(int i = 0; i < cntry.length; i++)
        {
            country.addItem(cntry[i]);
        }

        //Text Area
        ta = new JTextArea("Define your Experience in 100 words.");
        ta2 = new JTextArea("Area :\nDistrict :\nState :\nPincode :");
        ta3 = new JTextArea();


        //CheckBox
        cb1 = new JCheckBox("C");
        cb2 = new JCheckBox("C++");
        cb3 = new JCheckBox("Java");
        cb4 = new JCheckBox("Python");
        cb5 = new JCheckBox("C#");
        cb6 = new JCheckBox("JavaScript");
        cb7 = new JCheckBox("**I hereby declare that all the information provided by me in this form is true, complete, and correct to the best of my knowledge and belief.**\n");
        cb8 = new JCheckBox("Accept all terms & conditions.");
        design();
    }

    public void design()
    {
        //Frame
        setTitle("Employee Registration Form");
        setVisible(true);
        setLayout(null);
        setBounds(300,300,400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Heading
        l1.setFont(new Font("Times New Roman",Font.BOLD,20));
       l1.setSize(400,40);
       l1.setHorizontalAlignment(JLabel.CENTER);
       add(l1);

       //ID :
        l2.setBounds(20,40,200,40);
        add(l2);
        t1.setBounds(110,45,200,35);
        add(t1);

        //Name
        l3.setBounds(20,85,100,35);
        add(l3);
        t2.setBounds(110,85,100,35);
        add(t2);
        t3.setBounds(215,85,100,35);
        add(t3);
        t4.setBounds(320,85,100,35);
        add(t4);

        //Gender
        l4.setBounds(20,120,100,35);
        add(l4);
        r1.setBounds(125,120,100,35);
        add(r1);
        r2.setBounds(230,120,100,35);
        add(r2);
        r3.setBounds(335,120,100,35);
        add(r3);
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);

        //DateOfBirth
        l5.setBounds(20,160,100,35);
        add(l5);
        day.setBounds(110,160,100,35);
        add(day);
        month.setBounds(220,160,100,35);
        add(month);
        year.setBounds(330,160,100,35);
        add(year);

        //Education
        l6.setBounds(20,205,100,35);
        add(l6);
        edu.setBounds(120,205,100,35);
        add(edu);

        //Graduation
        l7.setBounds(20,245,200,35);
        add(l7);
        grad.setBounds(225,245,100,35);
        add(grad);

        //Experience
        l8.setBounds(20,285,100,35);
        add(l8);
        ta.setBounds(115,285,400,100);
        add(ta);

        //Languages
        l9.setBounds(20,390,150,35);
        add(l9);
        cb1.setBounds(170,390,100,35);
        cb2.setBounds(270,390,100,35);
        cb3.setBounds(370,390,100,35);
        cb4.setBounds(470,390,100,35);
        cb5.setBounds(570,390,100,35);
        cb6.setBounds(670,390,100,35);
        add(cb1);
        add(cb2);
        add(cb3);
        add(cb4);
        add(cb5);
        add(cb6);

        //Country
        l10.setBounds(20,430,100,35);
        add(l10);
        country.setBounds(120,430,100,35);
        add(country);

        //Address.
        l11.setBounds(20,470,100,35);
        add(l11);
        ta2.setBounds(120,470,400,100);
        add(ta2);

        //Last Confirmations.
        cb7.setBounds(20,575,800,35);
        cb8.setBounds(20,615,200,35);
        add(cb7);
        add(cb8);

        //Submit and Refresh Buttons
        b1.setBounds(50,655,100,35);
        b2.setBounds(150,655,100,35);
        add(b1);
        add(b2);

        //Final Details.
        l12.setBounds(1120,20,300,35);
        l12.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(l12);
        ta3.setBounds(900,50,600,700);
        ta3.setFont(new Font("Times New Roman",Font.BOLD,20));
        add(ta3);

        b1.addActionListener(e -> {
            String id = t1.getText();
            String firstName = t2.getText();
            String middleName = t3.getText();
            String lastName = t4.getText();
            String exp = ta.getText();
            String address = ta2.getText();

            String gender = "";
            if(r1.isSelected()){
                gender = "Male";
            }
            else if(r2.isSelected()){
                gender = "Female";
            }
            else if(r3.isSelected()){
                gender = "Other";
            }

            String dob = (String) day.getSelectedItem()+"/"+month.getSelectedItem()+"/"+year.getSelectedItem();

            String education = (String) edu.getSelectedItem();

            String graduation = (String) grad.getSelectedItem();



            String languages = "";

            if(cb1.isSelected()){
                languages = languages+"C ";
            }
            if(cb2.isSelected()){
                languages = languages+"C++ ";
            }
            if(cb3.isSelected()){
                languages = languages+"Java ";
            }
            if(cb4.isSelected()){
                languages = languages+"Python ";
            }
            if(cb5.isSelected()){
                languages = languages+"C# ";
            }
            if(cb6.isSelected()){
                languages = languages+"JavaScript ";
            }

            String sCountry = (String) country.getSelectedItem();

            if(id.isEmpty()||firstName.isEmpty()||lastName.isEmpty()||exp.isEmpty()||address.isEmpty()
                    ||gender.isEmpty()||dob.isEmpty()||education.equals("Select")||graduation.equals("Select")||
                    sCountry.equals("Select")||languages.equals("")||!cb7.isSelected()||!cb8.isSelected())
            {
                
                JOptionPane.showMessageDialog(this,"Please fill all the fields","Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Registered Successfully.","Notice",
                        JOptionPane.INFORMATION_MESSAGE);
                ta3.setText(
                        "========== EMPLOYEE DETAILS ==========\n\n" +
                                "Employee ID     : " + id + "\n" +
                                "Name            : " + firstName + " " +middleName + " " +lastName + "\n" +
                                "Gender          : " + gender + "\n" +
                                "Dete of Birth   : " + dob + "\n" +
                                "Education       : " + education + "\n" +
                                "Graduation      : " + graduation + "\n" +
                                "Experience      : " + exp + "\n" +
                                "Languages Known : " + languages + "\n" +
                                "Country         : " + sCountry + "\n"+
                                "Address         : " +address + "\n"+
                                "Declaration     : Accepted " + "\n"+
                                "Terms and Condition : Accepted"+"\n"+
                        "============================================"
                );
            }
        });

        b2.addActionListener(e -> {
           t1.setText("");
           t2.setText("");
           t3.setText("");
           t4.setText("");
           r1.setSelected(false);
           r2.setSelected(false);
           r3.setSelected(false);
           day.setSelectedIndex(0);
           month.setSelectedIndex(0);
           year.setSelectedIndex(0);
           edu.setSelectedIndex(0);
           ta.setText("Define your Experience in 100 words.");
           cb1.setSelected(false);
           cb2.setSelected(false);
           cb3.setSelected(false);
           cb4.setSelected(false);
           cb5.setSelected(false);
           cb6.setSelected(false);
           country.setSelectedIndex(0);
           ta2.setText("Area :\nDistrict :\nState :\nPincode :");
           cb8.setSelected(false);
           cb7.setSelected(false);
           ta3.setText("");
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {}
}