public class Producer extends Thread {
    private final Storage storage;
    private final int id;
    private final int plan;

    public Producer(Storage storage, int id, int plan) {
        this.storage = storage;
        this.id = id;
        this.plan = plan;
    }

    public void run() {
        int complete = 0;
        while (complete < plan) {
            storage.addItem(id);
            complete++;
        }
    }
}
