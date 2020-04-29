/** An LInked List Deque
* */
public class LinkedListDeque<T> {
    private class tNode {
        public T item;
        public tNode next;
        public tNode prev;

        public tNode(T i, tNode n, tNode p) {
            item = i;
            next = n;
            prev = p;
        }

    }
    private tNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new tNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        int size = 0;

    }

    public LinkedListDeque(T x) {
        sentinel = new tNode(null, null, null);
        sentinel.next = new tNode(x, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        int size = 1;
    }

    public void printDeque() {
        tNode cur = sentinel;
        for (int i=0; i<size; i++){
            cur = cur.next;
            System.out.print(cur.next.item + " ");
        }
    }
    public void addFirst(T item) {
        tNode first = new tNode(item, sentinel.next, sentinel);
        sentinel.next.prev = first;
        sentinel.next = first;
        size++;
    }

    public void addLast(T item) {
        tNode last = new tNode(item, sentinel, sentinel.prev);
        sentinel.prev.next = last;
        sentinel.prev = last;
        size++;
    }

    public boolean isEmpty() {
       if (size == 0){
           return true;
       } else {
           return false;
       }
    }

    public void removeFirst() {
        sentinel.next.next.prev = sentinel;
        sentinel.next.item = null;
        sentinel.next.prev = null;
        tNode p =sentinel.next.next;
        sentinel.next.next = null;
        sentinel.next = p;
        size --;
    }

    public void removeLast() {
        sentinel.prev.prev.next = sentinel;
        sentinel.prev.item = null;
        sentinel.prev.next = null;
        tNode p = sentinel.prev.prev;
        sentinel.prev.prev = null;
        sentinel.prev = p;
        size --;
    }

    public T get(int index){
        tNode cur = sentinel.next;
        for (int i=0; i<index; i++){
            cur = cur.next;
        }
        return cur.item;
    }

    public int size() {
        return size;
    }
    public T getRecursive(tNode n, int index) {
        if (index == 0){
            return n.next.item;
        } else {
            return getRecursive(n.next, index-1);
        }
    }
    public T getRecursive(int index) {
        return getRecursive(sentinel, index);
    }
}
