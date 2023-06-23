package homeWork12;

import java.util.concurrent.*;

public class Task12_1 {
    public static void main(String[] args) throws InterruptedException {
        Runnable time = new Runnable() {
            int time =0;
            @Override
            public void run() {
                time++;
                System.out.println("time = " + time + "second from start");
            }
        };
        Runnable fiveSec = new Runnable() {
            @Override
            public void run() {
                System.out.println("five second...");
            }
        };
        ScheduledExecutorService ex = Executors.newScheduledThreadPool(2);
        ex.scheduleAtFixedRate(time, 1,1, TimeUnit.SECONDS);
        ex.scheduleAtFixedRate(fiveSec, 5,5, TimeUnit.SECONDS);
        Thread.sleep(21000);
        ex.shutdown();
        }

    }

