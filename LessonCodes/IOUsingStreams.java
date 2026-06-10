import java.io.*;
import java.util.Scanner;

class IOUsingStreams {
    public static void main(String[] args) {
        try {
            OutputStream os = new PrintStream(System.out);
            String s = "HelloWorld ";
            char[] cha = s.toCharArray();
            for (char ch : cha) {
                os.write(ch);
            }
            os.write(266457934);

        } catch (IOException e) {
            System.err.println("IOException has occured");
        }
    }
}
   