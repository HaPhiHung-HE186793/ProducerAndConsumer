package service;


import model.Massage;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class ThreadForConsumer implements Runnable {

    private final BlockingQueue<Massage> queue;

    public ThreadForConsumer(BlockingQueue<Massage> queue) {
        this.queue = queue;
    }

    @Override // để ghi đè method
    public void run() {
        try {
            while (true) {

                if (queue.isEmpty()) {
                    System.out.println(
                            "--------------------\n" +
                                    "Consumer: queue is empty can take");
                }

                Massage takeMassageFormQuene = queue.take();

                System.out.println(
                        "--------------------\n" +
                                "+ Consumer: Take " + takeMassageFormQuene.getMessage()
                );

                //set random time
                Random randomTime = new Random();
                int sleepTime = 2000 + randomTime.nextInt(9000); // from 2000ms to 11000ms
                Thread.sleep(sleepTime);
            }
        } catch (InterruptedException e) {//when system stop
            System.out.println("[Consumer] Bị ngắt - dừng luồng.");
            Thread.currentThread().interrupt(); // avoid thread when stop and continue running
        }
    }
}
