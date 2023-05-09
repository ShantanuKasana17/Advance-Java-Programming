Implement the stack operations using Interfaces with 10 different values to get in run time.
  
  
  ************************************************* Solution*******************************************
  import java.util.Scanner;

interface Stack {
    void push(int value);
    int pop();
    int peek();
    boolean isEmpty();
    boolean isFull();
}

class FixedSizeStack implements Stack {
    private int[] data;
    private int top;
    private int size;

    public FixedSizeStack(int size) {
        this.data = new int[size];
        this.top = -1;
        this.size = size;
    }

    @Override
    public void push(int value) {
        if (isFull()) {
            System.out.println("Error: Stack is full");
            return;
        }

        top++;
        data[top] = value;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            System.out.println("Error: Stack is empty");
            return -1;
        }

        int value = data[top];
        top--;
        return value;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("Error: Stack is empty");
            return -1;
        }

        return data[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == size - 1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the stack: ");
        int size = scanner.nextInt();

        Stack stack = new FixedSizeStack(size);

        System.out.println("Pushing values onto the stack...");
        for (int i = 1; i <= 10; i++) {
            System.out.print("Enter value " + i + ": ");
            int value = scanner.nextInt();
            stack.push(value);
        }

        System.out.println("Popping values from the stack...");
        while (!stack.isEmpty()) {
            int value = stack.pop();
            System.out.println(value);
        }
    }
}
