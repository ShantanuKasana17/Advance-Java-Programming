---------------------------Swing components and their implementation in student profile-------------------------
  
  
 ------- Create a student profile page using swing Components Organizers ActionListener like Split Panes, Tabbed
Panes, Desktop Panes and Internal Frames, Cascading and Tiling with sample output---------
  
  
  import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrganizationManagementSystem extends JFrame implements ActionListener {
    private JList<String> employeeList;
    private JTable employeeTable;
    private JProgressBar progressBar;

    public OrganizationManagementSystem() {
        setTitle("Organization Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Employee List
        String[] employees = {"John", "Mary", "David", "Linda", "Michael"};
        employeeList = new JList<>(employees);
        JScrollPane listScrollPane = new JScrollPane(employeeList);
        listScrollPane.setPreferredSize(new Dimension(200, getHeight()));
        add(listScrollPane, BorderLayout.WEST);

        // Employee Table
        String[] columnNames = {"ID", "Name", "Department", "Position"};
        Object[][] data = {
                {1, "John", "HR", "Manager"},
                {2, "Mary", "Finance", "Analyst"},
                {3, "David", "IT", "Developer"},
                {4, "Linda", "Sales", "Executive"},
                {5, "Michael", "Marketing", "Coordinator"}
        };
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        employeeTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(employeeTable);
        add(tableScrollPane, BorderLayout.CENTER);

        // Progress Bar
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        add(progressBar, BorderLayout.SOUTH);

        // List selection listener
        employeeList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedIndex = employeeList.getSelectedIndex();
                if (selectedIndex >= 0) {
                    updateEmployeeTable(selectedIndex);
                }
            }
        });

        // Button
        JButton startButton = new JButton("Start");
        startButton.addActionListener(this);
        add(startButton, BorderLayout.NORTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Start")) {
            startProcessing();
        }
    }

    private void updateEmployeeTable(int index) {
        DefaultTableModel tableModel = (DefaultTableModel) employeeTable.getModel();
        tableModel.setRowCount(0);

        int employeeId = index + 1;
        String name = employeeList.getSelectedValue();

        // Simulating fetching employee details from a database
        // Here, we use predefined data for simplicity
        Object[] employeeDetails = {
                employeeId,
                name,
                tableModel.getValueAt(index, 2),
                tableModel.getValueAt(index, 3)
        };

        tableModel.addRow(employeeDetails);
    }

    private void startProcessing() {
        progressBar.setValue(0);

        Timer timer = new Timer(100, new ActionListener() {
            int progress = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                progress++;
                progressBar.setValue(progress);

                if (progress >= 100) {
                    ((Timer) e.getSource()).stop();
                    JOptionPane.showMessageDialog(OrganizationManagementSystem.this,
                            "Processing completed.", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new OrganizationManagementSystem();
            }
        });
    }
}



