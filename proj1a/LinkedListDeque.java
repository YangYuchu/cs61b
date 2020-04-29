/** An LInked List Deque
* */
public class LinkedListDeque<T> {
    private class TNode {
        private T item;
        private TNode next;
        private TNode prev;

        public TNode(T i, TNode n, TNode p) {
            item = i;
            next = n;
            prev = p;
        }

    }
    private TNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new TNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        int size = 0;

    }

    public LinkedListDeque(T x) {
        sentinel = new TNode(null, null, null);
        sentinel.next = new TNode(x, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        int size = 1;
    }

    public void printDeque() {
        TNode cur = sentinel;
        for (int i=0; i<size; i++){
            cur = cur.next;
            System.out.print(cur.next.item + " ");
        }
    }
    public void addFirst(T item) {
        TNode first = new TNode(item, sentinel.next, sentinel);
        sentinel.next.prev = first;
        sentinel.next = first;
        size++;
    }

    public void addLast(T item) {
        TNode last = new TNode(item, sentinel, sentinel.prev);
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

    public T removeFirst() {
        sentinel.next.next.prev = sentinel;
        T pop = sentinel.next.item;
        sentinel.next.item = null;
        sentinel.next.prev = null;
        TNode p =sentinel.next.next;
        sentinel.next.next = null;
        sentinel.next = p;
        size --;
        return pop;
    }

    public T removeLast() {
        sentinel.prev.prev.next = sentinel;
        T pop = sentinel.prev.item;
        sentinel.prev.item = null;
        sentinel.prev.next = null;
        TNode p = sentinel.prev.prev;
        sentinel.prev.prev = null;
        sentinel.prev = p;
        size --;
        return pop;
    }

    public T get(int index){
        TNode cur = sentinel.next;
        for (int i=0; i<index; i++){
            cur = cur.next;
        }
        return cur.item;
    }

    public int size() {
        return size;
    }
    public T getRecursive(TNode n, int index) {
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
