package ClassiQuinte.LavoriamoCon_Daemon;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyDaemonThread t = new MyDaemonThread("My Daemon");
        t.start();

        Thread.sleep(2000);
        System.out.println("chiudo");
    }
}
