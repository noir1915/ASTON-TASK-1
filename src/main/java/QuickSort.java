import java.util.*;

/**
 * Quicksort implementation that takes n*log(n) time on average. Like all
 * proper quick sorts, this sort is stable and runs O(n*n) times in the
 * worst case. This implementation also supports null values and handles
 * them correctly.
 * */
public class QuickSort {

    /**
     * Sorts the specified range of the specified list of objects
     * according to the order specified by the objects compareTo
     * method.
     */
    public static <E> void sort(List<E> list) {
        if (list.isEmpty()) {
            throw new NullPointerException("List is empty");
        } else {
            E[] array = (E[]) list.toArray();
            qSort(array, 0, array.length - 1);

            ListIterator<E> iterator = list.listIterator();
            int i = 0;
            while (iterator.hasNext()) {
                iterator.next();
                iterator.set(array[i++]);
            }
        }
    }
    private static <E> void qSort(E[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int middle = low + (high - low) / 2;
        Comparable pivot = (Comparable) array[middle];
        int f = low, l = high;
        while (f <= l) {
            while ( array[f] != null & pivot == null ||
                    array[f] != null & pivot != null && pivot.compareTo(array[f]) > 0) {
                f++;
            }
            while ( array[l] == null & pivot != null ||
                    array[f] != null & pivot != null && pivot.compareTo(array[l]) < 0) {
                l--;
            }
            if (f <= l) {
                E temp = array[f];
                array[f] = array[l];
                array[l] = temp;
                f++;
                l--;
            }
            if (low < l) {
                qSort(array, low, l);
            }
            if (high > f) {
                qSort(array, f, high);
            }
        }
    }
}