import java.awt.event.*;
import java.awt.*;
import java.lang.classfile.instruction.ThrowInstruction;
import javax.swing.*;
import java.util.*;

public class Calculator{
    public double value=0 , keep=0 ;
    public char toDo ;
    public int CC=0 ;
    public int CC2=0;
    public double CC3=0; 
    int CC4;
    public void binaryOperations(char op){
        this.keep = this.value;
        this.value = 0;
        this.toDo=op;
        this.CC3++;
        this.CC2++;
    }
    public void decimalPoint(){
        this.CC4++;
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
    public void clear(){
        this.value = 0;
        this.keep = 0;
        System.out.println("Cleared and restarting the calculator.");
    }
    public void digit(double x){
        if(this.CC4==0){
        this.value = (this.value*10)+x;
        }else if(this.CC4>0){
            double digitAfterPoint = Math.pow(10,this.CC4);
            double numsAfterPoint = x/digitAfterPoint;
            this.value = this.value+numsAfterPoint;
            this.CC4++;
        }
    }

    public void compute(){
    if (this.toDo == '+'){
        this.value = this.keep + this.value;
    }
    else if (this.toDo == '-'){
        this.value = this.keep - this.value;
    }
    else if (this.toDo == '*'){
        this.value = this.keep * this.value; 
    }
    else if (this.toDo == '/'){
        this.value = this.keep / this.value;
    }
    else if( this.toDo == '˜'){
        this.value = this.keep*this.keep;
    }
    else if( this.toDo=='c'){
        this.clear();
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
        double m2 = sc2.nextDouble();
       
    
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
        JTextArea jta = new JTextArea(3,50);
     
        public void go(){
          //The components
          JFrame f = new JFrame();
          JButton b;                    
          JPanel bottom = new JPanel();
          this.jta.setEditable(true);
          this.jta.setText("click on a button to get started."+"\n"+" press C to clear");

          //The Listeners
          CalcOpButtonListener cobl = new CalcOpButtonListener(this);
          CalcNumButtonListener cnbl = new CalcNumButtonListener(this,cobl);

          //the upcoming methods :-
          GridLayout mgr = new GridLayout(4,5);
          bottom.setLayout(mgr);
          for(int i =9;i>=0;i--){
            b= new JButton(Integer.toString(i));b.setActionCommand(Integer.toString(i));
            b.addActionListener(cnbl);
            bottom.add(b);
          }
          b= new JButton("C");b.setActionCommand("C");b.addActionListener(cobl);bottom.add(b);
          b= new JButton("=");b.setActionCommand("=");b.addActionListener(cobl);bottom.add(b);
          b= new JButton("+");b.setActionCommand("+");b.addActionListener(cobl);bottom.add(b);
          b= new JButton("-");b.setActionCommand("-");b.addActionListener(cobl);bottom.add(b);
          b= new JButton("*");b.setActionCommand("*");b.addActionListener(cobl);bottom.add(b);
          b= new JButton("/");b.setActionCommand("/");b.addActionListener(cobl);bottom.add(b);
          b= new JButton("e");b.setActionCommand("e");b.addActionListener(cobl);bottom.add(b);
          b= new JButton(".");b.setActionCommand(".");b.addActionListener(cobl);bottom.add(b);
          b = new JButton("Sq");b.setActionCommand("˜");b.addActionListener(cobl);bottom.add(b);
         bottom.setSize(295,285);
         bottom.setBackground(Color.BLACK);
         f.setBackground(Color.DARK_GRAY);
         f.add("South",bottom);
         f.add(this.jta);
         f.setSize(295, 450);
         this.jta.setEditable(true);
         Font font = new Font(Font.SANS_SERIF,20,18);
         this.jta.setFont(font);
         this.jta.setForeground(Color.WHITE);
         this.jta.setBackground(Color.BLACK);
         f.setVisible(true);
    }
    @Override
    public double display(){
    if (this.CC4==0){
          int i = (int) this.value;
    System.out.println(i);
    }else if(this.CC4>0){
        System.out.println(this.value);
    }
    this.jta.setText(null);
    this.jta.setText(Double.toString(this.value));
    return this.value;
    }
    @Override 
    public void clear(){
        this.value = 0;
        this.keep =0;
        this.CC4 = 0;
        this.jta.setText(null);
    }
}

//the Action Listener for all the number buttons in the CalculatorFrame
class CalcNumButtonListener implements ActionListener{
    CalculatorFrame c ;
    CalcOpButtonListener cobl;
    public CalcNumButtonListener(CalculatorFrame c, CalcOpButtonListener opl){
    this.c = c;
    this.cobl = opl;
    }
    @Override
    public void actionPerformed(ActionEvent e){
      String s = e.getActionCommand();
      Double i ;
      if (this.cobl.alreadyOnOperation&&this.c.toDo=='-'){
        i = Double.valueOf(s);
       this.c.digit(i*-1);
       this.c.display();
      } else{
         i = Double.valueOf(s);
         this.c.digit(i);
         this.c.display();
      }
}
}
class CalcOpButtonListener implements ActionListener{
    CalculatorFrame c;
    protected boolean alreadyOnOperation = false;
    public CalcOpButtonListener (CalculatorFrame calc){
    this.c = calc;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        char ch = e.getActionCommand().charAt(0);
        System.out.println(ch);
    if(ch=='+'){
        this.c.add();
        alreadyOnOperation = true;
      }else if(ch=='*'){
       this.c.multiply();
        alreadyOnOperation = true;
      }else if(ch=='/'){
       this.c.divide();
       alreadyOnOperation = true;
        
      }else if(ch=='˜'){
        this.c.squareOf();
        this.alreadyOnOperation = true;
        
      }else if(ch=='-'){
      this.c.subtract();
      }else if(ch=='.'){
        this.c.decimalPoint();
      }
      else if(ch=='e'){
        this.alreadyOnOperation = false;
        this.c.exit();
        System.exit(0);
      }
      else if(ch=='='){
        this.c.compute();
        this.c.display();
        this.c.toDo = 0;
        this.alreadyOnOperation = false;
      }
      else if (ch=='C'){
      
      this.c.clear();
      this.alreadyOnOperation = false;
      }
      if(ch!='='){
      this.c.jta.setText(null);
      this.c.jta.setText(Character.toString(ch));
    }
}
}