package service;

import model.Massage;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class ThreadForProducer implements Runnable {

    private final BlockingQueue<Massage> queue;

    public ThreadForProducer(BlockingQueue<Massage> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int num = 0;
        try {
            while (true) {
                if (queue.remainingCapacity() == 0) { // check vacancy
                    System.out.println(
                            "--------------------\n" +
                                    "Producer: Queue is full [Waitting]");

                }

                Massage addNewMassage = new Massage("massage" + num++);
                queue.put(addNewMassage);

                System.out.println(
                        "--------------------\n" +
                                "- Producer: Add " + addNewMassage.getMessage() + "\n" + 
                                "List massage in Queue"
                );

                //print list queue
                for (Massage listMassageInQueue : queue) {
                    System.out.println("|" + listMassageInQueue.getMessage() + "|");
                }

                //set random time
                Random randomTime = new Random();
                int sleepTime = 1000 + randomTime.nextInt(5000); // from 1000ms to 6000ms
                Thread.sleep(sleepTime);
            }
        } catch (InterruptedException e) {//when system stop
            System.out.println("[Producer] Bị ngắt - dừng luồng.");
            Thread.currentThread().interrupt(); // avoid thread when stop and continue running

        }
    }
}
