import java.util.Scanner;
public class Calculator{
    public static double value , keep ;
    public static double  num1 , num2;
public static char toDo ;
    public static void binaryOperations(char op){
        keep = value;
        value = 0 ;
        toDo = op ;
    }
    public static void add (){
        binaryOperations('+');
    }
    public static void subtract(){
        binaryOperations('-');
    }
    public static void multiply(){
        binaryOperations('*');
    }
    public static void divide(){
        binaryOperations('/');
    }
    public static void squareOf(){
      binaryOperations('˜');
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
}
    public static double display(){
        System.out.println( value);
        return value;
    }
    public static void compute2(){
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
    public static void disclaimer(){
    System.out.println("Use the calculator for unlimited times and to terminat it, type 'exit'  in the space to enter numbers to terminate the calculator");
    }

public static void main(String[] args) {
        disclaimer();
        
        compute2();
       
   Calculator.main(args);
   }
}



