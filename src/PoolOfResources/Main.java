package PoolOfResources;

public class Main {
    //This little variations allow us to manage a pool of resources.
    // These resource have the same importance.
    public static void main(String[] args) {
        final int NUM_THREADS = 2;
        final int NUM_RESOURCES = 2;

        ResourceManager manager = new ResourceManager(NUM_RESOURCES);

        for (int i = 0; i < NUM_THREADS; i++)
            new ResourceThread("thread[" + i + "]", manager).start();
    }
}
