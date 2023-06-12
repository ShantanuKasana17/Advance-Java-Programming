********************************* creating thread by extending thread class and by implementing runnable interface***********
Classify how many ways to create a thread. Write all the types with suitable example with output.
Ans:
There are two ways to create a thread in Java:
1.	Extending the Thread class
2.	Implementing the Runnable interface
Here's an example of each:
1.	Extending the Thread class

public class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread is running: " + i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }
}

Output 
Thread is running: 0
Thread is running: 1
Thread is running: 2
Thread is running: 3
Thread is running: 4

2.	Implementing the Runnable interface
public class MyRunnable implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread is running: " + i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}
Output:
Thread is running: 0
Thread is running: 1
Thread is running: 2
Thread is running: 3
Thread is running: 4
