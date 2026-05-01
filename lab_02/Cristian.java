import java.util.Random;

public class Cristian {

    static class Clock {
        private int time;

        public Clock(int time) {
            this.time = time;
        }

        public synchronized int getTime() {
            return time;
        }

        public synchronized void setTime(int time) {
            this.time = time;
        }
    }

    static class TimeServer {
        public int getTime() {
            return 100;
        }
    }

    static class Client extends Thread {
        private Clock clock;
        private TimeServer server;
        private Random rand = new Random();

        public Client(Clock clock, TimeServer server) {
            this.clock = clock;
            this.server = server;
        }

        public void run() {
            try {
                int t0 = rand.nextInt(10);
                Thread.sleep(rand.nextInt(50));
                int serverTime = server.getTime();
                Thread.sleep(rand.nextInt(50));
                int t1 = t0 + rand.nextInt(10);
                int rtt = t1 - t0;
                int newTime = serverTime + (rtt / 2);

                System.out.println("Cliente " + getId());
                System.out.println("Antes: " + clock.getTime());
                clock.setTime(newTime);
                System.out.println("Después: " + clock.getTime());
                System.out.println("------");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TimeServer server = new TimeServer();

        for (int i = 0; i < 5; i++) {
            Clock clock = new Clock((int)(Math.random() * 50));
            new Client(clock, server).start();
        }
    }
}