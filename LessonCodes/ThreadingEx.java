public class ThreadingEx {
    public static void main(String[] args) {
        Runnable t = new Runnable() {
            public void run() {
                System.out.println("helloworld ");
                System.exit(0);
            }
        };
        Thread th = new Thread(t);
        th.start();
    }
}
