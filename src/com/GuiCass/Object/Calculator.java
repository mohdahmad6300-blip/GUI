package com.GuiCass.Object;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Calculator implements ActionListener
{
    private Frame frame;
    private Button add, sub,mul,div, clr;
    private Label l1, l2, l3;
    private TextField t1, t2, t3;

    public Calculator()
    {
        frame = new Frame("Calculator");
        add = new Button("+");
        sub = new Button("-");
        mul = new Button("X");
        div = new Button("/");
        clr = new Button("Clear");

        l1 = new Label("Enter First Number");
        l2 = new Label("Enter Second Number");
        l3 = new Label("Result");

        t1 = new TextField();
        t2 = new TextField();
        t3 = new TextField();
    }

    public void action()
    {
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setTitle("Calculator");
        frame.setBounds(100, 100, 400, 500);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
                System.exit(0);
            }
        });

        add.setBounds(30, 235, 50, 40);
        sub.setBounds(85, 235, 50, 40);
        mul.setBounds(30, 275, 50, 40);
        div.setBounds(85, 275, 50, 40);
        clr.setBounds(140, 235, 50, 40);
        l1.setBounds(30, 100, 150, 40);
        l2.setBounds(30, 145, 150, 40);
        l3.setBounds(30, 190, 150, 40);
        t1.setBounds(180, 100, 100, 40);
        t2.setBounds(180, 145, 100, 40);
        t3.setBounds(180, 190, 100, 40);
        frame.add(add);
        frame.add(sub);
        frame.add(mul);
        frame.add(div);
        frame.add(clr);
        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(t1);
        frame.add(t2);
        frame.add(t3);
        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        clr.addActionListener(this);

        frame.setBackground(Color.BLACK);
        add.setBackground(Color.BLUE);
        sub.setBackground(Color.YELLOW);
        mul.setBackground(Color.GREEN);
        clr.setBackground(Color.RED);
        div.setBackground(Color.ORANGE);

    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == add)
        {
            String num1 = t1.getText();
            String num2 = t2.getText();
            if (!num1.equals("") && !num2.equals(""))
            {
                int n1 = Integer.parseInt(num1);
                int n2= Integer.parseInt(num2);
                int sum = n1+n2;
                t3.setText(sum+"");
            }
            else
            {
                System.out.println("Please enter a number");
                t3.setText("");
            }
        }
        else if(e.getSource() == sub)
        {
            String num1 = t1.getText();
            String num2 = t2.getText();
            if (!num1.equals("") && !num2.equals(""))
            {
                int n1 = Integer.parseInt(num1);
                int n2= Integer.parseInt(num2);
                int sub = n1-n2;
                t3.setText(sub+"");
            }
            else
            {
                System.out.println("Please enter a number");
                t3.setText("");
            }
        }
        else if (e.getSource()==mul)
        {
            String num1 = t1.getText();
            String num2 = t2.getText();
            if (!num1.equals("") && !num2.equals(""))
            {
                int n1 = Integer.parseInt(num1);
                int n2= Integer.parseInt(num2);
                int mul = n1*n2;
                t3.setText(mul+"");
            }
            else
            {
                System.out.println("Please enter a number");
                t3.setText("null");
            }
        } else if (e.getSource()==div)
        {
            String num1 = t1.getText();
            String num2 = t2.getText();
            if (!num1.equals("") && !num2.equals(""))
            {
                int n1 = Integer.parseInt(num1);
                int n2= Integer.parseInt(num2);
                int div = n1/n2;
                t3.setText(div+"");
            }
            else
            {
                System.out.println("Please enter a number");
                t3.setText("null");
            }
        }
        else if (e.getSource()==clr)
        {
            t1.setText("");
            t2.setText("");
            t3.setText("");
        }
    }
}


