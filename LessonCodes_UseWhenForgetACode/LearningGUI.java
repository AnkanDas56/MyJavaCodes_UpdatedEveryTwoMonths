import java.awt.*;
public class LearningGUI {
Frame f;
public static void main(String[] args){
 LearningGUI lg = new LearningGUI();
 lg.f = new Frame("First");
 lg.f.setSize(1080,1920);
 lg.f.setVisible(true);
 Checkbox cb = new Checkbox();
 Button b = new Button("Click Me");
 b.setSize(256,256);
 b.setLocation(256, 540);
 lg.f.add(b);
 lg.f.add(cb);
}
}