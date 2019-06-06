import java.util.List;

public interface Medium {
    void write(String user, long dataId, String data) throws Exception;

    String read(String user, long dataId) throws Exception;

    List<String> read(String user) throws Exception;
}