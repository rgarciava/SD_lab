import java.util.ArrayList;
import java.util.List;

public class Berkeley {

    static class Clock {
        private int time;

        public Clock(int time) {
            this.time = time;
        }

        public synchronized int getTime() {
            return time;
        }

        public synchronized void adjust(int offset) {
            time += offset;
        }
    }

    static class Node {
        Clock clock;

        public Node(int time) {
            clock = new Clock(time);
        }

        public int getTime() {
            return clock.getTime();
        }

        public void adjust(int offset) {
            clock.adjust(offset);
        }
    }

    public static void main(String[] args) {

        List<Node> nodes = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            nodes.add(new Node((int)(Math.random() * 100)));
        }

        System.out.println("Antes:");
        for (Node n : nodes) {
            System.out.println(n.getTime());
        }

        int sum = 0;
        for (Node n : nodes) {
            sum += n.getTime();
        }

        int avg = sum / nodes.size();

        for (Node n : nodes) {
            int offset = avg - n.getTime();
            n.adjust(offset);
        }

        System.out.println("\nDespués:");
        for (Node n : nodes) {
            System.out.println(n.getTime());
        }
    }
}