import java.awt.event.*;
import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Calculator{
    public static double value , keep ;
    public double  num1 , num2;
    public char toDo ;
    public int CC=0 ;
    public int CC2=0;
    public int CC3=0; 

    public void binaryOperations(char op){
        keep = value;
        value = 0 ;
        this.toDo=op;
        this.CC3++;
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
    public static void clear(){
        value = 0;
        keep = 0;
        System.out.println("Cleared and restarting the calculator.");
    }
    public void digit(double x){
        this.value = (this.value*10)+x;
        this.CC2++;
    }

    public void compute(){
    if (toDo == '+'){
        value = keep + value;
    }
    else if (toDo == '-'){
        value = keep - value;
    }
    else if (toDo == '*'){
        value = keep * value; 
    }
    else if (toDo == '/'){
        value = keep / value;
    }
    else if( toDo == '˜'){
        value = keep*keep;
    }
    else if( toDo=='!'){
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
        Calculator calc = new Calculator();
      
        Scanner sc = new Scanner(System.in);
        num1 = sc.nextDouble();
        double m1 = num1 ;

        Scanner sc3 = new Scanner(System.in);
        char op0 = sc3.next().charAt(0);

        Scanner sc2 = new Scanner(System.in);  
        num2 = sc2.nextDouble();
        double m2 = (double) num2 ;
       
    
        digit(m1);        
        binaryOperations(op0); 
        digit(m2);
        calc.compute();
        display(); 
        clear(); 
    }


    public void disclaimer(){
    System.out.println("Use the calculator for unlimited times and to terminat it, type 'exit'  in the space to enter numbers to terminate the calculator");
     this.CC++;
    }

public static void main(String[] args) {
    Calculator calc = new Calculator();
        try {
        calc.disclaimer();
        calc.compute2();
        calc.disclaimer();
        if(calc.CC==0){
        calc.disclaimer();
        calc.compute2();
        }
        else if(calc.CC>=1){
            calc.compute2();
        }
        } catch (InputMismatchException e) {
            System.err.println("Exited SuccessFully");
            System.exit(-9);
            return;
        }
        Calculator.main(args);//This is a recursive  method;
   }
   }


class CalculatorFrame {

    public void go(){
        CalculatorFrame cf = new CalculatorFrame();
         Frame f = new Frame();
         Button b;                    
         Panel bottom = new Panel();
         for(int i =0;i<=9;i++){
            b= new Button(Integer.toString(i));
            b.addActionListener(new CalcButtonAction());
            bottom.add("East",b);
         }
         b = new Button("=");
         bottom.add(b);
        f.add("South",bottom);
    }
}
class CalcButtonAction implements ActionListener{
    Calculator c = new Calculator();
    @Override
    public void actionPerformed(ActionEvent e){
      String s = e.getActionCommand();
      if(c.CC2==0){
      int i = Integer.parseInt(s);
      c.digit((double)i);
      }
      else if(c.CC2>=1){
        char ch = s.charAt(0);
        c.binaryOperations(ch);
      }else if(c.CC3>=1){
        int i = Integer.parseInt(s);
        c.digit(i);
        c.compute();
        c.display();
      }
    }
}
