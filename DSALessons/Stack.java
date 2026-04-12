import java.util.*;
import static java.lang.System.*;

public class Stack<E extends Object>{
public E stackList;


public  <T extends Stack>void push(E item){
  Stack s = new Stack<>();
  Stack t = new ListStack();
  Stack n = new LinkedStack();
  if (this.getClass()==s.getClass() | this.getClass()==t.getClass() | this.getClass()==n.getClass()){
  this.push(item);
}
}

public E peek(){
   Stack s = new Stack<>();
  Stack t = new ListStack();
  Stack n = new LinkedStack();

  E e;
  if (this.getClass()==s.getClass() | this.getClass()==t.getClass() | this.getClass()==n.getClass()){
  e = this.peek();
  }else {
   e = null;
  }
return e;
}


public E peek(int index){
     Stack s = new Stack<>();
  Stack t = new ListStack();
  Stack n = new LinkedStack();

  E e;
  if (this.getClass()==s.getClass() | this.getClass()==t.getClass() | this.getClass()==n.getClass()){
  e = this.peek(index);
  }else {
   e = null;
  }
  return e;
}


public void push(E item, int index){
     Stack s = new Stack<>();
  Stack t = new ListStack();
  Stack n = new LinkedStack();

  if (this.getClass()==s.getClass() | this.getClass()==t.getClass() | this.getClass()==n.getClass()){
   this.push(item, index);
}
}

public E pop (){
  return this.pop();
}

public boolean isEmpty(){
    return this.isEmpty();
}

public static void main(String[] args){

  @SuppressWarnings("unchecked")     
  Stack<String> ls = new ListStack<>();
  out.println("In ListStack of type String:");
  ls.push("hello");
  ls.push("Apple");
  ls.push("BlueBerry");
  ls.push("Grape");
  ls.push("Watermelon",0);
  ls.push("Cranberry");
  ls.push("Blackberry");
  System.out.println(ls.peek());
  ls.complete();
  
  @SuppressWarnings("unchecked")     
  Stack<Object> lls = new LinkedStack();
  lls.push(24);
  lls.push(256);
  lls.push("Hello , Guys");

  lls.complete();
}

  public void complete() {
   this.complete();
  }

}



class ListStack<E> extends Stack {
public List<Object> stackList = new ArrayList<>();


    @Override
    public void push(Object item){
      this.stackList.add(0,item);
    }
 
    @Override
    public void push(Object item, int index){
      Object o = item;
      this.stackList.add(index, item);         
    }
    public void pop(int index){
      this.stackList.remove(index);         
    } 
@Override
    public Object pop(){
      return this.stackList.removeFirst();
    }
@Override
    public Object peek(int index){
     return this.stackList.get(index);      
    }
@Override
    public Object peek(){
     return this.stackList.getFirst();
    } 
@Override
    public boolean isEmpty(){
     return this.stackList.isEmpty();       
    }
@Override
 public void complete() {
    out.println(this.stackList);
 }
}


class LinkedStack extends Stack{
  Node head;
  LinkedStack stackList;

  class Node{
   Node next;
   Object data;
 
  public Node(Object data) {
  this.data = data;
  this.next = null;
  }
 }

  void addFirst(Node newNode){
    newNode.next = this.head;
    this.head = newNode;
    
   }

   void addLast(Node newNode){
   newNode.next = null;
   Node currNode = this.head;
   while(currNode.next != null){
    currNode = currNode.next;
   }
   currNode.next = newNode;
   }


   void printList(){
   Node currNode = this.head;
   while(currNode != null){
    out.print(currNode.data+" ");
    currNode = currNode.next;
   }
   }
   
   public void remove(){
   this.head = null;
   this.head = this.head.next;
   }
   //The Inherited methods for a Complete stack
   @Override 
   public void push(Object item){
    this.addFirst(new Node(item));
   }

  @Override
   public Object pop(){
    this.remove();
    return this.head;
   }
   
  @Override
   public void complete(){
   this.printList();
   }

  }
