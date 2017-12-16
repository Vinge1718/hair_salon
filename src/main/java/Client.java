import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;


public class Client{
    private int mId;
    private String mName;
    private boolean mCompleted;
    private LocalDateTime mCreatedAt;
    private static List<Client> instances = new ArrayList<Client>();

    public Client(String name) {
        mName = name;
        mCompleted = false;
        mCreatedAt = LocalDateTime.now();
        instances.add(this);
        mId = instances.size();
    }

    public String getName() {
        return mName;
    }

    public boolean isCompleted() {
        return mCompleted;
    }

    public LocalDateTime getCreatedAt() {
        return mCreatedAt;
    }

    public static List<Client> all() {
        return instances;
    }

    public static void clear() {
        instances.clear();
    }

    public int getId() {
        return mId;
    }

    public static Client find(int id) {
        return instances.get(id - 1);
    }
}
