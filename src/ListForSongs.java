import java.util.NoSuchElementException;

public class ListForSongs {
	ListNode firstNode;
	ListNode lastNode;
	String name;
    	
	public ListForSongs(){
		this("Queue");
	}
	
	public ListForSongs(String QueueName) {
		name = QueueName;
		firstNode = lastNode = null;
	}
	
	public boolean isEmpty() {
		return firstNode == null;
	}

	public ListNode mergesort(ListNode node) {

	 if (node == null || node.next == null){
	     return node;
     }
		ListNode middle = middleNode(node);
	    ListNode secondhalf = middle.next;
	    middle.next = null;
		return merge(mergesort(node), mergesort(secondhalf));
	}

    public ListNode middleNode(ListNode node){
        if(node == null){
            return null;
        }

        ListNode a = node;
        ListNode b = node.next;

        while ((b != null) && (b.next != null)) {
            a = a.next;
            b = b.next.next;
        }

        return a;
    }

	static ListNode merge(ListNode a, ListNode b) {
		ListNode temp = new ListNode(null); //fake node creation
		ListNode finalList = temp;
		while ((a != null) && (b != null)) {
			if (a.getSong().compareTo(b.getSong()) > 0) {
				temp.next = a;
				a = a.next;
			} else {
				temp.next = b;
				b = b.next;
			}
			temp = temp.next;
		}
		temp.next = (a == null) ? b : a;
		return finalList.next; //return list without fake node
	}

	public void put( Song Item )
	{
		ListNode node = new ListNode( Item );
		if ( isEmpty() ) { 
		firstNode = lastNode = node;
		}
		else { 
			node.next = firstNode;
			firstNode = node;
		}
	}

	public Song get() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException(name);
		}
		Song removedNode = firstNode.data;

		firstNode = firstNode.next;
		
		return removedNode;
	}

	public Song peek() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException(name);
		}
		
		Song returnedNode = firstNode.data;
		return returnedNode;
	}

	public void print()
	{
		if ( isEmpty() )
		{
			System.out.printf( "Empty %s\n", name );
			return;
		}

		System.out.printf( "The %s is: \n", name );
		ListNode current = firstNode;

		while ( current != null )
		{
			System.out.printf( "%s ", current.data );
			current = current.next;
		} 

		System.out.println( "\n" );
	}

	public int size() {
		if (isEmpty()) {
			return 0;
		}
		
		ListNode current = firstNode;
		int i = 0;
		while ( current != null )
		{
			i++;
			current = current.next;
		}
		return i;
	}
}
