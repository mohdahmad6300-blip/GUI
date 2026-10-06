package com.GuiCass.Object;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

public class Notepad extends JFrame
{
    JTextArea text;
    JScrollPane scroll;

    JMenuBar menuBar;

    JMenu fileMenu;
    JMenu editMenu;
    JMenu formatMenu;
    JMenu helpMenu;

    JMenuItem newItem;
    JMenuItem openItem;
    JMenuItem saveItem;
    JMenuItem saveAsItem;
    JMenuItem exitItem;

    JMenuItem undoItem;
    JMenuItem redoItem;
    JMenuItem cutItem;
    JMenuItem copyItem;
    JMenuItem pasteItem;
    JMenuItem selectAllItem;

    JMenuItem fontItem;
    JMenuItem boldItem;
    JMenuItem italicItem;

    JMenuItem wordWrapItem;
    JMenuItem aboutItem;

    UndoManager undoManager;
    File currentFile;


    public  Notepad()
    {
        //textarea
        text=new JTextArea();

        //Scrollpane
        scroll=new JScrollPane(text);

        //Menu Bar
        menuBar=new JMenuBar();

        // menus
        fileMenu=new JMenu("File");
        editMenu=new JMenu("Edit");
        formatMenu=new JMenu("Format");
        helpMenu=new JMenu("Help");

        //file menu items
        newItem=new JMenuItem("New");
        openItem=new JMenuItem("Open");
        saveItem=new JMenuItem("Save");
        saveAsItem=new JMenuItem("Save As...");
        exitItem=new JMenuItem("Exit");

        //Edit menu items
        undoItem=new JMenuItem("Undo");
        redoItem=new JMenuItem("Redo");
        cutItem=new JMenuItem("Cut");
        copyItem=new JMenuItem("Copy");
        pasteItem=new JMenuItem("Paste");
        selectAllItem=new JMenuItem("Select All");

        //View
        fontItem=new JMenuItem("Font");
        boldItem=new JMenuItem("Bold");
        italicItem=new JMenuItem("Italic");
        wordWrapItem=new JMenuItem("Word Wrap");

        //Help
        aboutItem=new JMenuItem("About");

        //Undo Manager
        undoManager=new UndoManager();

        design();
    }

    public void design()
    {
        //Frame
        setLayout(null);
        setBounds(200,100,800,600);
        setTitle("My Notepad");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Text Area
        scroll.setBounds(0,0,800,550);
        text.setFont(new Font("Arial",Font.PLAIN,16));
        text.setLineWrap(false);
        text.setWrapStyleWord(true);
        add(scroll);

        // File Menu
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        //Edit Menu
        editMenu.add(undoItem);
        editMenu.add(redoItem);
        editMenu.addSeparator();
        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);
        editMenu.addSeparator();
        editMenu.add(selectAllItem);

        //Format menu
        formatMenu.add(fontItem);
        formatMenu.add(boldItem);
        formatMenu.add(italicItem);
        formatMenu.addSeparator();
        formatMenu.add(wordWrapItem);

        //Help menu
        helpMenu.add(aboutItem);

        //Add all menus to menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(formatMenu);
        menuBar.add(helpMenu);

        //set the menu bar
        setJMenuBar(menuBar);


        //KeyBoard ShortCuts
        newItem.setAccelerator( KeyStroke.getKeyStroke(
                KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK
        ) );

        openItem.setAccelerator( KeyStroke.getKeyStroke(
                KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK
        ));

        saveItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK
        ));

        saveAsItem.setAccelerator( KeyStroke.getKeyStroke(
                KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK
        ));

        cutItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK
        ));

        copyItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK
        ));

        pasteItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK
        ));

        selectAllItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK
        ));

        //UNDO
        text.getDocument().addUndoableEditListener(
                new UndoableEditListener() {
                    @Override
                    public void undoableEditHappened(UndoableEditEvent e) {
                        undoManager.addEdit(e.getEdit());
                    }
                }
        );

        undoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (undoManager.canUndo()) {
                    undoManager.undo();
                }
            }
        });

        //REDO
        redoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (undoManager.canRedo()) {
                    undoManager.redo();
                }
            }
        });

        //New Action
        newItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newFile();
            }
        });

        //Open File
        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });

        //Save File
        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFile();
            }

        });

        //saveAsFile
        saveAsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAsFile();
            }
        });

        //Cut
        cutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.cut();
            }
        });

        //copy
        copyItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.copy();
            }
        });

        //Paste
        pasteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.paste();
            }
        });

        //Select all
        selectAllItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.selectAll();
            }
        });

        //Font
        fontItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseFont();
            }
        });

        //Bold
        boldItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Font oldFont = text.getFont();
                if(oldFont.isBold()) {
                    text.setFont(oldFont.deriveFont(Font.PLAIN));
                }
                else
                {
                    text.setFont(oldFont.deriveFont(Font.BOLD));
                }
            }
        });

        //Italic
        italicItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Font oldFont = text.getFont();
                if(oldFont.isItalic()) {
                    text.setFont(oldFont.deriveFont(Font.PLAIN));
                }
                else
                {
                    text.setFont(oldFont.deriveFont(Font.ITALIC));
                }
            }
        });

        //Word Wrap
        wordWrapItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean current = text.getLineWrap();
                text.setLineWrap(!current);
            }
        });

        //About
        aboutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                     JOptionPane.showMessageDialog(Notepad.this,"My Notepad\n" +
                             "A simple and user-friendly text editor developed using Java Swing.\n" +
                             "\n" +
                             "This application provides essential text-editing features such as creating, opening, saving, and editing text files. It also supports Undo, Redo, Cut, Copy, Paste, Select All, Font Selection, Bold, Italic, and Word Wrap.\n" +
                             "\n" +
                             "Developed using: Java & Java Swing\n" +
                             "Version: 1.0\n" +
                             "Developer: Mohammad Ahmad Khan","About",JOptionPane.INFORMATION_MESSAGE);
            }
        });


        //exit action
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitApplication();
            }
        });


        setVisible(true);
    }

   //New File Method
    public void newFile() {
        text.setText("");
        currentFile = null;
        setTitle("My Notepad");
    }
    //Open File Method
    public void openFile() {
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            currentFile = chooser.getSelectedFile();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(currentFile));
                text.setText("");
                String line;
                while ((line = reader.readLine()) != null) {
                    text.append(line + "\n");
                }
                reader.close();
                setTitle(currentFile.getName() + "- My Notepad");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error opening file!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    //Save File Method
    public void saveFile()
    {
        if(currentFile==null) {
            saveAsFile();
        }
        else
        {
            writeFile(currentFile);
        }
    }
    //Save As File Method
    public void saveAsFile()
    {
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showSaveDialog(Notepad.this);
        if (result == JFileChooser.APPROVE_OPTION) {
            currentFile = chooser.getSelectedFile();
            writeFile(currentFile);
        }
    }
    //Write File Method
    public void writeFile(File file)
    {
        try
        {
            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter(file)
                    );

            writer.write(
                    text.getText()
            );

            writer.close();

            setTitle(
                    file.getName()
                            + " - My Notepad"
            );

            JOptionPane.showMessageDialog(
                    this,
                    "File saved successfully!"
            );
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(
                    Notepad.this,
                    "Can't save file!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void chooseFont()
    {
        String[] fonts =
                GraphicsEnvironment
                        .getLocalGraphicsEnvironment()
                        .getAvailableFontFamilyNames();

        String selectedFont =
                (String) JOptionPane.showInputDialog(
                        this,
                        "Select Font:",
                        "Font",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        fonts,
                        text.getFont()
                                .getFamily()
                );

        if(selectedFont != null)
        {
            Font oldFont =
                    text.getFont();

            text.setFont(
                    new Font(
                            selectedFont,
                            oldFont.getStyle(),
                            oldFont.getSize()
                    )
            );
        }
    }

    public void exitApplication()
    {
        int result =
                JOptionPane.showConfirmDialog(
                        this,
                        "Do you want to exit?",
                        "Exit",
                        JOptionPane.YES_NO_OPTION
                );

        if(result == JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }
}
