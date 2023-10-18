package PoolOfResources;

public class ResourceThread extends Thread {

    private final int TIMES = 2;
    private ResourceManager manager;

    public ResourceThread(String name, ResourceManager manager) {
        super(name);
        this.manager = manager;
    }


    @Override
    public void run() {
        for (int i = 0; i < TIMES; i++) {
            try {
                int resource = manager.request();
                sleep((long) (Math.random() * 1000));
                manager.release(resource);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrupted");
                //maybe we could do something useful here this time...
            }
        }
    }
}
