package ClassiQuarte.AI.ThreadChain;

import ClassiQuarte.BI.Daemon.MyDaemonThread;

import javax.swing.*;

public class ChainThread extends Thread {

    private final ChainThread previousThread;

    public ChainThread(String name, ChainThread previousThread) {
        super(name);
        this.previousThread = previousThread;
    }

    @Override
    public void run() {
        try {
            if (previousThread != null) previousThread.join();
            //V1: System.out.println(getName());
            /*
            V2:
             */
            System.out.println(getName());
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrotto.");
        }
    }
}
