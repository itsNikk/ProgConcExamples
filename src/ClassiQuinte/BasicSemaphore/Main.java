package ClassiQuinte.BasicSemaphore;

import java.util.ArrayList;

public class Main {

    private static final int NUM_ADDER_THREADS = 3;
    private static final int NUM_SUBTRACT_THREADS = 2;
    private static final int NUM_MULTIPLIER_THREADS = 1;

    public static void main(String[] args) throws InterruptedException {
        SharedResource resource = new SharedResource();

        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < NUM_ADDER_THREADS; i++) {
            threads.add(
                    new AdderThread("AdderThread " + (i + 1), resource));
        }

        for (int i = 0; i < NUM_SUBTRACT_THREADS; i++) {
            threads.add(
                    new SubtracterThread("SubtractThread" + (i + 1), resource));
        }

        for (int i = 0; i < NUM_MULTIPLIER_THREADS; i++) {
            threads.add(new MultiplierThread("MultiplierThread" + (i + 1), resource));
        }


        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();

        System.out.println(resource.GetCounter());
    }
}
