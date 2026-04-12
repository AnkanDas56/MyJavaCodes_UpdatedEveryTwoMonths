import com.sun.net.httpserver.Headers;
import static java.lang.System.*;
public  class LinkedLst{
 private Node head;
  static class Node{
   Node next;
   Object data;
   Node prev;
 
  Node(Object data) {
  this.data = data;
  this.next = null;
  }
 }

  void addFirst(Node newNode){
    if(this.head== null){
      this.head = newNode;
    }else if(this.head!=null){
    newNode.next = this.head;
    newNode.next.prev = newNode;
    this.head = newNode;
    newNode = this.head;
    }
    
   }

   void addLast(Node newNode){
   newNode.next = null;
   Node currNode = this.head;
   while(currNode.next != null){
    currNode = currNode.next;
   }
   currNode.next = newNode;
   newNode.prev = currNode;
   }

  public void printList(){
   Node currNode = this.head;
 while(currNode != null){
  if(currNode.next == null){
    out.print(currNode.data);
    break;
  }
  out.print(currNode.data+" -> ");
    currNode = currNode.next;
   }
   }
   
   public void remove(){
   Node newNode = this.head.next;
   this.head = null;
   this.head = newNode;
   }
   
   public void push(Object item){
    Node newNode = new Node(item);
    this.addFirst(newNode);
   }

   public void pop(){
    this.remove();
   }
   
  public static void main(String[] args) {
      LinkedLst ll = new LinkedLst();
      ll.push("Holla");
      ll.push(256);
      ll.push("james");
    while(ll.head!= null){
      ll.printList();
      out.println();
      if(ll.head.next.next == null){
        out.print(ll.head.prev.next.data);        
        break;
      }
      ll.remove();


  }
   }
  }