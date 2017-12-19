import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;
import org.sql2o.*;
import java.util.Arrays;
import java.util.List;

public class ClientTest{

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void update_updatesClientsName_true() {
        Client myClient = new Client("Jane Mary", 1);
        myClient.save();
        myClient.update("Kate Winslet");
        assertEquals("Kate Winslet", Client.find(myClient.getId()).getName());
    }

    @Test
    public void Client_instantiatesCorrectly_true() {
        Client myClient = new Client("Mary Jane", 1);
        assertEquals(true, myClient instanceof Client);
    }

    @Test
    public void Client_instantiatesWithDescription_String() {
        Client myClient = new Client("Mary Jane", 1);
        assertEquals("Mary Jane", myClient.getName());
    }

    @Test
    public void isCompleted_isFalseAfterInstantiation_false() {
        Client myClient = new Client("Mary Jane", 1);
        assertEquals(false, myClient.isCompleted());
    }

    @Test
    public void getCreatedAt_instantiatesWithCurrentTime_today() {
        Client myClient = new Client("Mary Jane", 1);
        assertEquals(LocalDateTime.now().getDayOfWeek(), myClient.getCreatedAt().getDayOfWeek());
    }

    @Test
    public void all_returnsAllInstancesOfClient_true() {
        Client firstClient = new Client("Peterson Joy", 1);
        firstClient.save();
        Client secondClient = new Client("Kylie Kate", 1);
        secondClient.save();
        assertEquals(true, Client.all().get(0).equals(firstClient));
        assertEquals(true, Client.all().get(1).equals(secondClient));
    }
/*
    @Test
    public void clear_emptiesAllClientsFromArrayList_0() {
        Client myClient = new Client("Mary Jane");
        Client.clear();
        assertEquals(Client.all().size(), 0);
    }
*/
    @Test
    public void getId_clientsInstantiateWithAnID_1() {
        Client myClient = new Client("Morrison Grymes", 1);
        myClient.save();
        assertTrue(myClient.getId()>0);
    }

    @Test
    public void find_returnsClientWithSameId_secondClient() {
        Client firstClient = new Client("Peterson Joy", 1);
        firstClient.save();
        Client secondClient = new Client("Kylie Kate", 1);
        secondClient.save();
        assertEquals(Client.find(secondClient.getId()), secondClient);
    }

    @Test
    public void equals_returnsTrueIfNamesAreTheSame(){
        Client firstClient = new Client("Sally", 1);
        Client secondClient = new Client("Sally", 1);
        assertTrue(firstClient.equals(secondClient));
    }

    @Test
    public void save_returnsTrueIfNamesAretheSame() {
        Client myClient = new Client("Sally", 1);
        myClient.save();
        assertTrue(Client.all().get(0).equals(myClient));
    }

    @Test
    public void save_assignsIdToObjects(){
        Client myClient = new Client("Sally", 1);
        myClient.save();
        Client savedClient = Client.all().get(0);
        assertEquals(myClient.getId(), savedClient.getId());
    }

    @Test
    public void delete_deletesClient_true(){
        Client myClient = new Client("Jane Doe", 1);
        myClient.save();
        int myClientId = myClient.getId();
        myClient.delete();
        assertEquals(null, Client.find(myClientId));
    }
}
