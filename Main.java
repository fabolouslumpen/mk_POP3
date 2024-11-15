public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage(3);

        int producerNum = 3;
        int consumerNum = 2;

        int[] producerPlan = {2,3,5};
        int[] consumerPlan = {5,5};

        for (int i = 0; i < producerNum; i++) {
            new Producer(storage, i + 1, producerPlan[i]).start();
        }

        for (int i = 0; i < consumerNum; i++) {
            new Consumer(storage, i + 1, consumerPlan[i]).start();
        }
    }
}