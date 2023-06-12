******************************Write an applet program to display sum of two numbers with output********************
Describe the Life cycle of an Applet with diagram in details and its Hierarchy of Applet class. Write an
applet program to display sum of two numbers with output.

What is Applet [Some Key Points]: 
1.	An applet is a special kind of Java program that runs in a Java enabledbrowser.
2.	This is the first Java program that can run over the network using thebrowser.
3.	Applet is typically embedded inside a web page and runs in the browser.
4.	Applets are small Java applications that can be accessed on an Internetserver,  transported  over  Internet,  and  can  be  automatically  installedand run as apart of a web document.
5.	After a user receives an applet, the applet can produce a graphical userinterface.
6.	It has limited access to resources so that it can run complex computa-tions without introducing the risk of viruses or breaching data integrity.
7.	To create an applet, a class must class extends java.applet.Applet class.
8.	An Applet class does not have any main() method.  It is viewed usingJVM.
9.	The  JVM  can  use  either  a  plug-in  of  the  Web  browser  or  a  separateruntime environment to run an applet application.
10.	JVM creates an instance of the applet class and invokes init() methodto initialize an Applet.
11.	Java Applet is deprecated since Java 9.
	





Life Cycle of Applet:
	Following are the stages in Applet:
1.	Applet is initialized
2.	Applet is started
3.	Applet is painted
4.	Applet is stopped
5.	Applet is destroyed.

	Most applets override these four methods.  These four methods forms Applet lifecycle.
1.	init() :  init() is the first method to be called.  This is where variable are initialized.  This method is called only once during the runtime of applet.
2.	start()  :  start()  method  is  called  after  init().  This  method  is  called  to restart an applet after it has been stopped.
3.	stop()  :  stop()  method  is  called  to  suspend  thread  that  does  not  need to run when applet is not visible.
4.	destroy()  :   destroy()  method  is  called  when  your  applet  needs  to  be removed completely from memory.

                           

Code-1:

import java.applet.Applet;
import java.awt.Graphics;

public class SumApplet extends Applet {
    int num1 = 5;
    int num2 = 3;
    int sum;

    public void init() {
        sum = num1 + num2;
    }

    public void paint(Graphics g) {
        g.drawString("The sum of " + num1 + " and " + num2 + " is " + sum, 20, 20);
    }
}


Code-2:
import java.awt.*;
   import java.applet.*;
    import java.awt.event.*;
    import java.awt.Label;

    public class add extends Applet implements ActionListener{
      TextField text1,text2,output;
      Label label1,label2,label3,title;
      Button button,clear;
      public void init(){
        setLayout(null);




          title = new Label("Addition of Two Numbers");
    title.setBounds(80,10,140,20);
    add(title);
    title.setAlignment(title.CENTER);

        label1 = new Label("Enter Number 1: ");
        label1.setBounds(20,50,100,20);
        add(label1);

        text1 = new TextField(5);
        text1.setBounds(150,50,100,20);
        add(text1);

        label2 = new Label("Enter Number 2: ");
        label2.setBounds(20,90,100,20);
        add(label2);

        text2 = new TextField(5);
        text2.setBounds(150,90,100,20);
        add(text2);

        label3 = new Label("Sum of Two Numbers: ");
        label3.setBounds(20,130,130,20);
        add(label3);

        output = new TextField(5);
        output.setBounds(150,130,100,20);
        add(output);

        button = new Button("Sum");
        button.setBounds(150,170,100,20);
        add(button);

  clear = new Button("Clear");
        clear.setBounds(280,170,100,20);
        add(clear);

        button.addActionListener(this);
        clear.addActionListener(this);


        }
        public void actionPerformed(ActionEvent ae){
        int num1=Integer.parseInt(text1.getText());
        int num2=Integer.parseInt(text2.getText());
        int sum=num1+num2;
        output.setText(Integer.toString(sum));
   if(ae.getSource() == clear)
   {
     text1.setText("");
     text2.setText("");
      output.setText("");
      text1.requestFocus();
    }
}
}

     

