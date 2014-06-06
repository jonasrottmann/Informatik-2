package aufgabe_3_2_1_doppeltverketteteliste;



import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;


/**
* LinkedList Tester. 
* 
* @author Jonas Rottmann
* @since <pre>Mrz 29, 2014</pre> 
* @version 1.0 
*/
public class LinkedListTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     *
     * Method: addFirst(String value)
     *
     */
    @Test
    public void testAddFirst1() throws Exception {
        LinkedList myList = new LinkedList();
        myList.addFirst("Hallo, ich sollte das erste und einzige Element sein!");

        assertEquals(myList.get(0), "Hallo, ich sollte das erste und einzige Element sein!");
    }

    @Test
    public void testAddFirst2() throws Exception {
        LinkedList myList = new LinkedList();
        myList.addFirst("Hallo, ich bin nur ein Testelement!");
        myList.addFirst("Hallo, ich muss das erste Element sein!");

        assertEquals(myList.get(0), "Hallo, ich muss das erste Element sein!");
        assertEquals(myList.get(1), "Hallo, ich bin nur ein Testelement!");
    }


    /**
     *
     * Method: addLast(String value)
     *
     */
    @Test
    public void testAddLast1() throws Exception {
        LinkedList myList = new LinkedList();
        myList.addLast("Hallo, ich sollte das erste und einzige Element sein!");

        assertEquals(myList.get(0), "Hallo, ich sollte das erste und einzige Element sein!");
    }

    @Test
    public void testAddLast2() throws Exception {
        LinkedList myList = new LinkedList();
        myList.addLast("Hallo, ich bin nur ein Testelement!");
        myList.addLast("Hallo, ich muss das letzte Element sein!");

        assertEquals(myList.get(0), "Hallo, ich bin nur ein Testelement!");
        assertEquals(myList.get(1), "Hallo, ich muss das letzte Element sein!");
    }

    /**
     *
     * Method: add(int index, String value)
     *
     */
    @Test
    public void testAdd1() throws Exception {
        LinkedList myList = new LinkedList();
        myList.add(0, "Hallo!");

        assertEquals(myList.get(0), "Hallo!");
    }

    @Test
    public void testAdd2() throws Exception {
        LinkedList myList = new LinkedList();
        myList.addFirst("Test3_1");
        myList.addFirst("Test3_1");
        myList.add(0, "Hallo!");

        assertEquals(myList.get(0), "Hallo!");
        assertEquals(myList.get(1), "Test3_1");
        assertEquals(myList.get(2), "Test3_1");
    }

    @Test
    public void testAdd3() throws Exception {
        LinkedList myList = new LinkedList();
        myList.addFirst("Test3_1");
        myList.addFirst("Test3_1");
        myList.add(1, "Hallo!");

        assertEquals(myList.get(0), "Test3_1");
        assertEquals(myList.get(1), "Hallo!");
        assertEquals(myList.get(2), "Test3_1");
    }

    @Test
    public void testAdd4() throws Exception {
        LinkedList myList = new LinkedList();
        myList.addFirst("Test3_1");
        myList.addFirst("Test3_1");
        myList.add(2, "Hallo!");

        assertEquals(myList.get(0), "Test3_1");
        assertEquals(myList.get(1), "Test3_1");
        assertEquals(myList.get(2), "Hallo!");
    }

    @Test
    public void testAdd5() throws Exception {
        thrown.expect(AssertionError.class);

        LinkedList myList = new LinkedList();
        myList.add(10, "Hallo!");
    }

    /**
     *
     * Method: removeFirst()
     *
     */
    @Test
    public void testRemoveFirst1() throws Exception {
        thrown.expect(AssertionError.class);

        LinkedList myList = new LinkedList();
        myList.removeFirst();
    }

    @Test
    public void testRemoveFirst2() throws Exception {
        LinkedList myList = new LinkedList();
        myList.addFirst("Hallo Welt.");
        myList.addFirst("Ich werde sowieso gleich wieder gelöscht...");

        assertEquals(myList.removeFirst(), "Ich werde sowieso gleich wieder gelöscht...");
        assertEquals(myList.get(0), "Hallo Welt.");
        assertEquals(myList.getSize(), 1);
    }

    @Test
    public void testRemoveFirst3() throws Exception {
        LinkedList myList = new LinkedList();
        myList.addFirst("Hallo Welt.");

        assertEquals(myList.removeFirst(), "Hallo Welt.");
        assertEquals(myList.getSize(), 0);
    }

    /**
    *
    * Method: removeLast()
    *
    */
    @Test
    public void testRemoveLast1() throws Exception {
        thrown.expect(AssertionError.class);

        LinkedList myList = new LinkedList();
        myList.removeLast();
    }

    @Test
    public void testRemoveLast2() throws Exception {
        LinkedList myList = new LinkedList();
        myList.addFirst("Ich werde sowieso gleich wieder gelöscht...");
        myList.addFirst("Ich nicht.");

        assertEquals(myList.removeLast(), "Ich werde sowieso gleich wieder gelöscht...");
        assertEquals(myList.get(0), "Ich nicht.");
    }

    /**
    *
    * Method: remove(int index)
    *
    */
    @Test
    public void testRemove1() throws Exception {
        thrown.expect(AssertionError.class);

        LinkedList myList = new LinkedList();
        myList.remove(0);
    }

    @Test
    public void testRemove2() throws Exception {
        thrown.expect(AssertionError.class);

        LinkedList myList = new LinkedList();
        myList.remove(5);
    }

    @Test
    public void testRemove3() throws Exception {
        LinkedList myList = new LinkedList();
        myList.addFirst("Ich bin ein Element.");

        assertEquals(myList.remove(0), "Ich bin ein Element.");
        assertEquals(myList.getSize(), 0);
    }

    @Test
    public void testRemove4() throws Exception {
        LinkedList myList = new LinkedList();
        myList.addFirst("Ich bin ein Element.");
        myList.addFirst("Ich auch.");

        assertEquals(myList.remove(1), "Ich bin ein Element.");
        assertEquals(myList.get(0), "Ich auch.");
    }

    /**
    *
    * Method: getSize()
    *
    */
    @Test
    public void testGetSize1() throws Exception {
        LinkedList myList = new LinkedList();
        assertEquals(myList.getSize(), 0);
    }

    @Test
    public void testGetSize2() throws Exception {
        LinkedList myList = new LinkedList();
        myList.addFirst("Hallo!");

        assertEquals(myList.getSize(), 1);
    }
}
