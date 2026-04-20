import java.awt.event.*;
import java.awt.*;
import java.util.InputMismatchException;
import java.util.*;

public class Calculator{
    public static double value=0 , keep=0 ;
    public char toDo ;
    public int CC=0 ;
    public int CC2=0;
    public int CC3=0; 

    public void binaryOperations(char op){
        keep = value;
        value = 0;
        this.toDo=op;
        this.CC3++;
        this.CC2++;
    }
    public void add (){
        this.binaryOperations('+');
    }
    public  void subtract(){
        this.binaryOperations('-');
    }
    public void multiply(){
        this.binaryOperations('*');
    }
    public void divide(){
        this.binaryOperations('/');
    }
    public void squareOf(){
        this.binaryOperations('˜');
    }
    public void exit(){
        this.binaryOperations('e');
    }
    public static void clear(){
        value = 0;
        keep = 0;
        System.out.println("Cleared and restarting the calculator.");
    }
    public void digit(double x){
        this.value = (this.value*10)+x;
    }

    public void compute(){
    if (this.toDo == '+'){
        value = keep + value;
    }
    else if (this.toDo == '-'){
        value = keep - value;
    }
    else if (this.toDo == '*'){
        value = keep * value; 
    }
    else if (this.toDo == '/'){
        value = keep / value;
    }
    else if( this.toDo == '˜'){
        value = keep*keep;
    }
    else if( this.toDo=='!'){
        clear();
    }
    else if(toDo == 'e'){
        System.exit(0);
    return;
    }
}
    public double display(){
        System.out.println( value);
        return value;
    }
    public void compute2(){
      
        Scanner sc = new Scanner(System.in);
        double m1 =sc.nextDouble();

        Scanner sc3 = new Scanner(System.in);
        char op0 = sc3.next().charAt(0);

        Scanner sc2 = new Scanner(System.in);  
        double m2 = sc.nextDouble();
       
    
        this.digit(m1);        
        this.binaryOperations(op0); 
        this.digit(m2);
        this.compute();
        this.display(); 
        clear(); 
    }


    public void disclaimer(){
    System.out.println("Use the calculator for unlimited times and to terminat it, type 'e'");
     this.CC++;
    }

public void go() {
     try {
        if(this.CC==0){
        this.disclaimer();
        this.compute2();
        }
        else if(this.CC>=1){
            this.compute2();
        }
        } catch (InputMismatchException e) {
            System.err.println("Exited SuccessFully");
            System.exit(0);
            return;
        }
        this.go();
   }

   //the final line of code in the calculator class the main method
   public static void main(String[] args) {
       Calculator c = new Calculator();
       c.go();
   }
   }


class CalculatorFrame {

    public void go(){
        //all required variable declarations
         Frame f = new Frame();
         Button b;                    
         Panel bottom = new Panel();
         CalcButtonListener cba = new CalcButtonListener(new Calculator());
         //the upcoming methods :-

        GridLayout mgr = new GridLayout(4,4);
         bottom.setLayout(mgr);
         for(int i =9;i>=0;i--){
            b= new Button(Integer.toString(i));  b.setActionCommand(Integer.toString(i));
            b.addActionListener(cba);
            bottom.add(b);
         }
         b = new Button("=");
         bottom.add("East",b);

         b= new Button("+");b.setActionCommand("+");b.addActionListener(cba);bottom.add(b);
         b= new Button("-");b.setActionCommand("-");b.addActionListener(cba);bottom.add(b);
         b= new Button("*");b.setActionCommand("*");b.addActionListener(cba);bottom.add(b);
         b= new Button("/");b.setActionCommand("/");b.addActionListener(cba);bottom.add(b);
         b= new Button("e");b.setActionCommand("e");b.addActionListener(cba);bottom.add(b);
        f.add("South",bottom);
        f.setSize(295, 450);
        f.setVisible(true);
    }
}
class CalcButtonListener implements ActionListener{
    Calculator c ;
    public CalcButtonListener(Calculator c){
    this.c = c;
    }
    @Override
    public void actionPerformed(ActionEvent e){
      String s = e.getActionCommand();
      char ch = s.charAt(0);
      if(c.CC2==0){
      int i = Integer.parseInt(s);
      c.digit((double)i);
      }
      else if(ch=='+'){
        c.add();
      }else if(ch=='*'){
       c.multiply();
      }else if(ch=='/'){
       c.divide();
      }else if(ch=='˜'){
        c.squareOf();
      }else if(ch=='-'){
        c.subtract();
      }else if(ch=='e'){
        c.exit();
      }
      else if(ch=='='){
        int i = Integer.parseInt(s);
        c.digit(i);
        c.compute();
        c.display();
      }
    }
}
