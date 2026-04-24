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
 }}

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
   newNode = currNode.next;
   newNode.prev = currNode;
   }

  void addAtIndex(Node newNode, int index){
   Node currNode = this.head;
   int i = 0;
   int tar = index-1;
   if(tar==-1){
    Node temp1 = this.head;
    this.head = newNode;
    this.head.next = temp1;
    temp1.prev = newNode;
   }else if (tar!=1){
   while(i!=tar){
    currNode = currNode.next;
    i++;
   }
   Node temp = currNode.next;
   currNode.next = newNode;
   newNode.prev = currNode;
   newNode.next = temp;
   temp.prev = newNode;
   }
  }       

  public void printList(){
   Node currNode = this.head;
 while(currNode != null){
  if(currNode.next == null){
    out.print(currNode.data);
    break;
  }
  out.print(currNode.data+" ");
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
      ll.addAtIndex(new Node(2),1);
      ll.printList();


  }
   }
  