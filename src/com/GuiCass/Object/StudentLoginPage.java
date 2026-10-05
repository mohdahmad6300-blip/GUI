package com.GuiCass.Object;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class StudentLoginPage extends JFrame
{
    JLabel image,title,forgot;
    JTextField emailField;
    JPasswordField passwordField;
    JButton login;

    public  StudentLoginPage()
    {
        ImageIcon icon = new ImageIcon(
                getClass().getResource("image.png")
        );
        Image img = icon.getImage();

        Image newImg = img.getScaledInstance(
                350, 233, Image.SCALE_SMOOTH
        );

        image = new JLabel(new ImageIcon(newImg));

        title = new JLabel("Student Login ");

        forgot = new JLabel("Forgot Password?");

        emailField = new JTextField();
        passwordField = new JPasswordField();

        login = new JButton("Login");

        design();
    }

    public void design()
    {
        //Frame
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Student Login");
        setLayout(null);
        setBounds(300,50,500,700);

        //BackGround
        getContentPane().setBackground(new Color(255, 220, 160));

        //Image
        image.setBounds(75, 40, 350, 233);
        add(image);

        //Title
        title.setBounds(75, 280, 300, 35);
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title);

        //Email
        emailField.setBounds(75, 320, 300, 40);
        emailField.setText("Student's email");
        emailField.setFont(new Font("Arial", Font.PLAIN, 16));
        emailField.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        emailField.setHorizontalAlignment(SwingConstants.CENTER);
        add(emailField);

        //Password
        passwordField.setBounds(75, 365, 300, 40);
        passwordField.setText("Password");
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordField.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        passwordField.setHorizontalAlignment(SwingConstants.CENTER);
        passwordField.setEchoChar((char)0);
        add(passwordField);

        //Login Button
        login.setBounds(95, 410, 250, 40);
        login.setFont(new Font("Arial", Font.BOLD, 18));
        login.setHorizontalAlignment(SwingConstants.CENTER);
        login.setBackground(new Color(255, 235, 190));
        login.setFocusPainted(false);
        add(login);

        //Forgot Password
        forgot.setBounds(170, 455, 140, 25);
        add(forgot);

        //Login Action
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                System.out.println("Email: "+email);
                System.out.println("Password: "+password);
            }
        });

        //Email PlaceHolder
        emailField.addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
               if (emailField.getText().equals("Student's email")) {
                   emailField.setText("");
               }
            }


            public void focusLost(FocusEvent e) {
        if (emailField.getText().isEmpty()) {
            emailField.setText("Student's email");
                }
            }
        });

        // Password Placeholder
        passwordField.addFocusListener(new FocusAdapter()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                if(new String(passwordField.getPassword())
                        .equals("Password"))
                {
                    passwordField.setText("");
                    passwordField.setEchoChar('•');
                }
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                if(passwordField.getPassword().length == 0)
                {
                    passwordField.setEchoChar((char) 0);
                    passwordField.setText("Password");
                }
            }
        });



    }
}
