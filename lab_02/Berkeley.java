import java.util.ArrayList;
import java.util.List;

public class Berkeley {

    static class Clock {
        private long time;

        public Clock(long time) {
            this.time = time;
        }

        public synchronized long getTime() {
            return time;
        }

        public synchronized void adjust(long offset) {
            time += offset;
        }
    }

    static class Node {
        Clock clock;

        public Node(long time) {
            clock = new Clock(time);
        }

        public long getTime() {
            return clock.getTime();
        }

        public void adjust(long offset) {
            clock.adjust(offset);
        }
    }

    public static void main(String[] args) {

        List<Node> nodes = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            nodes.add(new Node(System.currentTimeMillis() + (int)(Math.random() * 1000)));
        }

        System.out.println("Antes:");
        for (Node n : nodes) {
            System.out.println(n.getTime());
        }

        long sum = 0;
        for (Node n : nodes) {
            sum += n.getTime();
        }

        long avg = sum / nodes.size();

        for (Node n : nodes) {
            long offset = avg - n.getTime();
            n.adjust(offset);
        }

        System.out.println("\nDespués:");
        for (Node n : nodes) {
            System.out.println(n.getTime());
        }
    }
}