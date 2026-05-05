import java.io.*;
import java.util.Scanner;
class LoginSystem{
public static void main(String[] args) {
  Person p1 = new Person("AnkanDas56","AnkanDas@12");
  System.out.println(p1);
    InputStream inputStream = new BufferedInputStream(System.in);
    Scanner sc = new Scanner(inputStream);
    String userName;
    String Password;
    userName = sc.nextLine();
    sc = new Scanner(inputStream);
    Password = sc.nextLine();
    Person p2 = new Person(userName,Password);
    System.out.println(p2+" "+p1.compareTo(p2));
    ;
  }
}


class LogInSystemGUI extends LoginSystem{

}
record Person( String UserName,String Password) implements Comparable<Person>{
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
   String s = "UserName = " + this.UserName()+" Password = "+sb.toString();
   return s;
   }
   public int compareTo(Person p){
    return this.UserName.compareTo(p.UserName);
   }
}
