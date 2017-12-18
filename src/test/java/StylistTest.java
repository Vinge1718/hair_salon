import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import org.sql2o.*;

public class StylistTest{

    @Before
    public void setUp(){
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", "v", "6442");
    }

    @After
    public void tearDown() {
        try(Connection con = DB.sql2o.open()){
            String deleteClientsQuery = "DELETE FROM clients *;";
            String deleteStylistsQuery = "DELETE FROM stylists *;";
            con.createQuery(deleteClientsQuery).executeUpdate();
            con.createQuery(deleteStylistsQuery).executeUpdate();
        }
    }

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
        firstStylist.save();
        Stylist secondStylist = new Stylist("Dora");
        secondStylist.save();
        assertEquals(true, Stylist.all().get(0).equals(firstStylist));
        assertEquals(true, Stylist.all().get(1).equals(secondStylist));
    }
/*
    @Test
    public void clear_emptiesAllStylistFromList_0() {
       Stylist testCategory = new Stylist("Lory");
       Stylist.clear();
       assertEquals(Stylist.all().size(), 0);
    }
*/
    @Test
    public void getId_stylistInstantiateWithAnId_1() {
        Stylist testStylist = new Stylist("Lory");
        testStylist.save();
        assertTrue(testStylist.getId() > 0);
    }

    @Test
    public void find_returnsStylistWithSameId_secondStylist() {
        Stylist firstStylist = new Stylist("Lory");
        firstStylist.save();
        Stylist secondStylist = new Stylist("Jaden");
        secondStylist.save();
        assertEquals(Stylist.find(secondStylist.getId()), secondStylist);
    }

    @Test
    public void getClients_initiallyReturnsEmptyList_ArrayList() {
        Stylist testStylist = new Stylist("Lory");
        assertEquals(0, testStylist.getClients().size());
    }

    @Test
    public void find_returnsNullWhenNoClientFound_null() {
        assertTrue(Stylist.find(999) == null);
    }

    @Test
    public void equals_returnsTrueIfNamesAreTheSame(){
        Stylist firstStylist = new Stylist("Lory");
        Stylist secondStylist = new Stylist("Lory");
        assertTrue(firstStylist.equals(secondStylist));
    }

    @Test
    public void save_savesIntoDatabase_true(){
        Stylist myStylist = new Stylist("Lory");
        myStylist.save();
        assertTrue(Stylist.all().get(0).equals(myStylist));
    }

    @Test
    public void save_assignedToObject(){
        Stylist myStylist = new Stylist("Lory");
        myStylist.save();
        Stylist savedStylist = Stylist.all().get(0);
        assertEquals(myStylist.getId(), savedStylist.getId());
    }

    @Test
    public void save_savesStylistIdIntoDB_True(){
        Stylist myStylist = new Stylist("Lory");
        myStylist.save();
        Client myClient = new Client("Loise Kim", myStylist.getId());
        myClient.save();
        Client savedClient = Client.find(myClient.getId());
        assertEquals(savedClient.getStylistId(), myStylist.getId());
    }

    @Test
    public void getClients_retrievesAllClientsFromDatabase_clientsList(){
        Stylist myStylist = new Stylist("Lory");
        myStylist.save();
        Client firstClient = new Client("Claire Suzzana", myStylist.getId());
        firstClient.save();
        Client secondClient = new Client("Keisha Simmons", myStylist.getId());
        secondClient.save();
        Client[] clients = new Client[] {firstClient, secondClient};
        assertTrue(myStylist.getClients().containsAll(Arrays.asList(clients)));
    }
}
