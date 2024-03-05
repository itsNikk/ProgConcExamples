package ClassiQuarte.AI.StampaATurno;

public class PrinterThread extends Thread {

    public PrinterThread(String name) {
        setName(name);
        //super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName());
            try {
                sleep(200);
            } catch (InterruptedException a) {
                break;
            }
        }
        System.out.println(getName() + " ho finito.");
    }
}
