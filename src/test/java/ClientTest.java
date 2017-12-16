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

    @Test
    public void isCompleted_isFalseAfterInstantiation_false() {
        Client myClient = new Client("Mary Jane");
        assertEquals(false, myClient.isCompleted());
    }

    @Test
    public void getCreatedAt_instantiatesWithCurrentTime_today() {
        Client myClient = new Client("Mary Jane");
        assertEquals(LocalDateTime.now().getDayOfWeek(), myClient.getCreatedAt().getDayOfWeek());
    }

    @Test
    public void all_returnsAllInstancesOfClient_true() {
        Client firstClient = new Client("Peterson Joy");
        Client secondClient = new Client("Kylie Kate");
        assertEquals(true, Client.all().contains(firstClient));
        assertEquals(true, Client.all().contains(secondClient));
    }

    @Test
    public void clear_emptiesAllClientsFromArrayList_0() {
        Client myClient = new Client("Mary Jane");
        Client.clear();
        assertEquals(Client.all().size(), 0);
    }

    @Test
    public void getId_clientsInstantiateWithAnID_1() {
        Client.clear();  // Remember, the test will fail without this line! We need to empty leftover Tasks from previous tests!
        Client myClient = new Client("Morrison Grymes");
        assertEquals(1, myClient.getId());
    }

    @Test
    public void find_returnsClientWithSameId_secondClient() {
        Client firstClient = new Client("Peterson Joy");
        Client secondClient = new Client("Kylie Kate");
        assertEquals(Client.find(secondClient.getId()), secondClient);
    }
}
