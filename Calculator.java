import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
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
    Calculator cf = new CalculatorFrame();
    cf.go();
       }
   }


class CalculatorFrame extends Calculator {

    public void go(){

        //all required variable declarations
         Calculator c = new Calculator();

         //The components
         JFrame f = new JFrame();
         JButton b;                    
         JPanel bottom = new JPanel();
         JPanel top = new JPanel();
         JTextArea jta = new JTextArea(3,90);

         //The Listeners
         CalcOpButtonListener cobl = new CalcOpButtonListener(c);
         CalcNumButtonListener cnbl = new CalcNumButtonListener(c);

         //the upcoming methods :-
        jta.setText("What are you doing here");
        top.add("North",jta);
        GridLayout mgr = new GridLayout(4,4);
         bottom.setLayout(mgr);
         for(int i =9;i>=0;i--){
            b= new JButton(Integer.toString(i));  b.setActionCommand(Integer.toString(i));
            b.addActionListener(cnbl);
            bottom.add(b);
         }
         b = new JButton("=");
         bottom.add("East",b);

         b= new JButton("+");b.setActionCommand("+");b.addActionListener(cobl);bottom.add(b);
         b= new JButton("-");b.setActionCommand("-");b.addActionListener(cobl);bottom.add(b);
         b= new JButton("*");b.setActionCommand("*");b.addActionListener(cobl);bottom.add(b);
         b= new JButton("/");b.setActionCommand("/");b.addActionListener(cobl);bottom.add(b);
         b= new JButton("e");b.setActionCommand("e");b.addActionListener(cobl);bottom.add(b);
         bottom.setSize(295,285);
        f.add("South",bottom);
        f.add("North",top);
        f.setSize(295, 450);
        f.setVisible(true);
    }
}

//the Action Listener for all the buttons in the CalculatorFrame
class CalcNumButtonListener implements ActionListener{
    Calculator c ;
    public CalcNumButtonListener(Calculator c){
    this.c = c;
    }
    @Override
    public void actionPerformed(ActionEvent e){
      String s = e.getActionCommand();
      char ch = s.charAt(0);
      Double i ;
        try {
        i = Double.parseDouble(s);
        c.digit(i);
        } catch (NumberFormatException f) {
        System.out.println();
    }
}
}
class CalcOpButtonListener implements ActionListener{
    Calculator c;
    public CalcOpButtonListener (Calculator calc){
    this.c = calc;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        char ch = e.getActionCommand().charAt(0);
        System.out.println(ch);
    if(ch=='+'&&c.CC2>=1){
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
        System.exit(0);
      }
      else if(ch=='='){
        c.compute();
        System.out.println(c.display() +" "+c.value);
      }
    }
}