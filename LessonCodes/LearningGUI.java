import java.awt.Choice;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
public class LearningGUI {
public static void main(String[] args){
Choice c = new Choice();
c.add("Orange");
c.add("Apple");
c.add("Banana");
c.add("Papaya");
c.setBackground(Color.BLACK);
c.setForeground(Color.GREEN);
JFrame f = new JFrame();
JTextArea jta = new JTextArea(20,10);
jta.setBackground(Color.BLACK);
jta.setForeground(Color.GREEN);
jta.setEditable(true);
f.add(jta);
f.add(c,"North");
f.setBackground(Color.BLACK);
f.setVisible(true);
}
}