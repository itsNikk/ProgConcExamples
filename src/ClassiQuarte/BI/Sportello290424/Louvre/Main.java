package ClassiQuarte.BI.Sportello290424.Louvre;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Museum museum = new Museum(5);
        final int NUM_THREADS = 50;

        ArrayList<Tourist> tourists = new ArrayList<>();
        for (int i = 0; i < NUM_THREADS; i++) {
            tourists.add(new Tourist("Tourist#" + (i + 1), museum));
        }

        //Faccio partire tutti i Threads
        for (int i = 0; i < tourists.size(); i++) {
            tourists.get(i).start();
        }

        //Io main aspetto tutti i thread
        for (int i = 0; i < tourists.size(); i++) {
            tourists.get(i).join();
        }

        System.out.println("Museo chiude");
    }
}
