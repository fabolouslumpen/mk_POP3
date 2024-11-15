import java.util.concurrent.Semaphore;

public class Storage {
    private int items;
    private final Semaphore full;
    private final Semaphore empty;
    private final Semaphore access;

    public Storage(int size) {
        this.items = 0;
        full = new Semaphore(0);
        empty = new Semaphore(size);
        access = new Semaphore(1);
    }

    public void addItem(int id) {
        empty.acquireUninterruptibly();
        System.out.println("Producer: " + id + " near the storage");
        access.acquireUninterruptibly();
        System.out.println("Producer: " + id + " in the storage");

        items ++;
        System.out.println("Producer: " + id + " add item! amount: " + items);

        full.release();
        System.out.println("Producer: " + id + " out the storage");
        access.release();
    }

    public void getItem(int id) {
        full.acquireUninterruptibly();
        System.out.println("Consumer: " + id + " near the storage");
        access.acquireUninterruptibly();
        System.out.println("Consumer: " + id + " in the storage");

        items--;
        System.out.println("Consumer: " + id + " get item! remained: " + items);

        empty.release();
        System.out.println("Consumer: " + id + " out the storage");
        access.release();
    }

}
