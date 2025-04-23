package main;

import model.Massage;
import service.ThreadForConsumer;
import service.ThreadForProducer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {

    public static void main(String[] args) {
        //set range size for Queue
        BlockingQueue<Massage> queue = new ArrayBlockingQueue<>(3);

        //set 2 thread to manage
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(new ThreadForProducer(queue));// run thread of Producer

        executorService.submit(new ThreadForConsumer(queue));// run thread of Consumer

        try {
            Thread.sleep(30000); // run 30 second
        } catch (InterruptedException e) {
            System.out.println("Thread bị ngắt khi đang chờ 30s.");
            Thread.currentThread().interrupt(); // avoid thread when stop and continue running
        }

        // shutdown after 30 second
        executorService.shutdownNow();
        System.out.println("⏰ Chương trình kết thúc sau 30 giây");

    }
}
