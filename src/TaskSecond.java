public class TaskSecond {

    private static int number = 0;
    private static final StringBuilder result = new StringBuilder();

    private static void stringPrinter(int n) {

        for (int i = 0; i < n; i++) {

            number++;

            Thread threadA = new Thread(() -> {
                if (number % 3 == 0 && number % 5 != 0) {
                    result.append("fizz, ");
                }
            });
            threadA.start();
            threadA.interrupt();

            Thread threadB = new Thread(() -> {
                if (number % 5 == 0 && number % 3 != 0) {
                    result.append("buzz, ");
                }
            });
            threadB.start();
            try {
                threadB.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadB.interrupt();

            Thread threadC = new Thread(() -> {
                if (number % 15 == 0) {
                    result.append("fizzbuzz, ");
                }
            });
            threadC.start();
            try {
                threadC.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadC.interrupt();

            Thread threadD = new Thread(() -> {
                if (number % 3 != 0 && number % 5 != 0) {
                    result.append(number).append(", ");
                }
            });
            threadD.start();
            try {
                threadD.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadD.interrupt();
        }

        System.out.println(result.substring(0, result.length() - 2));
    }

    public static void main(String[] args) {
        int n = 15;
        stringPrinter(n);
    }
}