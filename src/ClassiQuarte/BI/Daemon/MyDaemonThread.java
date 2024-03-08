package ClassiQuarte.BI.Daemon;

public class MyDaemonThread extends Thread {

    public MyDaemonThread(String s) {
        //setName(s); = super(s);
        super(s);
        //setDaemon(true);
    }

    @Override
    public void run() {
        int counter = 0;
        while (true) {
            System.out.println(getName() + ": " + (counter++));
            try {
                sleep(3500);
            } catch (InterruptedException e) {
            }
        }
    }

}
