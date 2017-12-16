import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;
import org.sql2o.*;
import java.util.Arrays;
import java.util.List;

public class ClientTest{

    @Test
    public void Client_instantiatesCorrectly_true() {
        Client myClient = new Client("Mary Jane");
        assertEquals(true, myClient instanceof Client);
    }

    @Test
    public void Client_instantiatesWithDescription_String() {
        Client myClient = new Client("Mary Jane");
        assertEquals("Mary Jane", myClient.getName());
    }
}
