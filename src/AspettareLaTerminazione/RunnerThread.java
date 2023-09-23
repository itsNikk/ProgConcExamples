package AspettareLaTerminazione;

public class RunnerThread extends Thread {
    public RunnerThread(String name) {
        setName(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(getName() + " sta eseguendo");
            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(getName() + " HA FINITO");
    }
}
