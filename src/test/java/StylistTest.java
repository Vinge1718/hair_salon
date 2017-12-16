import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import org.sql2o.*;

public class StylistTest{
    @Test
    public void stylist_instantiatesCorrectly_true() {
        Stylist testStylist = new Stylist("Lory");
        assertEquals(true, testStylist instanceof Stylist);
    }

    @Test
    public void getName_stylistInstantiatesWithName_Home() {
        Stylist testStylist = new Stylist("Lory");
        assertEquals("Lory", testStylist.getName());
    }

    @Test
    public void all_returnsAllInstancesOfStylist_true() {
        Stylist firstStylist = new Stylist("Kelly");
        Stylist secondStylist = new Stylist("Dora");
        assertEquals(true, Stylist.all().contains(firstStylist));
        assertEquals(true, Stylist.all().contains(secondStylist));
    }

    @Test
    public void clear_emptiesAllStylistFromList_0() {
       Stylist testCategory = new Stylist("Lory");
       Stylist.clear();
       assertEquals(Stylist.all().size(), 0);
    }

    @Test
    public void getId_stylistInstantiateWithAnId_1() {
        Stylist.clear();
        Stylist testStylist = new Stylist("Lory");
        assertEquals(1, testStylist.getId());
    }

    @Test
    public void find_returnsStylistWithSameId_secondStylist() {
        Stylist.clear();
        Stylist firstStylist = new Stylist("Lory");
        Stylist secondStylist = new Stylist("Jaden");
        assertEquals(Stylist.find(secondStylist.getId()), secondStylist);
    }

    @Test
    public void getClients_initiallyReturnsEmptyList_ArrayList() {
        Stylist.clear();
        Stylist testStylist = new Stylist("Lory");
        assertEquals(0, testStylist.getClients().size());
    }

    @Test
    public void addClients_addsClientToList_true() {
        Stylist testStylist = new Stylist("Lory");
        Client testClient = new Client("Mary Jane");
        testStylist.addClient(testClient);
        assertTrue(testStylist.getClients().contains(testClient));
    }

}
