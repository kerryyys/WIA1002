package queue;

import java.util.*;

public class L6Q5 {

    public static void main(String[] args) {
        PriorityQueueSimulator simulator = new PriorityQueueSimulator();
        Random rand = new Random();
        LinkedList<String> packet = new LinkedList<>();
        packet.add("Data");
        packet.add("Video");
        packet.add("Voice");

        // Enqueue packets with different types and priorities
        System.out.println("10 packet arrived");
        for (int i = 1; i < 11; i++) {
            int prio = rand.nextInt(3);
            String pack = packet.get(prio) +" " +i;
            Packet type = new Packet(pack, prio);
            if (pack.equals("Voice")) {
                simulator.enqueue(type);
            } else if (pack.equals("Video")) {
                simulator.enqueue(type);
            } else {
                simulator.enqueue(type);
            }
            System.out.println(pack + " " + " ( Priority = " + prio + " )");
        }

        System.out.println("\n--- Processing " + simulator.getSize() + " Network Packets ---");
        while (!simulator.isEmpty()) {
            Packet processingPacket = simulator.dequeue();
            // Simulate packet processing
            if (processingPacket != null) {
                System.out.println(processingPacket.getPacket() + " (Priority: "
                        + processingPacket.getPriority() + ")");
            }
        }
    }

}

class Packet implements Comparable<Packet> {
    private String type;
    private int priority;

    public Packet(String type, int prio) {
        this.type = type;
        this.priority = prio;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getPacket() {
        return this.type;
    }

    public int compareTo(Packet other) {
        return Integer.compare(other.getPriority(), this.getPriority());
    }
}

class PriorityQueueSimulator {

    PriorityQueue<Packet> queue;
    int size = 0;

    public PriorityQueueSimulator() {
        queue = new PriorityQueue<>();
    }

    public void enqueue(Packet packet) {
        queue.offer(packet);
        size++;
    }

    public Packet dequeue() {
        if (queue.isEmpty()) {
            throw new NullPointerException();
        }
        Packet temp = queue.poll();
        size--;
        return temp;
    }

    public int getSize() {
        return this.size;
    }

    public Packet getFront() {
        return queue.peek();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        while (!queue.isEmpty()) {
            queue.poll();
        }
        size = 0;
    }
}
