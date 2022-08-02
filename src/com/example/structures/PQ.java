package com.example.structures;
import com.example.objects.Song;

public class PQ {

    private Song[] heap;

    private int size;

    public PQ(int capacity) {
        if (capacity < 1) throw new IllegalArgumentException();
        this.heap = new Song[capacity + 1];
        this.size = 0;
    }

    public void insert(Song song) {
        if (song == null) throw new IllegalArgumentException();
        if (size == heap.length - 1) throw new IllegalStateException();
        heap[++size] = song;
        swim(size);
        if (size > (heap.length * 3) / 4) {
            resize();
        }
    }

    //Doubles the heap size
    public void resize() {
        Song[] s = new Song[heap.length * 2];
        if (heap.length - 1 >= 0) System.arraycopy(heap, 1, s, 1, heap.length - 1);
        heap = s;
    }

    public int size(){
        int s = 0;
        for(int i=1; i<= size; i++){
            s++;
        }
        return s;
    }

    public Song getMax() {
        if (empty()) throw new IllegalStateException();
        Song song = heap[1];
        if (size > 1) heap[1] = heap[size];
        heap[size--] = null;
        sink();
        return song;
    }

    private void swim(int i) {
        while (i > 1) {
            int p = i / 2;
            int result = heap[i].compareTo(heap[p]);
            if (result < 0) return;
            swap(i, p);
            i = p;
        }
    }

    private void sink() {
        int left = 2, right = left + 1, max = left;

        while (left <= size) {

            if (right <= size) {
                max = heap[left].compareTo(heap[right]) < 0 ? right : left;
            }

            if (heap[1].compareTo(heap[max]) >= 0) return;
            swap(1, max);
            left = 2 * max;
            right = left + 1;
            max = left;
        }
    }

    private void swap(int i, int j) {
        Song tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    public void print() {
        for (int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    boolean empty() {
        return size == 0;
    }

    public Song remove(int id) {

        int c = 0;
        for (int i = 1; i <= size; i++) {
            if (id == heap[i].getId()) {
                c++;
                swap(i, 1);
                break;
            }
        }
        if (c == 0) {
            System.out.print("Invalid ID!!!");
            return null;
        }
        else {
        	return getMax();
        }
    }
    
    public int check(Song song) {

        int c = 0;
        int c2 = 0;
        int temp = 0;
        Song maxSong = heap[1];
        int max = song.compareDF(heap[1]);
        
        for (int i = 1; i <= size(); i++) {
            if (song.compareTo(heap[i]) > 0) {
            	c++;
            	
            	if( song.compareDF(heap[i]) > max) {
            		temp = i;
            		max = song.compareDF(heap[i]);
            		maxSong = heap[i];
            		c2++;
            	}
            	else {
            		if (song.compareDF(heap[i]) == max) {
            			if (heap[i].compareTo(maxSong) < 0) {
            				temp = i;
            			}
            		}
            	}
            }
        }
        
        if(c2 > 0 ) {
        	remove(heap[temp].getId());
        }
        else {
        	if(c > 0) {
        		remove(heap[1].getId());
        	}
        }
        
        return c;
    }
}
