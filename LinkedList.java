/*
public class LinkedList<L> {
/*
    Node head = null; /* Head of the list */
  //  Node tail = null; /* Tail of the list */
   // Node current = null; /* current node in the list */
/*
    public void prepend(Taxi taxi) {
        if (head == null) {
            head = tail = new Node(taxi, null);
            current = head;
        } else {
            head = new Node(taxi, head);
            current = head;
        }
    }

 */
/*


    public void append(Taxi taxi) {
        if (head == null) {
            head = tail = new Node(taxi, null);
            current = tail;
        } else {
            tail.next = new Node(taxi, null);
            tail = tail.next;
            current = tail;
        }
    }

    public void add(Taxi taxi) {
        if (current != null) {
            Node newNode = new Node(taxi, current.next);
            current.next = newNode;
            current = newNode;
        } else {
            head = tail = new Node(taxi, null);
            current = head;
        }
    }

    public void delete() {
        if (head == null || current == null) {
            return; // List is empty or current is null, nothing to delete
        }

        if (head == current) {
            head = current.next;
            if (head == null) {
                tail = null; // If the head was the only node in the list
            }
            current = head;
        } else {
            Node temp = head;
            while (temp.next != null && temp.next != current) {
                temp = temp.next;
            }
            if (temp.next == null) {
                return; // Current node not found in the list
            }
            temp.next = current.next;
            if (temp.next == null) {
                tail = temp; // If the deleted node was the tail
            }
            current = current.next;
        }
    }


    public void find(Taxi taxi) {
        Node temp = head;
        while (temp != null) {
            if (taxi.equals(temp.taxi)) {
                current = temp; // Update current node to the found node
                return;
            }
            temp = temp.next;
        }
        // If the taxi is not found, the current node remains unchanged
    }

    public Taxi get() {
        if (current != null)
            return current.taxi;
        else
            return null;
    }

    public boolean next() {
        if (current != tail) {
            current = current.next;
            return true;
        } else
            return false;
    }

    public void start() {
        current = head;
    }
    public void end() {
        current = tail;
    }

    public boolean empty() {
        if (head == null)
            return true;
        else
            return false;
    }
}
*/
