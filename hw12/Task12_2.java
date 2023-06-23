package homeWork12;

import java.util.concurrent.*;

public class Task12_2 {
    public static void main(String[] args) throws InterruptedException {
        BlockingDeque<String> deque = new LinkedBlockingDeque<>();
        MyProd fizz = new MyProd(){
            int n;
            boolean upd = false;

            @Override
            public void run() {
                while (true){
                    try {
                        if(upd) {
                            upd = false;
                            if (n % 3 == 0) {
                                deque.put("fizz");
                            }
                        }
                    Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }

            @Override
            public void setN(int n) {
                this.n =n;
                upd = true;
            }

            @Override
            public boolean proc() {
                return upd;
            }


        };
        MyProd buzz = new MyProd(){
            int n;
            boolean upd = false;


            @Override
            public void run() {
                while (true){
                    try {
                        if(upd) {
                            upd = false;
                            if (n % 5 == 0) {
                                deque.put("buzz");
                            }
                        }
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }

            @Override
            public void setN(int n) {
                this.n =n;
                upd = true;
            }

            @Override
            public boolean proc() {
                return false;
            }
        };
        MyProd fizBuzz = new MyProd(){
            int n;
            boolean upd = false;

            @Override
            public void run() {
                while (true){
                    try {
                        if(upd) {
                            upd = false;
                            if (n % 3 == 0 && n % 5 == 0) {
                                deque.put("fizzbuzz");
                            }
                        }
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }

            @Override
            public void setN(int n) {
                this.n =n;
                upd = true;
            }

            @Override
            public boolean proc() {
                return false;
            }
        };
        MyProd number = new MyProd(){
            int n;
            boolean upd = false;

            @Override
            public void run() {
                while (true){
                    try {
                        if(upd) {
                            upd = false;
                            if (n % 3 != 0 && n % 5 !=0) {
                                deque.put(String.valueOf(n));
                            }
                        }
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }

            @Override
            public void setN(int n) {
                this.n =n;
                upd = true;
            }

            @Override
            public boolean proc() {
                return false;
            }
        };
        Runnable run =() -> {
                while (true){
                    while (!deque.isEmpty()){
                        System.out.println(deque.poll());
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        };

        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.execute(fizz);
        executor.execute(buzz);
        executor.execute(fizBuzz);
        executor.execute(number);
        executor.execute(run);

        for (int i = 1; i<20;i++){
            fizz.setN(i);
            buzz.setN(i);
            fizBuzz.setN(i);
            number.setN(i);
            while (fizz.proc() || buzz.proc() || fizBuzz.proc() || number.proc()){
                Thread.sleep(300);
            }
        }

    }

}
