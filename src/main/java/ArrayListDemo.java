
import java.util.Arrays;

/**
 * Here is a demo of QuickSort/ArrayListImpl
 */
public class ArrayListDemo {
    public static void main(String[] args) {

        int initialCapacity = 20;
        /*ListInteger*/
        ArrayListImpl<Integer> initialCapacityList = new ArrayListImpl<Integer>(initialCapacity);
        for (int i = 0; i < initialCapacity; i++) {
            initialCapacityList.add((int) (Math.random() * 100));
        }
        System.out.println("Sorting:");
        System.out.println("list before sorting: " + Arrays.toString(initialCapacityList.array));
        QuickSort.sort(Arrays.asList(initialCapacityList.array));
        System.out.println("list after sorting:  " + Arrays.toString(initialCapacityList.array) + "\n\n");

        /*ListString*/
        ArrayListImpl<String> list = new ArrayListImpl<String>(initialCapacity);
        System.out.println("List size before added: " + list.size());
        for (int i = 0; i < initialCapacity; i++) {
            list.add(String.valueOf((int)(Math.random() * 100)));
        }
        System.out.println("list before sorting: " + Arrays.toString(list.array));
        QuickSort.sort(Arrays.asList(list.array));
        System.out.println("list after sorting:  "+ Arrays.toString(list.array));
        System.out.println("list after added: " + list.size());

        System.out.println("index №5: " + list.get(5));
        System.out.println("contains \"5\": " + list.contains("5"));
        System.out.println();

        System.out.println("remove by index: " + list.remove(4));

        list.clear();
        System.out.println("after clear is empty: " + list.isEmpty());
        System.out.println("size after clear(): " + list.size());
    }
}