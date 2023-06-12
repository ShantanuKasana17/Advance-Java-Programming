****************************Java exception*******************************
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CheckedExample {
    public static void main(String[] args) {
        try {
            File file = new File("file.txt");
            FileReader fr = new FileReader(file);
            char[] data = new char[50];
            fr.read(data);
            fr.close();
            System.out.println(data);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
