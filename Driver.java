
interface List<T> {


	public boolean isEmpty(); 

	public void findFirst(); 

	public void findNext(); 

	public boolean isLast(); 

	public T retrieve(); 

	public void update(T e); 

	public void insert(T e); 

	public void remove();

}

class LinkedList<T> implements List<T> {
	public ListNode head;
	private ListNode current;
	
	public class ListNode{
		public T data;
		public ListNode next;
		
		
		public ListNode(T val) {
			data = val;
			next = null;
		}
	}
	
	public LinkedList()
	{
		head=null;
		current=head;
	}

	@Override
	public boolean isEmpty() {
		if(head == null)
			return true;
		return false;
	}

	@Override
	public void findFirst() {
		current = head;
	}

	@Override
	public void findNext() {
		if(isEmpty() || current.next == null)
			return;
		current = current.next;
	}

	@Override
	public boolean isLast() {
		if (isEmpty())
			return false;
		else
			return current.next == null;
	}

	@Override
	public T retrieve() {
		if (isEmpty())
		{
			System.out.println("List is empty, null will be returned");
			return null;
		}
		else
			return current.data;
	}

	@Override
	public void update(T e) {
		if (isEmpty())
			System.out.println("List is empty, null will be returned");
		else		
			current.data = e;
	}

	@Override
	public void insert(T e) {
		if(isEmpty()) {
			head = current = new ListNode(e);
		}
		else {
			ListNode tmp = current.next;
			current.next = new ListNode(e);
			current = current.next;
			current.next = tmp;
		}
	}

	@Override
	public void remove() {
		if (isEmpty() || current == null) {
			System.out.println("List is empty or cursor is null, nothing to remove.");
			return;
		}

		if (current == head) {
			head = head.next;
			current = head;
		} else {
			ListNode prev = null;
			ListNode temp = head;
			while (temp != null && temp != current) {
				prev = temp;
				temp = temp.next;
			}
			if (temp == null) {
				System.out.println("Element not found.");
				return;
			}
			prev.next = temp.next;
			current = temp.next;
		}

	}
}
/*
@Override
public void add(String item)
{
	if(current != null)
	{
		Node newNode = new Node(item, current.next);
		current.next = newNode;
		current = newNode;
	}
	else
	{
		head = tail = new Node(item, null);
		curr = head;
	}
}

 */
public class Driver {

	public static <T> void printList(List<T> list) {
		if (list.isEmpty()) {
			System.out.println("List is empty.");
			return;
		}
		LinkedList<T>.ListNode temp = ((LinkedList<T>) list).head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}
/*
	public static void main(String[] args) {
		List<String> l = new LinkedList<>();
		l.insert("Michael");
		l.insert("Sean");
		System.out.println(l.retrieve());
		l.findFirst();
		l.insert("Stephen");
		l.findNext();
		System.out.println(l.retrieve());

		//printList(l);
	}
}
 */


