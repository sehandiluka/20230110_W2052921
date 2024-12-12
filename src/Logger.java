import java.io.*;
import java.time.LocalDateTime;

public class Logger {
    private static final String LOG_FILE = "resource/log.txt";

    public static void log(String message) {
        String timeStampMessage = LocalDateTime.now() + ": " + message;
        System.out.println(timeStampMessage);

        File file = new File(LOG_FILE);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write(timeStampMessage);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
