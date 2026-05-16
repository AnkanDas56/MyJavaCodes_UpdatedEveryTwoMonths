import java.io.*;
import java.util.*;
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
  public boolean loginByPassword(String Password,Person p){
   if(this.UserList.get(Password)==p.UserName()) return true; // the user could get in by typing in the Password
   else return false;
  }
  public static void main(String[] args)throws  IOException {
    LoginSystem logSys = new LoginSystem();
   PrintStream os = new PrintStream(System.out);
   Scanner sc= new Scanner(System.in);
   Person p1 = new Person("AnkanDas56","ankandas@12","Hello, I am Ankan Das, a 12 y/o java developer aspiring a full stack developer seat in Facbook , Google, Amazon or ,Apple (most wanted co. is Apple)");
   Person p2 = new Person("Johnny","None","Look at my UserName, You will understand by yourself");
   logSys.addUser(p1);
   logSys.addUser(p2);
   os.println(Boolean.toString(logSys.loginByPassword(sc.next(),p2)));
  }
}


class LogInSystemGUI extends LoginSystem{

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
