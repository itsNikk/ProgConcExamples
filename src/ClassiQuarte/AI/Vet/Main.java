package ClassiQuarte.AI.Vet;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        VetOffice vetOffice = new VetOffice();

        final int NUM_ANIMALS = 20;
        ArrayList<Thread> animals = new ArrayList<>();

        for (int i = 0; i < NUM_ANIMALS; i++) animals.add(new Animal(vetOffice));

        for (Thread thread : animals) thread.start();
        for (Thread animal : animals) animal.join();

        System.out.println("Il veterinario chiude");
    }

}
