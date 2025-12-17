import java.io.*;

public class IPCDemo {
    public static void main(String[] args) throws IOException {
        final PipedOutputStream output = new PipedOutputStream();
        final PipedInputStream input = new PipedInputStream(output);

        // Thread 1: The Sender (Producer)
        Thread thread1 = new Thread(() -> {
            try {
                output.write("Hello from Process A!".getBytes());
                output.close();
            } catch (IOException e) { e.printStackTrace(); }
        });

        // Thread 2: The Receiver (Consumer)
        Thread thread2 = new Thread(() -> {
            try {
                int data = input.read();
                while (data != -1) {
                    System.out.print((char) data);
                    data = input.read();
                }
                input.close();
            } catch (IOException e) { e.printStackTrace(); }
        });


        thread1.start();
        thread2.start();
    }

}