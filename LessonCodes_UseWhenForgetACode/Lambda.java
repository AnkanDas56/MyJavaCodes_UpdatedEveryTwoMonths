interface A{
    public void show();    
}
class Lambda{
public static void main(String[] args){
    A a = ()-> {
       return; 
    };
    a.show();
}
}
