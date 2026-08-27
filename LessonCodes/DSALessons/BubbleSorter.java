package DSALessons;

public class BubbleSorter {
    public static void main(String[] args){
      BubbleSorter sorter = new BubbleSorter();
      int[] a = {32,34,25,64,2,5,454,24,6,2};
      sorter.sort(a);
    }
    protected void sort(int[] a){
     int x = 0;
     int y = a.length-1;

     while(x<=y){
         int i = 0;
      while(i<=y){
          if((i+1)<a.length&&a[i]>a[i+1]){
              int temp = a[i];
              a[i] = a[i+1];
              a[i+1] = temp;

          }
          i++;
      }
         x++;
     }

    }
}
