package ClassiQuinte.ThreadRecap.InterruptMain;

public class Thread3 extends Thread {

    private int valore;

    public Thread3(String name) {
        super(name);
        this.valore = 1000;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(getName() + " " + valore--);
            try {
                sleep(200);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrotto");
                break;
            }
        }
    }
}
