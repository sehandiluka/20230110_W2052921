class Vendor implements Runnable {
    private final TicketPool ticketPool;
    private final int ticketReleaseRate;
    private final int totalTickets;
    private static int ticketCounter = 1;
    private volatile boolean running = true;

    public Vendor(TicketPool ticketPool, int ticketReleaseRate, int totalTickets) {
        this.ticketPool = ticketPool;
        this.ticketReleaseRate = ticketReleaseRate;
        this.totalTickets = totalTickets;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        try {
            while (running && ticketCounter <= totalTickets) {
                String ticket = "Ticket-" + ticketCounter++;
                ticketPool.addTicket(ticket);
                Thread.sleep(Math.max(1, 1000 / ticketReleaseRate));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        Logger.log("Vendor stopped.");
        System.out.println("Vendor stopped.");
    }
}