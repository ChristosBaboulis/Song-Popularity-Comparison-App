package com.example.objects;

import com.example.objects.Song;

public class ListNode extends Song {
	private Song data;
	private ListNode next;

	public ListNode(Song data){
		this(data, null);
	}
	
	public ListNode(Song data, ListNode next){
		this.data = data;
		this.next = next;
	}
	
	public Song getSong() {
		return data;
	}
	
	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next)
	{
		this.next = next;
	}
}
