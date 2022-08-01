
public class ListNode extends Song {
	Song data;
	ListNode next;

	ListNode(Song data){
		this(data, null);
	}
	
	ListNode(Song data, ListNode next){
		this.data = data;
		this.next = next;
	}
	
	Song getSong() {
		return data;
	}
	
	ListNode getNext() {
		return next;
	}
}
