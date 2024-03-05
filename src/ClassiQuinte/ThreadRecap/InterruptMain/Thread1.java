package ClassiQuinte.ThreadRecap.InterruptMain;

public class Thread1 extends Thread {

    private int valore;

    public Thread1(String name) {
        super(name);
        this.valore = 1;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(getName() + " " + valore++);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrotto.");
                break;
            }
        }
    }
}
