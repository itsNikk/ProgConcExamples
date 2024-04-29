package ClassiQuarte.BI.Sportello290424.Louvre;

public class Museum {
    private int capacity; //cap totale
    private int touristsInside; // quanti dentro

    public Museum(int capacity) {
        this.capacity = capacity;
        this.touristsInside = 0;
    }

    public synchronized void enter() throws InterruptedException {
        while (touristsInside >= capacity) wait();

        touristsInside++;
        System.out.println("Qualcuno è entrato. " +
                "Persone all'interno: " + touristsInside);
    }
}
