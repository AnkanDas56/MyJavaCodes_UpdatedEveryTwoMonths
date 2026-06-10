import java.util.*;

public class Time {
    static Time tm = new Time();
    private int hour;
    private int minute;
    private String AP;

    public void setAP(String x) {
        this.AP = x;
    }

    public String getAP() {
        return this.AP;
    }

    public void setHour(int x) {
        this.hour = x;
    }

    public void setMinute(int y) {
        this.minute = y;
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public Time AMorPM() {
        Time t = new Time();

        Scanner sc = new Scanner(System.in);
        String DorN = sc.nextLine();

        if (DorN == "Day" & t.getHour() < 5 | t.getHour() == 12 || DorN == "Night" & t.getHour() >= 6 & t.getHour() < 12) {
            t.setAP("PM");

        } else if (DorN == "Night" & t.getHour() < 5 || DorN == "Day" & t.getHour() >= 5) {
            t.setAP("AM");

        } else if (DorN == "Day" & t.getHour() < 12 & t.getHour() >= 5) {
            t.setAP("AM");
        }
        return t;
    }

    public static void main(String[] args) {
        Time t0 = tm.AMorPM();
        t0.setHour(3);
        t0.setMinute(35);

        System.out.print("the time is, " + t0.getHour() + " : " + t0.getMinute() + t0.AP);
    }
}