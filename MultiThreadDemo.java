class MessageDisplay implements Runnable {
    private String message;
    private int interval;

    public MessageDisplay(String message, int seconds) {
        this.message = message;
        this.interval = seconds * 1000; // Convert seconds to milliseconds
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(Thread.currentThread().getName() + ": " + message);
                // Pause the thread for the specified interval
                Thread.sleep(interval);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }
    }
}

public class MultiThreadDemo {
    public static void main(String[] args) {
        // Create the first task (BMSCE - every 10 seconds)
        Thread bmsThread = new Thread(new MessageDisplay("BMS College of Engineering", 10));
        bmsThread.setName("BMS-Thread");

        // Create the second task (CSE - every 2 seconds)
        Thread cseThread = new Thread(new MessageDisplay("CSE", 2));
        cseThread.setName("CSE-Thread");

        // Start both threads
        bmsThread.start();
        cseThread.start();
        
        System.out.println("Threads started. Press Ctrl+C to stop.");
    }
}
