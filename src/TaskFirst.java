public class TaskFirst {
    private static int counter = 1;

    public static void main(String[] args) {
        Runnable oneSecond = () -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(counter + " seconds passed since start");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter++;
            }
        };

        Runnable fiveSeconds = () -> {
            while (!Thread.currentThread().isInterrupted()) {
                if (counter % 5 == 0) {
                    System.out.println("5 seconds have passed");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread thread0 = new Thread(oneSecond);
        Thread thread1 = new Thread(fiveSeconds);
        thread0.start();
        thread1.start();
    }
}