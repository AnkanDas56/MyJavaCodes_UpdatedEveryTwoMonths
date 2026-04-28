import com.sun.net.httpserver.Headers;
import static java.lang.System.*;
public  class LinkedLst<Whatever extends Object>{
  @Override
  public String toString(){
  StringBuilder s= new StringBuilder("[");
  Node currNode = this.head;
  String str ;
  while(currNode.next!=null){
    s.append(currNode.toString());
    s.append(" ");
    if(currNode.next.next==null){
      s.append(currNode.next);
    }
    currNode = currNode.next;
  }
  s.append("]");
  str = s.toString();
  return str;

  }
 private Node head;

 //the node class
  class Node{
   Node next;
   Whatever data;
   Node prev;
   @Override
   public String toString(){
    return this.data.toString();
   }
  Node(Whatever data) {
  this.data = data;
  this.next = null;
  this.prev = null;
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
    Object obj = (Object)currNode.data;
    out.print(obj);
    break;
  }
  out.print(currNode.data+" ");
    currNode = currNode.next;
   }
   }
   
   public void removeFirst(){
  Node temp = this.head;
   Node newNode = this.head.next;
   this.head = null;
   temp = null;
   this.head = newNode;
   }
   public void removeLast(){
    Node LastNode=this.head;
    while(LastNode.next!=null){
      LastNode = LastNode.next;
    }
    LastNode = LastNode.prev;
    LastNode.next = null;
   }
   
   public void push(Whatever item){
    Node newNode = new Node(item);
    this.addFirst(newNode);
   }
   public void push(Whatever item,int index){
    Node newNode = new Node(item);
    this.addAtIndex(newNode, index);
   }
   public Node pop(){
    Node reNode = this.head;
    this.removeFirst();
    return reNode;
   }
   
  public static void main(String[] args) {
      LinkedLst<Object> ll = new LinkedLst<>();
      ll.push("Holla");
      ll.push(256);
      ll.push("james");
      ll.push("What are you Looking at here man?",1);
      System.out.println(ll);
      ll.removeLast();
      System.out.println(ll);
      
   }
}
  