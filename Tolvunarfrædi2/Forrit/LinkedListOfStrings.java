import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.*;

public class LinkedListOfStrings {
    private int N; // size of list
    private Node first; // first node of list

    // helper Node class
    private static class Node {
        private String item;
        private Node next;
    }

    public LinkedListOfStrings() {
        N = 0;
        first = null;
    }

    // is the list empty?
    public boolean isEmpty() {
        return first == null;
    }

    // number of elements on the stack
    public int size() {
        return N;
    }

    // add an element to the front of the list
    public void addFront(String item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    // delete and return the first item in the list
    public String delFront() {
        if (isEmpty())
            throw new NoSuchElementException("No items in list");
        String item = first.item; // save item to return
        first = first.next; // delete first node
        N--;
        return item; // return the saved item
    }

    // print out the list
    public void printList() {
        Node x = first;
        for (int i = 0; i < N; i++) {
            StdOut.print(x.item + "->");
            x = x.next;
        }
        StdOut.println();
    }

    // Counts instances of String S in the list
    public int count(String S) {
        Node current = first;
        int count = 0;
        while (current != null) {
            if (current.item.equals(S)) {
                count++;
            }
            current = current.next;
        }
        return count;
    }

    // test client
    public static void main(String[] args) {
        LinkedListOfStrings list = new LinkedListOfStrings();
        // Adding elements to the list from command-line arguments
        for (int i = args.length - 1; i >= 0; i--) {
            list.addFront(args[i]);
        }

        // Printing the list
        StdOut.println("Number of items: " + list.size());
        list.printList();

        // Reading a string from standard input
        Scanner scanner = new Scanner(System.in);
        StdOut.print("Search string: ");
        String searchStr = scanner.nextLine();

        // Printing the number of instances of the string
        StdOut.println("Number of instances: " + list.count(searchStr));
        scanner.close();
    }
}