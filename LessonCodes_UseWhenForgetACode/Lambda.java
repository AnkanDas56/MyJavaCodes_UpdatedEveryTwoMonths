interface A{
    public void show();    
    public void s2();
}
class Lambda{
public static void main(String[] args){
    A a = new A(){
     public void s2(){
    System.out.println("s1");
     }
     public void show(){
     System.out.println("show");
     }
    };
    a.show();

}
}
