class PTest{
  public static void main(String[] args) {
     var one = new Person("Joseph",25, 12987421);//we can use var for any type 
     Person two = new Person("Ankan",12,14578945);
     Person three = new Person("Joseph",25,12987421);
     Person[] p = new Person[3];
     p[0] = one;
     p[1] = two;
     p[2] = three;
     System.out.println(one.equals(three));
     int i = 0;
     while(i!=3){
       System.out.println(p[i]);
       i++;
     }
   }
}
record Person(String name, int age, long ctznID){ 
@Override
public boolean equals(Object other){
  boolean b = this.hashCode()==other.hashCode()&& other instanceof Person;
  boolean b2 = false;
  if(other instanceof Person){
    Person temp = (Person) other;
    b2 = this.ctznID()==temp.ctznID()&&this.age()==temp.age()&&this.name()==temp.name();
  }
  return b&&b2;
}
}