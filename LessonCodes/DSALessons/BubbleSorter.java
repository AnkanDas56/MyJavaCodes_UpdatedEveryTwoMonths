package DSALessons;

import java.io.*;

public class BubbleSorter {
    public static void main(String[] args)  {
      BubbleSorter sorter = new BubbleSorter();
      int[] a = {32,34,25,64,2,5,454,24,6,-1,-265,-3,0};
      a = sorter.sort(a);
      try{
          InputStream os = new FileInputStream("../../output.txt");
      } catch (FileNotFoundException e) {
          System.out.println("Sorry! sir, couldn't find the file :( recheck the code");
      }

    }
    protected int[] sort(int[] a){
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
     return a;
    }
    protected void printArray(int[] a){
        var x = 0;
        while(x<a.length){
            System.out.println(a[x]);
            x++;
        }
    }
}
