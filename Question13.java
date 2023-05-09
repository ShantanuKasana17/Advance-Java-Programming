Implement Event Handling operations using the classes like ActionListner, MouseListner and
MouseMotionListener.

  ****************************Solution***********************************
  import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EventHandlingExample extends JFrame implements ActionListener, MouseListener, MouseMotionListener {

    private JTextField textField;
    private JPanel panel;

    public EventHandlingExample() {
        super("Event Handling Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        textField = new JTextField("Click me or move the mouse over me!", 20);

        panel.add(textField);
        add(panel);

        // Add listeners to the text field and the panel
        textField.addActionListener(this);
        panel.addMouseListener(this);
        panel.addMouseMotionListener(this);

        setSize(300, 100);
        setVisible(true);
    }

    // ActionListener method
    public void actionPerformed(ActionEvent event) {
        String text = textField.getText();
        System.out.println("Action performed! Text entered: " + text);
    }

    // MouseListener methods
    public void mouseClicked(MouseEvent event) {
        System.out.println("Mouse clicked on panel!");
    }

    public void mouseEntered(MouseEvent event) {
        System.out.println("Mouse entered panel!");
    }

    public void mouseExited(MouseEvent event) {
        System.out.println("Mouse exited panel!");
    }

    public void mousePressed(MouseEvent event) {
        System.out.println("Mouse pressed on panel!");
    }

    public void mouseReleased(MouseEvent event) {
        System.out.println("Mouse released on panel!");
    }

    // MouseMotionListener methods
    public void mouseDragged(MouseEvent event) {
        System.out.println("Mouse dragged on panel!");
    }

    public void mouseMoved(MouseEvent event) {
        System.out.println("Mouse moved over panel!");
    }

    public static void main(String[] args) {
        new EventHandlingExample();
    }
}
In this example, we create a JFrame and add a JPanel with a JTextField. We then add listeners to the JTextField and the JPanel, so that we can handle events such as button clicks and mouse movements.

The ActionListener is used to handle events when the user presses Enter while the JTextField is in focus. When the user presses Enter, the actionPerformed method is called and we retrieve the text from the JTextField.

The MouseListener is used to handle events such as mouse clicks and releases on the JPanel. We implement all five methods of the MouseListener interface: mouseClicked, mouseEntered, mouseExited, mousePressed, and mouseReleased.

The MouseMotionListener is used to handle events when the user moves the mouse over the JPanel. We implement both methods of the MouseMotionListener interface: mouseMoved and mouseDragged.

In each of the event handling methods, we simply print a message to the console to indicate which event has occurred. You can modify these methods to perform any desired action based on the event that has occurred.
