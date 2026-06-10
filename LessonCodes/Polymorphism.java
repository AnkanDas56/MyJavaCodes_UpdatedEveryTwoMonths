import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

abstract public class Polymorphism {
    protected void dosomething() {
        out.println("It's not running Sir");
    }

    public static void main(String[] args) {

        Polymorphism e = new Extender();
        e.dosomething();
        List<String> cmd = new ArrayList<>();
        cmd.add("kill");
        cmd.add("-9 $$");
        ProcessBuilder builder = new ProcessBuilder(cmd);
        try {
            Process process = builder.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = br.readLine();
            out.println(line);
        } catch (IOException gj) {

        }
    }

}

class Extender extends Polymorphism {
    @Override
    protected void dosomething() {
        out.println("HelloWorld");
    }
}