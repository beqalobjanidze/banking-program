import java.io.IOException;
import java.nio.file.*;

public class Backup {
    public static void saveWithBackup(String filename)
            throws IOException {
        Path source = Paths.get(filename);
        String backupname = "backup" + java.time.LocalDate.now().toString() + "-" + System.currentTimeMillis()/10000;
        Path target = Paths.get(filename +"."+backupname);
        try {
            Files.copy(source, target);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}