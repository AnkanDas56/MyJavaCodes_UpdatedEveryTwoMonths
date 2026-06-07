import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.io.*;
import java.util.*;

import javax.swing.*;

import java.awt.event.*;
  // I would use Other collection frameWorks if it were a search System
class LoginSystem extends LinkedHashMap<String, String>{
  private LinkedHashMap<String,String> UserList = new LinkedHashMap<>();

  @Override
  public String toString(){
    String s = this.UserList.values().toString() ;
    return s;
  }

  public void addUser(String UserName, String Password){
    this.UserList.put(Password,UserName);
  }
  public void addUser(Person user){
    this.UserList.put(user.Password(),user.UserName());
  }
  public String searchUserName(String UserName){
    if(this.UserList.containsValue(UserName)) return "Found = "+UserName;
    else if(this.UserList.containsValue(UserName.toLowerCase())) return "Found = "+UserName.toLowerCase();
    else if(this.UserList.containsValue(UserName.toUpperCase())) return "Found = "+UserName.toUpperCase();
    else return null;
  }
  public String getUserList(){
  return this.UserList.values().toString();
  }
  public boolean loginByPassword(String Password,String UserName){
   if(this.UserList.get(Password)!=null&&this.UserList.get(Password).hashCode()==UserName.hashCode()) return true; // the user could get in by typing in the Password
   else return false;
  }
  public static void main(String[] args){
    LogInSystemGUI logSys = new LogInSystemGUI();
   PrintStream os = new PrintStream(System.out);
   Scanner sc= new Scanner(System.in);
   Person p1 = new Person("AnkanDas56","ankandas@12","Hello, I am Ankan Das, a 12 y/o java developer aspiring a full stack developer seat in Facbook , Google, Amazon or ,Apple (most wanted co. is Apple)");
   Person p2 = new Person("Johnny","None","Look at my UserName, You will understand by yourself");
   logSys.addUser(p1);
   logSys.addUser(p2);
   logSys.go();
  }
}


class LogInSystemGUI extends LoginSystem implements ActionListener{
 Runnable r;
 @SuppressWarnings("static-access")
 public void go(){
  JFrame f = new JFrame("Login");
  JTextArea UNArea = new JTextArea("Enter Your UserName");
  LayoutManager mgr = new GridLayout(1, 200);
  UNArea.setLayout(mgr);
  JTextArea PArea = new JTextArea("Enter Your Password");
  PArea.setLayout(mgr);
  JPanel p = new JPanel(new GridLayout(3, 1));
  p.add(UNArea,"North");
  p.add(PArea,"South");
  JButton b = new JButton("Login");b.addActionListener(this);
  p.add(b);
  f.add(p);
  f.setVisible(true);
  this.r = () -> System.out.println(this.loginByPassword(PArea.getText(),UNArea.getText()));

 }

public void actionPerformed(ActionEvent e){
Thread t = new Thread(this.r);
t.start();
}

}
record Person(String UserName,String Password,String bio) implements Comparable<Person>{
   @Override
   public String toString(){
   StringBuilder sb = new StringBuilder();
   int i =0;
     while(i +4 != this.Password().length()){
     sb.append("*");
     i++;
     }
   String LastFour = this.Password.substring(this.Password.length()-4);
   sb.append(LastFour);
   String s = "UserName = " + this.UserName()+" and , Password = "+sb.toString();
   return s+"\n"+this.bio();
   }
   public int compareTo(Person p){
    return this.UserName.compareTo(p.UserName);
   }
}
