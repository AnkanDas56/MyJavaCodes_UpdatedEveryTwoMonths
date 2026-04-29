interface In {
public void toBeImplemented();
public void ForYou();
}
public class AnonymousClass {
public static void main(String[] args) {
    In i = new In(){
    @Override
    public void toBeImplemented(){
      System.out.println("In toBeImplemented");     
    }
    @Override
    public void ForYou(){
      System.out.println("In ForYou");     
    }
    };
    i.toBeImplemented();
    i.ForYou();
}
}
