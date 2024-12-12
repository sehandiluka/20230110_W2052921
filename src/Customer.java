public class Customer implements Runnable {
    private final TicketPool ticketPool;
    private final int customerRetrievalRate;
    private volatile boolean running = true;

    public Customer(TicketPool ticketPool, int customerRetrievalRate) {
        this.ticketPool = ticketPool;
        this.customerRetrievalRate = customerRetrievalRate;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        try {
            while (running) {
                ticketPool.removeTicket();
                Thread.sleep(Math.max(1, 1000 / customerRetrievalRate));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        Logger.log("Customer stopped.");
        System.out.println("Customer stopped.");
    }
}
