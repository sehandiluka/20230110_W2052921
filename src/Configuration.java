import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class Configuration {
    private static final String CONFIG_FILE = "config.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private int maximumCapacity;
    private int totalTickets;
    private int ticketReleaseRate;
    private int retrievalRate;

    public Configuration(int maximumCapacity, int totalTickets, int ticketReleaseRate, int retrievalRate) {
        this.maximumCapacity = maximumCapacity;
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.retrievalRate = retrievalRate;
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public int getRetrievalRate() {
        return retrievalRate;
    }

    public static void saveConfig(int maxCapacity, int totalTickets, int ticketReleaseRate, int customerRetrievalRate) {
        Configuration config = new Configuration(maxCapacity,totalTickets, ticketReleaseRate, customerRetrievalRate);
        try {
            Writer writer = new FileWriter(CONFIG_FILE);
            gson.toJson(config, writer);
            writer.close();
            Logger.log("Configuration saved to file.");
            System.out.println("Configuration saved successfully.");
        } catch (IOException e) {
            Logger.log("Error saving configuration: " + e.getMessage());
            System.out.println("Error saving configuration: " + e.getMessage());
        }
    }

    public static Configuration loadConfig() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CONFIG_FILE))) {
            Logger.log("Loading configuration from file.");
            return gson.fromJson(reader, Configuration.class);

        } catch (IOException | NumberFormatException e) {
            Logger.log("Error loading configuration: " + e.getMessage());
            System.out.println("Error loading configuration: " + e.getMessage());
            return null;
        }
    }
}
