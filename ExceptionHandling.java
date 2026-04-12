


public class ExceptionHandling extends Exception{
public ExceptionHandling(){
    
System.out.println("An OOPject is made ,got my joke?");
}
    public static void ThrowMethod()throws ExceptionHandling{
            throw new ExceptionHandling();

    }
    public static void main(String[] args) {
        int a = 6;
        int b = 0;
        
        
        try{
        if (b == 0){ 
            throw new ArithmeticException();
         }
         }
      catch (Exception e) {
            System.out.println("error");
            e.getMessage();
        }
        try {
            System.out.println("Exception is thrown");  
            ThrowMethod();          
        } catch (ExceptionHandling ExcHan) {
        System.out.println("Exception caught");
        ExcHan.getMessage();
        }
        finally {
            System.out.println("Finally block executed");
        }
    }
}


