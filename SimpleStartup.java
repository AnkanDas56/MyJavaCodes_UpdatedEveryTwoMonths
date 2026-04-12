import java.util.* ;
import static java.lang.System.out;
 class SimpleStartupTestDrive{
    public static void main(String[] args){
       
       System.out.println("Enter a number between 1 to 10 to sink the startups on the virtual 1*10 grid");
       System.out.println("Don't enter a number repeated even if you do, you will fail");

        SimpleStartup s = new SimpleStartup();
        int rn = (int) (Math.random()*10);
        int[] locations = {rn,rn+1,rn+2};
        s.setLocationCells(locations);

        Scanner s1 = new Scanner(System.in);
        int g1 = s1.nextInt();
        s.checkYourself(g1);

        Scanner s2 = new Scanner(System.in);
        int g2 = s2.nextInt();
        s.checkYourself1(g2);

        Scanner s3 = new Scanner(System.in);
        int g3 = s3.nextInt(); 
        s.checkYourself2(g3);
        if(s.numOfHits==s.locationCells.length){
            System.out.println("Kill complete pass.   You get full points");
        }else if(s.numOfHits == 0){
            out.println("Only 0 , you will get nothing");
        }
        else if(s.numOfHits > 0 & s.numOfHits < s.locationCells.length){
            System.out.println("only "+s.numOfHits+" hits, you will get half point");
        }
    }
}
 public class SimpleStartup{

    static int numOfHits;

    public static int[] locationCells;

    public static String checkYourself(int guess){
     String result = "miss"; 

        String result2;
        result2 = "Fail";
        
        if(guess==locationCells[0]){
            result = "hit";
            result2 = "pass";
            System.out.println(result+" "+result2);
            int r1 = (int) (Math.random() * 1000);
            locationCells[0] = r1 ;
            numOfHits++;
            return result2;
        }else if(guess==locationCells[1]){ 
            result = "hit";
            result2 = "pass";
            System.out.println(result+" "+result2);
            int r2 = (int) (Math.random() * 1000);
            locationCells[1] = r2 ;
            numOfHits++;
            return result2;
        }
        else if(guess == locationCells[2]){
       result = "hit";
       result2 = "pass";
       System.out.println(result+" "+result2);
       int r3 = (int) (Math.random() * 10);
       locationCells[2]= r3 ;
       numOfHits++;
       return result2;
        }else{
            System.out.println(result+" "+result2);
        }
        return result2;
        }
        

    public static String checkYourself1(int guess1){
     String result = "miss"; 
        String result2;
        
        result2 = "Fail";
        if(guess1==locationCells[0]){
            result = "hit";
            result2 = "pass";
            System.out.println(result+" "+result2);
            int r = (int) (Math.random() * 10);
            locationCells[0] = r ;
            numOfHits++;
            return result2;
        }else if(guess1 == locationCells[1]){
            result = "hit";
            result2 = "pass"; 
            System.out.println(result+" "+result2);
            locationCells[1] = 172 ;
            numOfHits++;
        }else if(guess1 == locationCells[2]){
            result = "hit";
            result2 = "pass";
            System.out.println(result+" "+result2); 
            int r5 = (int) (Math.random()*10);
            locationCells[2] = r5 ;
            numOfHits++;
            return result2;
        }else{
            System.out.println(result+" "+result2);
        }
     return result2;
    }

    public static String checkYourself2(int guess2){
     String result = "miss"; 
        String result2;
        
        result2 = "Fail";
        if(guess2==locationCells[0]){
            result = "hit";
            result2 = "pass";
            System.out.println(result+" "+result2);
            locationCells[0] = -512 ;
            numOfHits++;
            return result2;   
        }else if(guess2 == locationCells[1]){
            result = "hit";
            result2 = "pass";   
            System.out.println(result+" "+result2);
            locationCells[1] = -10; 
            numOfHits++;
        }else if(guess2==locationCells[2]){
            result = "hit";
            result2 = "pass";
            System.out.println(result+" "+result2);
            locationCells[2] = 0 ;
            numOfHits++;
            return result2;
        }else{
            System.out.println(result+" "+result2);
        }
        
     return result2;
    }
    public static int[] setLocationCells(int[] cellLocations){
        locationCells =  cellLocations;
        return locationCells;
    }
    }