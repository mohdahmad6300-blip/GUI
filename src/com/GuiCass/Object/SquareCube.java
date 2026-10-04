package com.GuiCass.Object;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SquareCube implements ActionListener
{
    private Frame frame;
    private Button btn,btn2,clr;
    private Label l1,l2;
    private TextField t1,t2;

    public SquareCube() {
        frame = new Frame("Square Cube");
        btn = new Button("Square");
        btn2 = new  Button("Cube");
        clr = new Button("Clear");
        l1 = new Label("Enter Number :");
        l2 = new Label("    Result   :");
        t1 = new TextField();
        t2 = new TextField();
    }

    public void action()
    {
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setBounds(100, 100, 300, 350);
        frame.setBackground(Color.DARK_GRAY);
        frame.addWindowListener(new  WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
                System.exit(0);
            }
        });

        l1.setBounds(30, 100, 100, 40);
        l1.setBackground(Color.RED);
        l2.setBounds(30, 145, 100, 40);
        l2.setBackground(Color.RED);

        t1.setBounds(30+100, 100, 100, 40);
        t2.setBounds(30+100, 145, 100, 40);

        btn.setBounds(60, 190, 60, 40);
        btn.setBackground(Color.YELLOW);
        btn2.setBounds(120, 190, 60, 40);
        btn2.setBackground(Color.YELLOW);
        clr.setBounds(60, 235, 60, 40);
        clr.setBackground(Color.YELLOW);

        frame.add(l1);
        frame.add(l2);
        frame.add(t1);
        frame.add(t2);
        frame.add(btn);
        frame.add(btn2);
        frame.add(clr);

        btn.addActionListener(this);
        btn2.addActionListener(this);
        clr.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == btn)
        {
            String n = t1.getText();
            int num = Integer.parseInt(n);

            int square = num*num;
            t2.setText(Integer.toString(square));
        }
        if (e.getSource() == btn2)
        {
            String n = t1.getText();
            int num = Integer.parseInt(n);

            int cube = num*num*num;
            t2.setText(Integer.toString(cube));
        }
        if (e.getSource() == clr)
        {
            t1.setText("");
            t2.setText("");
        }
    }
}
