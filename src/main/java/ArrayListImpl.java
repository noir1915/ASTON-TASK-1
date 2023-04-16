import java.util.*;

/**
 * Resizable-array implementation of the List interface. Implements
 * optional list operations, and permits all elements, including null.
 * In addition to implementing the List interface, this class provides
 * methods to manipulate the size of the array that is used internally
 * to store the list.
 * <p>! Note that this implementation is not synchronized.</p>
 */

public class ArrayListImpl<E> {

    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;

    private int capacity = 0;

    /**
     * The size of the ArrayListImpl (the number of elements it contains).
     */
    private int size = 0;

    /**
     * The array into which the elements of the ArrayListImpl are stored.
     * The capacity of the ArrayListImpl is the length of this array.
     * When empty ArrayListImpl is initialized, this array is assigned
     * a capacity = DEFAULT_CAPACITY.
     */
    public Object[] array;

    /**
     * Shows the number of elements in the list.
     */
    public int size() {
        return size;
    }

    /**
     * Constructs an empty list with an initial capacity of DEFAULT_CAPACITY.
     */
    public ArrayListImpl() {
        capacity = DEFAULT_CAPACITY;
        array = (E[]) new Object[capacity];
    }

    /**
     * Constructs an empty list with the specified initial capacity.
     */
    public ArrayListImpl(int initialCapacity) {
        if (initialCapacity <= DEFAULT_CAPACITY) {
            capacity = DEFAULT_CAPACITY;
            array = new Object[DEFAULT_CAPACITY];
        } else {
            capacity = initialCapacity;
            array = new Object[capacity];
        }
    }

    /**
     * Appends the specified element to the end of this list.
     */
    public void add(E element) {
        if ((size + 1) <= capacity) {
            array[size++] = element;
        }
    }

    /**
     * Returns the element at the specified position in this list
     */
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) array[index];
    }

    /**
     * Removes the element at the specified position in this list.
     */
    public E remove(int index) {

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E element = (E) array[index];
        fastRemove(index);
        return element;
    }

    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present.  If the list does not contain the element, it is
     * unchanged.
     */
    public void remove(Object element) {
        if (element == null) {
            for (int index = 0; index < size; index++) {
                if (array[index] == null) {
                    fastRemove(index);
                    return;
                }
            }
        } else {
            for (int index = 0; index < size; index++) {
                if (element.equals(array[index])) {
                    fastRemove(index);
                    return;
                }
            }
        }
    }
    private void fastRemove(int index) {
        int rightPart = size - index - 1;
        if (rightPart > 0) {
            System.arraycopy(array, index + 1, array, index, rightPart);
        }
        array[--size] = null;
    }

    /**
     * Removes all of the elements from this list.
     * The list will be empty after this call returns.
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    /**
     * Returns true if this list contains no elements.
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     */
    public int indexOf(Object element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }


    /**
     * Returns true if this list contains the specified element.
     */
    public boolean contains(Object element) {
        if (indexOf(element) > -1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Sort list elements by Comparator.
     */
    public void sort(Comparator<? super E> comparator) {
        Arrays.sort((E[]) array, 0, size, comparator);
    }
}