package LavoriamoCon_Daemon;

import java.security.PublicKey;

public class MyDaemonThread extends Thread {

    public MyDaemonThread(String name) {
        //chiama il costruttore di Thread (padre) che prende una stringa e setta il nome del thread.
        super(name);


        //modifica questa chiamata per variare il comportamento del programma... ;)
        setDaemon(true);

        System.out.println(this);
    }

    @Override
    public void run() {
        int counter = 0;
        while (true) {
            System.out.println(getName() + ": " + counter++);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
