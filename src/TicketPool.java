import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {
    private final Queue<String> tickets = new LinkedList<>();
    private final int maxCapacity;

    public TicketPool(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public synchronized void addTicket(String ticket) throws InterruptedException {
        while (tickets.size() == maxCapacity) {
            wait();
        }
        tickets.add(ticket);
        Logger.log("Ticket added: " + ticket);
        System.out.println("Ticket added: " + ticket);
        notifyAll();
    }

    public synchronized String removeTicket() throws InterruptedException {
        while (tickets.isEmpty()) {
            wait();
        }
        String ticket = tickets.poll();
        Logger.log("Ticket purchased: " + ticket);
        System.out.println("Ticket purchased: " + ticket);
        notifyAll();
        return ticket;
    }
}