package opdestination;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

import formatter.LogFormatter;
import model.LogMessage;

public class FileOutputDestination implements OutputDestination {

    private final LogFormatter formatter;
    private final String FILE_PATH = "./log.txt";
    private final Thread writetThread;
    private final BlockingQueue<String> queue;
    private volatile boolean isShutdown = false;

    public FileOutputDestination(LogFormatter formatter) {
        this.formatter = formatter;
        this.queue = new LinkedBlockingDeque<>();

        this.writetThread = new Thread(() -> {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
                while(!isShutdown || !queue.isEmpty()) {
                    String data = queue.poll(100, TimeUnit.MILLISECONDS);

                    if(data != null) {
                        writer.write(data);
                        writer.newLine();
                    }
                }
            } catch (IOException | InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        writetThread.start();
    }

    @Override
    public boolean write(LogMessage message) {
        if(isShutdown) {
            System.out.println("Submission rejected: Shutdown in progress.");
            return false;
        }
        String msg = formatter.format(message);
        return queue.offer(msg);
    }

    public void stop() {
        this.isShutdown = true;
        try {
            writetThread.join();  // wait for thread to finish draining
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
