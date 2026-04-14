import java.awt.*;
public class LearningGUI {
Frame f = new Frame("First");
public static void main(String[] args){
LearningGUI l = new LearningGUI();
Panel p = new Panel();
p.setLayout(new GridLayout(3,2));
Button b = new Button("Click Me");
Checkbox cb = new Checkbox();
p.add(b);
p.add(cb);
l.f.add(p);
l.f.setVisible(true);
}
}