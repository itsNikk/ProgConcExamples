package ClassiQuarte.BI.Daemon;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyDaemonThread daemonThread = new MyDaemonThread("My Deamon");

        daemonThread.start();
        Thread.sleep(7500);
        System.out.println("Main chiude");
    }
}
