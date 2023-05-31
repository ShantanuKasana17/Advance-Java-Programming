************************Create an Employee pay role system using swing Choice Components ActionListener like Check Boxes,
Radio Buttons, Borders, Combo Boxes and Sliders with sample output.********************************

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class EmployeePayrollSystem extends JFrame implements ActionListener {
    private JCheckBox medicalCheckBox, dentalCheckBox, pensionCheckBox;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private JComboBox<String> positionComboBox;
    private JSlider experienceSlider;

    public EmployeePayrollSystem() {
        setTitle("Employee Payroll System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 1));

        // Medical Benefits
        JPanel medicalPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        medicalCheckBox = new JCheckBox("Medical Benefits");
        medicalPanel.add(medicalCheckBox);
        add(medicalPanel);

        // Dental Benefits
        JPanel dentalPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dentalCheckBox = new JCheckBox("Dental Benefits");
        dentalPanel.add(dentalCheckBox);
        add(dentalPanel);

        // Pension Plan
        JPanel pensionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pensionCheckBox = new JCheckBox("Pension Plan");
        pensionPanel.add(pensionCheckBox);
        add(pensionPanel);

        // Gender
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        Border genderBorder = BorderFactory.createTitledBorder("Gender");
        genderPanel.setBorder(genderBorder);
        ButtonGroup genderGroup = new ButtonGroup();
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);
        add(genderPanel);

        // Position
        JPanel positionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        Border positionBorder = BorderFactory.createTitledBorder("Position");
        positionPanel.setBorder(positionBorder);
        String[] positions = {"Manager", "Developer", "Designer", "Tester"};
        positionComboBox = new JComboBox<>(positions);
        positionPanel.add(positionComboBox);
        add(positionPanel);

        // Experience
        JPanel experiencePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        Border experienceBorder = BorderFactory.createTitledBorder("Experience");
        experiencePanel.setBorder(experienceBorder);
        experienceSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
        experienceSlider.setMajorTickSpacing(2);
        experienceSlider.setPaintTicks(true);
        experienceSlider.setPaintLabels(true);
        experiencePanel.add(experienceSlider);
        add(experiencePanel);

        // Calculate Button
        JPanel calculatePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton calculateButton = new JButton("Calculate Salary");
        calculateButton.addActionListener(this);
        calculatePanel.add(calculateButton);
        add(calculatePanel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Calculate Salary")) {
            boolean hasMedicalBenefits = medicalCheckBox.isSelected();
            boolean hasDentalBenefits = dentalCheckBox.isSelected();
            boolean hasPensionPlan = pensionCheckBox.isSelected();
            String gender = maleRadioButton.isSelected() ? "Male" : "Female";
            String position = positionComboBox.getSelectedItem().toString();
            int experience = experienceSlider.getValue();

            // Calculate salary based on the selected options
            double baseSalary = 1000.0;
            double medicalAllowance = hasMedicalBenefits ? 100.0 : 0.0;
            double dentalAllowance = hasDentalBenefits ? 50.0 : 0.0;
            double pensionAllowance = hasPensionPlan ? 150.0 : 0.0;
            double experienceAllowance = experience * 50.0;
            double totalSalary = baseSalary + medicalAllowance + dentalAllowance + pensionAllowance + experienceAllowance;

            // Display the calculated salary
            JOptionPane.showMessageDialog(this, "Gender: " + gender + "\n" +
                    "Position: " + position + "\n" +
                    "Experience: " + experience + " years\n" +
                    "Total Salary: $" + totalSalary);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new EmployeePayrollSystem();
            }
        });
    }
}
