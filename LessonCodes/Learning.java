import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Learning{
public static void main(String[] args) {

    String s = null;
    try {
        Socket socket = new Socket(s, 9005);
        OutputStream os = new FileOutputStream("../output.txt");
        InputStream is = socket.getInputStream();
        System.out.println(is.read());
    } catch (Exception e){
        System.err.println(e);
    }
}}