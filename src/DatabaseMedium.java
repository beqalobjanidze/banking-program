import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseMedium implements Medium{
//    aq chaiwereba failis misamarti       \/
    private File file = new File("");

    @Override
    public void write(String user, long dataId, String data) throws Exception {
        String content = dataId + "+" + user + "+" + data + "\n";

        try (FileWriter writer = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write(content);

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        this.Backup();
    }

    @Override
    public String read(String user, long dataId) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        int i = 1;
        while ((st = br.readLine()) != null) {
            String[] operation = st.split("+");
            if (operation[0].equals(Long.toString(dataId))) {
                return st;
            }
            i += 1;
        }
        return null;
    }

    @Override
    public List<String> read(String user) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<String> operations = new ArrayList<>();

        String st;
        int i = 1;
        while ((st = br.readLine()) != null) {
            String[] operation = st.split("+");
            if (operation[1].equals(user)) {
                operations.add(operation[2]);
            }
            i += 1;
        }
        return operations;
    }

    void Backup() {
        try {
//          Aq chaiwereba failis misamarti \/
            Backup.saveWithBackup("");
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
