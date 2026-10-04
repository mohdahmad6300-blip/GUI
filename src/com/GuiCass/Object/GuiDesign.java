package com.GuiCass.Object;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
class GuiDesign implements ActionListener
{

    private JFrame frm;
    private JButton bt1;

    public GuiDesign()
    {
        frm = new JFrame("Swing Example");
        bt1 = new JButton("Click me");
        gui();
    }

    public void gui()
    {
        frm.setVisible(true);
        frm.setLayout(null);
        frm.setBounds(10,20,500,400);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        bt1.setBounds(30,40,100,50);
        bt1.addActionListener(this);
        frm.add(bt1);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        JOptionPane.showMessageDialog(frm,"It clicked","Info Message",JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args)
    {
        new GuiDesign();
    }}
