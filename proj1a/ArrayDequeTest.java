import java.sql.SQLOutput;

/** Performs some basic linked list tests. */
public class ArrayDequeTest {
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public static void addRemoveTest() {

        System.out.println("Running add/remove test.");

        System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();


        for(int i=0; i<300; i++){
            ad1.addFirst(i);
            System.out.print(ad1.get(0) + " ");


        }
        System.out.println();

        for(int i=0; i<290; i++){
            System.out.print(ad1.removeFirst() + " ");
        }

    }

    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        addRemoveTest();
    }
}
