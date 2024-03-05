package ClassiQuinte.LavoriamoCon_Daemon.JoinExample;

public class ThreadSleep extends Thread {

    public ThreadSleep(String nome) {
        super(nome);
        //setName(nome);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(getName() + ": in esecuzione");
            try {
                sleep(200);
            } catch (InterruptedException e) {
                System.out.println(getName() + " è stato interrotto");
            }
        }
        System.out.println(getName() + " ho finito.");
    }
}
