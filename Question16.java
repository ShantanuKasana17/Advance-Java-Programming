*****************Create an Notepad application using swing Menus ActionListener like Menu Building, Icons in Menu
Items, Check box and Radio Buttons in Menu Items, Pop-up Menus, Keyboard Mnemonics and
Accelerators, Enabling the Design menu Items, Toolbars and Tooltips with sample output**************************

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;

public class NotepadApplication extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JFileChooser fileChooser;
    private String currentFilePath;

    public NotepadApplication() {
        setTitle("Notepad");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Text Area
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // File Menu
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(fileMenu);

        JMenuItem newMenuItem = new JMenuItem("New");
        newMenuItem.setIcon(new ImageIcon("icons/new.png"));
        newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        newMenuItem.addActionListener(this);
        fileMenu.add(newMenuItem);

        JMenuItem openMenuItem = new JMenuItem("Open");
        openMenuItem.setIcon(new ImageIcon("icons/open.png"));
        openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
        openMenuItem.addActionListener(this);
        fileMenu.add(openMenuItem);

        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.setIcon(new ImageIcon("icons/save.png"));
        saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        saveMenuItem.addActionListener(this);
        fileMenu.add(saveMenuItem);

        JMenuItem saveAsMenuItem = new JMenuItem("Save As");
        saveAsMenuItem.setIcon(new ImageIcon("icons/save_as.png"));
        saveAsMenuItem.addActionListener(this);
        fileMenu.add(saveAsMenuItem);

        fileMenu.addSeparator();

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setIcon(new ImageIcon("icons/exit.png"));
        exitMenuItem.addActionListener(this);
        fileMenu.add(exitMenuItem);

        // Edit Menu
        JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic(KeyEvent.VK_E);
        menuBar.add(editMenu);

        JMenuItem cutMenuItem = new JMenuItem(new DefaultEditorKit.CutAction());
        cutMenuItem.setText("Cut");
        cutMenuItem.setIcon(new ImageIcon("icons/cut.png"));
        cutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));
        editMenu.add(cutMenuItem);

        JMenuItem copyMenuItem = new JMenuItem(new DefaultEditorKit.CopyAction());
        copyMenuItem.setText("Copy");
        copyMenuItem.setIcon(new ImageIcon("icons/copy.png"));
        copyMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
        editMenu.add(copyMenuItem);

        JMenuItem pasteMenuItem = new JMenuItem(new DefaultEditorKit.PasteAction());
        pasteMenuItem.setText("Paste");
        pasteMenuItem.setIcon(new ImageIcon("icons/paste.png"));
        pasteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));
        editMenu.add(pasteMenuItem);

        // View Menu
        JMenu viewMenu = new JMenu("View");
        viewMenu.setMnemonic(KeyEvent.VK_V);
        menuBar.add(viewMenu);

        JCheckBoxMenuItem wordWrapCheckBoxMenuItem = new JCheckBoxMenuItem("Word Wrap");
        wordWrapCheckBoxMenuItem.addActionListener(this);
        viewMenu.add(wordWrapCheckBoxMenuItem);

        // Help Menu
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);
        menuBar.add(helpMenu);

        JMenuItem aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.addActionListener(this);
        helpMenu.add(aboutMenuItem);

        // Pop-up Menu
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem cutPopupMenuItem = new JMenuItem(new DefaultEditorKit.CutAction());
        cutPopupMenuItem.setText("Cut");
        cutPopupMenuItem.setIcon(new ImageIcon("icons/cut.png"));
        popupMenu.add(cutPopupMenuItem);
        JMenuItem copyPopupMenuItem = new JMenuItem(new DefaultEditorKit.CopyAction());
        copyPopupMenuItem.setText("Copy");
        copyPopupMenuItem.setIcon(new ImageIcon("icons/copy.png"));
        popupMenu.add(copyPopupMenuItem);
        JMenuItem pastePopupMenuItem = new JMenuItem(new DefaultEditorKit.PasteAction());
        pastePopupMenuItem.setText("Paste");
        pastePopupMenuItem.setIcon(new ImageIcon("icons/paste.png"));
        popupMenu.add(pastePopupMenuItem);
        textArea.setComponentPopupMenu(popupMenu);

        // ToolBar
        JToolBar toolBar = new JToolBar();
        add(toolBar, BorderLayout.NORTH);

        JButton newButton = new JButton(new ImageIcon("icons/new.png"));
        newButton.setToolTipText("New");
        newButton.addActionListener(this);
        toolBar.add(newButton);

        JButton openButton = new JButton(new ImageIcon("icons/open.png"));
        openButton.setToolTipText("Open");
        openButton.addActionListener(this);
        toolBar.add(openButton);

        JButton saveButton = new JButton(new ImageIcon("icons/save.png"));
        saveButton.setToolTipText("Save");
        saveButton.addActionListener(this);
        toolBar.add(saveButton);

        // File Chooser
        fileChooser = new JFileChooser();

        // Document Listener
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                setTitle("*Notepad");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                setTitle("*Notepad");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                setTitle("*Notepad");
            }
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("New")) {
            newDocument();
        } else if (command.equals("Open")) {
            openDocument();
        } else if (command.equals("Save")) {
            saveDocument();
        } else if (command.equals("Save As")) {
            saveDocumentAs();
        } else if (command.equals("Exit")) {
            exitApplication();
        } else if (command.equals("Word Wrap")) {
            toggleWordWrap();
        } else if (command.equals("About")) {
            showAboutDialog();
        }
    }

    private void newDocument() {
        if (textArea.getText().isEmpty()) {
            textArea.setText("");
            currentFilePath = null;
            setTitle("Notepad");
        } else {
            int option = showSaveChangesDialog();
            if (option == JOptionPane.YES_OPTION) {
                saveDocument();
            } else if (option == JOptionPane.NO_OPTION) {
                textArea.setText("");
                currentFilePath = null;
                setTitle("Notepad");
            }
        }
    }

    private void openDocument() {
        int option = showSaveChangesDialog();
        if (option == JOptionPane.YES_OPTION) {
            saveDocument();
        } else if (option == JOptionPane.CANCEL_OPTION || option == JOptionPane.CLOSED_OPTION) {
            return;
        }

        fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
                textArea.read(reader, null);
                reader.close();
                currentFilePath = selectedFile.getAbsolutePath();
                setTitle("Notepad - " + currentFilePath);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error occurred while opening the file.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void saveDocument() {
        if (currentFilePath == null) {
            saveDocumentAs();
        } else {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(currentFilePath));
                textArea.write(writer);
                writer.close();
                setTitle("Notepad - " + currentFilePath);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error occurred while saving the file.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void saveDocumentAs() {
        fileChooser.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile));
                textArea.write(writer);
                writer.close();
                currentFilePath = selectedFile.getAbsolutePath();
                setTitle("Notepad - " + currentFilePath);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error occurred while saving the file.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void exitApplication() {
        int option = showSaveChangesDialog();
        if (option == JOptionPane.YES_OPTION) {
            saveDocument();
        } else if (option == JOptionPane.CANCEL_OPTION || option == JOptionPane.CLOSED_OPTION) {
            return;
        }
        System.exit(0);
    }

    private void toggleWordWrap() {
        boolean wordWrapEnabled = textArea.getWrapStyleWord();
        textArea.setLineWrap(!wordWrapEnabled);
        textArea.setWrapStyleWord(!wordWrapEnabled);
    }

    private void showAboutDialog() {
        JOptionPane.showMessageDialog(this, "Notepad Application\nVersion 1.0", "About", JOptionPane.INFORMATION_MESSAGE);
    }

    private int showSaveChangesDialog() {
        if (textArea.getText().isEmpty()) {
            return JOptionPane.NO_OPTION;
        }
        return JOptionPane.showConfirmDialog(this, "Do you want to save changes?", "Notepad", JOptionPane.YES_NO_CANCEL_OPTION);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NotepadApplication();
            }
        });
    }
}

