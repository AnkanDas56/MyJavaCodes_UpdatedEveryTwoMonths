import java.awt.event.*;
import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Calculator{
    static Calculator c = new Calculator();
    public int callcount=0;
    public static double value , keep ;
    public double  num1 , num2;
    public static char toDo ;
    public void binaryOperations(char op){
        keep = value;
        value = 0 ;
        this.toDo=op;
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
    public static void digit(double x){
        value = value+x;
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
    return;
    }
}
    public static double display(){
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

    public static void compute2(int m1, int m2,char op0){
        Calculator calc = new Calculator();
        digit(m1);        
        binaryOperations(op0); 
        digit(m2);
        calc.compute();
        display(); 
        clear(); 
    }

    public void disclaimer(){
    System.out.println("Use the calculator for unlimited times and to terminat it, type 'exit'  in the space to enter numbers to terminate the calculator");
    this.callcount++;
    }

public static void main(String[] args) {
    Calculator calc = new Calculator();
    if(c.callcount==0){
        try {
        c.disclaimer();
        compute2();
        disclaimer();
        calc.compute2();
            
        } catch (InputMismatchException e) {
            System.err.println("Exited SuccessFully");
            System.exit(-9);
            return;
        }
   }
   else if (c.callcount>=1) {
           try {
        compute2();
            
        } catch (InputMismatchException e) {
            System.err.println("Exited SuccessFully");
            System.exit(-9);
            return;
        }
   }
        Calculator.main(args);//This is a recursive  method;

}
}

class CalculatorFrame implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      String s = e.getActionCommand();
      
    }
}
