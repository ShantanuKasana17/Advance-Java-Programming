************************************* creating buttons ******************************
import java.awt.*;
 
class prog3  {
    prog3() {
        Frame f = new Frame();
        Button b1 = new Button("OK");
        b1.setBounds(100, 50, 50, 50);
        f.add(b1);
        Button b2 = new Button("SUBMIT");
        b2.setBounds(100, 101, 50, 50);
        f.add(b2);
        Button b3 = new Button("CANCLE");
        b3.setBounds(100, 150, 80, 50);
        f.add(b3);
        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);
    }
 
    public static void main(String a[]) {
        new prog3();
    }
}
