/**
 * Create Array Deque
 *
 * @author Jason Yang
 */

public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int len;

    /* reate empty list. */
    public ArrayDeque() {
        len = 16;
        items = (T[]) new Object[len];
        size = 0;
        nextFirst = 7;
        nextLast = 8;
    }


    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[(nextFirst + 1 + i)] + " ");
        }
    }
    public void addFirst(T item) {
        if (size == (len / 2)-1){
            resizeUp(2*len);
        }
        items[nextFirst] = item;
        size ++;
        nextFirst = (nextFirst-1);
    }

    public void addLast(T item) {
        if (size == (len/2)-1){
            resizeUp(2*len);
        }
        items[nextLast] = item;
        size ++;
        nextLast = (nextLast+1);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            if ((len > 16) && (size == len / 4)) {
                resizeDown(len / 2);
            }
            T pop = items[nextFirst + 1];
            items[nextFirst + 1] = null;
            size--;
            nextFirst = (nextFirst + 1);
            return pop;
        }
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            if ((len > 16) && (size == len / 4)) {
                resizeDown(len / 2);
            }
            T pop = items[nextLast - 1];
            items[nextLast - 1] = null;
            size--;
            nextLast = (nextLast - 1);
            return pop;
        }
    }

    public T get(int index){
        return items[(nextFirst+1+index)];
    }

    public int size() {
        return size;
    }
    private void resizeUp(int capacity){
        T[] a = (T[]) new Object[capacity];
        int init = len*3/4;
        System.arraycopy(items, nextFirst+1, a, init+1, size );
        items = a;
        nextFirst = init;
        nextLast = nextFirst +size+1;
        len = capacity;
    }
    private void resizeDown(int capacity){
        T[] a = (T[]) new Object[capacity];
        int init = len/8;
        System.arraycopy(items, nextFirst+1, a, init+1, size );
        items = a;
        nextFirst = init;
        nextLast = nextFirst +size+1;
        len = capacity;
    }
}
