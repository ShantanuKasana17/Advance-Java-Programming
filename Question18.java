******************Create a student course registration form using swing Text Input fields ActionListener like Text Fields,
Password Fields, Text Areas, Scroll Pane and Labeling Components with sample output. **********************************************



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CourseRegistrationForm {

    private JFrame frame;
    private JPanel mainPanel;

    private JLabel studentNameLabel;
    private JTextField studentNameTextField;

    private JLabel studentIdLabel;
    private JTextField studentIdTextField;

    private JLabel courseNameLabel;
    private JTextField courseNameTextField;

    private JLabel courseDescriptionLabel;
    private JTextArea courseDescriptionTextArea;

    private JLabel courseCreditsLabel;
    private JTextField courseCreditsTextField;

    private JButton registerButton;

    public CourseRegistrationForm() {
        frame = new JFrame("Course Registration Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 2));

        studentNameLabel = new JLabel("Student Name");
        studentNameTextField = new JTextField();

        studentIdLabel = new JLabel("Student ID");
        studentIdTextField = new JTextField();

        courseNameLabel = new JLabel("Course Name");
        courseNameTextField = new JTextField();

        courseDescriptionLabel = new JLabel("Course Description");
        courseDescriptionTextArea = new JTextArea(5, 20);
        courseDescriptionTextArea.setLineWrap(true);
        courseDescriptionTextArea.setWrapStyleWord(true);

        courseCreditsLabel = new JLabel("Course Credits");
        courseCreditsTextField = new JTextField();

        registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentName = studentNameTextField.getText();
                String studentId = studentIdTextField.getText();
                String courseName = courseNameTextField.getText();
                String courseDescription = courseDescriptionTextArea.getText();
                int courseCredits = Integer.parseInt(courseCreditsTextField.getText());

                System.out.println("Student Name: " + studentName);
                System.out.println("Student ID: " + studentId);
                System.out.println("Course Name: " + courseName);
                System.out.println("Course Description: " + courseDescription);
                System.out.println("Course Credits: " + courseCredits);
            }
        });

        mainPanel.add(studentNameLabel);
        mainPanel.add(studentNameTextField);

        mainPanel.add(studentIdLabel);
        mainPanel.add(studentIdTextField);

        mainPanel.add(courseNameLabel);
        mainPanel.add(courseNameTextField);

        mainPanel.add(courseDescriptionLabel);
        mainPanel.add(new JScrollPane(courseDescriptionTextArea));

        mainPanel.add(courseCreditsLabel);
        mainPanel.add(courseCreditsTextField);

        mainPanel.add(registerButton);

        frame.add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CourseRegistrationForm();
    }
}
