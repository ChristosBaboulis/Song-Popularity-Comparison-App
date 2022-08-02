package com.example.structures;

import com.example.objects.Song;
import com.example.objects.ListNode;

import java.util.List;
import java.util.NoSuchElementException;

public class ListForSongs {
	private ListNode firstNode;
	private ListNode lastNode;
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

	 if (node == null || node.getNext() == null){
	     return node;
     }
		ListNode middle = middleNode(node);
	    ListNode secondHalf = middle.getNext();
	    middle.setNext(null);
		return merge(mergesort(node), mergesort(secondHalf));
	}

    public ListNode middleNode(ListNode node){
        if(node == null){
            return null;
        }

        ListNode a = node;
        ListNode b = node.getNext();

        while ((b != null) && (b.getNext() != null)) {
            a = a.getNext();
            b = b.getNext().getNext();
        }

        return a;
    }

	static ListNode merge(ListNode a, ListNode b) {
		ListNode temp = new ListNode(null); //fake node creation
		ListNode finalList = temp;
		while ((a != null) && (b != null)) {
			if (a.getSong().compareTo(b.getSong()) > 0) {
				temp.setNext(a);
				a = a.getNext();
			} else {
				temp.setNext(b);
				b = b.getNext();
			}
			temp = temp.getNext();
		}
		temp.setNext((a == null) ? b : a);
		return finalList.getNext(); //return list without fake node
	}

	public void put( Song Item )
	{
		ListNode node = new ListNode( Item );
		if ( isEmpty() ) { 
		firstNode = lastNode = node;
		}
		else { 
			node.setNext(firstNode);
			firstNode = node;
		}
	}

	public Song get() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException(name);
		}
		Song removedNodeData = firstNode.getSong();

		firstNode = firstNode.getNext();
		
		return removedNodeData;
	}

	public Song peek() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException(name);
		}

		return firstNode.getSong();
	}

	public ListNode getFirstNode() {
		return firstNode;
	}

	public ListNode getLastNode(){
		return lastNode;
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
			System.out.printf( "%s ", current.getSong() );
			current = current.getNext();
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
			current = current.getNext();
		}
		return i;
	}
}
