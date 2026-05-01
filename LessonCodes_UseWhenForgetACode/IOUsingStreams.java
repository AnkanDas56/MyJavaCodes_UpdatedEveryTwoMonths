import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
class IOUsingStreams {
   public static void main(String[] args) {
       try {
        InputStream is = new BufferedInputStream(System.in);
        ArrayList<Character> cha = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
        cha.add((char)is.read());
        }
        String s = cha.toString();
        System.out.println(s);
        is.close();
       } catch (IOException e) {
        System.err.println("IOException has occured");
       }
   }
}