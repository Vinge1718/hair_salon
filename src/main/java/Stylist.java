import java.util.List;
import java.util.ArrayList;
import org.sql2o.*;

public class Stylist{
    private int mId;
    private String mName;
    private List<Client> mClients;
    private static List<Stylist> instances = new ArrayList<Stylist>();

    public Stylist(String name){
        mName = name;
        instances.add(this);
        mId = instances.size();
        mClients = new ArrayList<Client>();
    }

    public String getName() {
        return mName;
    }

    public static List<Stylist> all() {
        return instances;
    }

    public static void clear() {
        instances.clear();
    }

    public int getId() {
        return mId;
    }

    public static Stylist find(int id) {
        return instances.get(id - 1);
    }

    public List<Client> getClients() {
        return mClients;
    }

    public void addClient(Client client) {
        mClients.add(client);
    }
}
