package Java_21_12_23;

public class ProducerConsumerParallel {
    final String[] buffer = new String[4];
    int count = 0;

    public static void main(String[] args) {
        ProducerConsumerParallel obj = new ProducerConsumerParallel();
        Producer pos = obj.new Producer();
        Consumer cos = obj.new Consumer();
        pos.start();
        cos.start();


        try {
            Thread.sleep(10000); // Simulating a delay before stopping
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pos.interrupt();
        cos.interrupt();
    }

    class Producer extends Thread {
        public void run() {
            for (int i = 0; i < buffer.length; i++) {
                synchronized (buffer) {
                    while (count == buffer.length) {
                        try {
                            System.out.println("Buffer is full. Producer is waiting...");
                            buffer.wait();
                        } catch (InterruptedException e) {
                            System.out.println("Producer stopped.");
                            return;
                        }
                    }
                    buffer[count++] = Integer.toString(i + 1);
                    System.out.println("Produced Data: " + buffer[count - 1]);
                    buffer.notifyAll();
                }
            }
        }
    }

    class Consumer extends Thread {
        public void run() {
            while (true) {
                synchronized (buffer) {
                    while (count == 0) {
                        try {
                            System.out.println("Buffer is empty. Consumer is waiting...");
                            buffer.wait();
                        } catch (InterruptedException e) {
                            System.out.println("Consumer stopped.");
                            return;
                        }
                    }
                    String data = buffer[--count];
                    System.out.println("Consumed data: " + data);
                    buffer.notifyAll();
                }
            }
        }
    }
}
