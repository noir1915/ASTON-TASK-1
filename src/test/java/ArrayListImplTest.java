import junit.framework.TestCase;
import org.junit.Test;


public class ArrayListImplTest extends TestCase {

    ArrayListImpl<Integer> arrayList = new ArrayListImpl();
    ArrayListImpl<String> stringArrayList = new ArrayListImpl<String>();

    /**
     * Fills lists with elements from 0 to 10
     */
    @Override
    protected void setUp() throws Exception {
        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
            String s = String.valueOf(i);
            stringArrayList.add(s);
        }
    }

    /**
     * List size check
     */
    @Test
    public void testSize() {
        int actual = arrayList.size();
        int expected = 10;
        assertEquals(expected, actual);
    }

    /**
     * Checking for an i-element from a list
     */
    @Test
    public void testGet() {
        int actual = arrayList.get(5);
        int expected = 5;
        assertEquals(expected, actual);
    }

    /**
     * Checking for an empty list
     */
    @Test
    public void testEmpty() {
        boolean actual = arrayList.isEmpty();
        boolean expected = false;
        assertEquals(expected, actual);
    }

    /**
     * Checking the removal of i element from the list.
     * If the element is deleted, then the size of the list has become 1 less
     */
    @Test
    public void testRemove() {
        arrayList.remove(1);
        int actual = arrayList.size();
        int expected = 9;
        assertEquals(expected, actual);
    }

    /**
     * Removing an object from the list.
     * If the object is present in the list and has been removed, the list of elements has become 1 less
     */
    @Test
    public void testRemoveByObject() {
        stringArrayList.remove("1");
        int actual = stringArrayList.size();
        int expected = 9;
        assertEquals(expected, actual);
    }

    /**
     * Checking at what index the i-object is located
     */
    @Test
    public void testIndexOf() {
        int actual = stringArrayList.indexOf("5");
        int expected = 5;
        assertEquals(expected, actual);
    }

    /**
     * Checking if a given list contains an i-element
     */
    @Test
    public void testContains(){
        boolean actual = stringArrayList.contains("5");
        boolean expected = true;
        assertEquals(expected, actual);
    }

    /**
     * List cleanup check
     * After executing the method, an empty list remains
     */
    @Test
    public void testArrayListClear() {
        arrayList.clear();
        boolean actual = arrayList.isEmpty();
        boolean expected = true;
        assertEquals(expected, actual);
    }


    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}