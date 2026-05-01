import java.util.Random;

public class Cristian {

    // Reloj del cliente
    static class Clock {
        private long time;

        public Clock(long time) {
            this.time = time;
        }

        public synchronized long getTime() {
            return time;
        }

        public synchronized void setTime(long time) {
            this.time = time;
        }
    }

    // Servidor de tiempo
    static class TimeServer {
        public long getTime() {
            return System.currentTimeMillis();
        }
    }

    // Cliente (nodo)
    static class Client extends Thread {
        private Clock clock;
        private TimeServer server;
        private Random rand = new Random();

        public Client(Clock clock, TimeServer server) {
            this.clock = clock;
            this.server = server;
        }

        @Override
        public void run() {
            try {
                long t0 = System.currentTimeMillis();

                // Simula latencia de red (ida)
                Thread.sleep(rand.nextInt(100));

                long serverTime = server.getTime();

                // Simula latencia de red (vuelta)
                Thread.sleep(rand.nextInt(100));

                long t1 = System.currentTimeMillis();
                long rtt = t1 - t0;

                long newTime = serverTime + (rtt / 2);

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
            Clock clock = new Clock(System.currentTimeMillis() + (int)(Math.random() * 1000));
            new Client(clock, server).start();
        }
    }
}