import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;


public class Client{
    private String mName;

    public Client(String name) {
        mName = name;
  }

    public String getName() {
        return mName;
  }

}
