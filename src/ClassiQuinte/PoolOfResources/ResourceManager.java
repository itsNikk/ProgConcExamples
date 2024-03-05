package ClassiQuinte.PoolOfResources;

public class ResourceManager {

    private final int NUM_RESOURCES;

    private boolean[] resources;

    private int available;

    public ResourceManager(int numResources) {
        NUM_RESOURCES = numResources;
        available = NUM_RESOURCES;
        resources = new boolean[NUM_RESOURCES];
        //PRO TIP: This specific for loop, or any that have this shape, can also be written as 'Arrays.fill(resources, true);'
        for (int i = 0; i < resources.length; i++) resources[i] = true;
    }

    public ResourceManager() {
        this(2);
    }


    public synchronized int request() throws InterruptedException {
        while (available <= 0) wait();
        int i = 0;
        while (i < NUM_RESOURCES && !resources[i]) i++;
        resources[i] = false;
        available--;
        System.out.println("Allocating resource " + i);
        return i;
    }

    public synchronized void release(int i) {
        System.out.println("Releasing resource " + i);
        resources[i] = true;
        available++;
        notify();
    }
}
