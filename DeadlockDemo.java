public class DeadlockDemo {
    public static void main(String[] args) {
        final String resourceA = "Resource A";
        final String resourceB = "Resource B";

        // Thread 1 tries to lock A then B
        Thread t1 = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println("Thread 1: Locked " + resourceA);
                try { Thread.sleep(100); } catch (Exception e) {} // Force context switch

                System.out.println("Thread 1: Waiting for " + resourceB);
                synchronized (resourceB) {
                    System.out.println("Thread 1: Locked " + resourceB);
                }
            }
        });

        // Thread 2 tries to lock B then A
        Thread t2 = new Thread(() -> {
            synchronized (resourceB) {
                System.out.println("Thread 2: Locked " + resourceB);
                try { Thread.sleep(100); } catch (Exception e) {}

                System.out.println("Thread 2: Waiting for " + resourceA);
                synchronized (resourceA) {
                    System.out.println("Thread 2: Locked " + resourceA);
                }
            }
        });

        t1.start();
        t2.start();
    }
}