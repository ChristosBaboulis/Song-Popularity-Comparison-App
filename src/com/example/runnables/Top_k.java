package com.example.runnables;

import com.example.structures.ListForSongs;
import com.example.objects.Song;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Top_k {

	public static void main(String[] args) {

		String path= null;
		String line;

		File f;
		FileReader fr;
		BufferedReader br = null;

		ListForSongs SongList = new ListForSongs();
		Song song;
		Song top = new Song(0,999999999,"Aaaaa");
		
		if (0 < args.length) {
			   path = args[0];
			} else {
			   System.err.println("Invalid arguments count:" + args.length);
			   System.exit(1);
			}

		try {
			f = new File(path);
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			line = br.readLine();
			
			int indexFirstSpace;
			int indexSecondSpace;
			int indexSecondSpaceFinal = 0;
			int ID;
			String Title;
			int Likes;
			
			while(line != null) {
				indexFirstSpace = line.indexOf(" ");
				ID = Integer.parseInt( line.substring(0, indexFirstSpace) );
				
				indexSecondSpace = line.indexOf(" ", indexFirstSpace + 1);
				while(indexSecondSpace > 0) {
					indexSecondSpaceFinal = indexSecondSpace;
					indexSecondSpace = line.indexOf(" ", indexSecondSpace + 1);
				}
				
				Title = line.substring( indexFirstSpace + 1, indexSecondSpaceFinal );
				Likes = Integer.parseInt( line.substring(indexSecondSpaceFinal + 1).trim() );
				
				song = new Song(ID, Likes, Title);
				SongList.put(song);

				line = br.readLine();
			}
			SongList.put(top);
			SongList.mergesort(SongList.getFirstNode());
			SongList.get();

			boolean flag = true;
			int k;
			while(flag) {
				try {
					System.out.println("Enter number of top songs you want to see: ");
					Scanner in = new Scanner(System.in);
					k = in.nextInt();
					if (k > SongList.size()) {
						k = SongList.size();
						System.out.print("Invalid Number, list has "+SongList.size()+" songs: \n");
					}
					in.close();
				}catch (java.util.InputMismatchException e) {
					System.err.println("No number inserted\n");
					continue;
				}

				if (k > SongList.size()) {
					System.out.print("Invalid Number, list is shorter\n");
				} else {
					flag = false;
					System.out.print("The top " + k + " songs are:\n\n");
					for (int i = 0; i < k; i++) {
						System.out.println(SongList.get().getTitle() + "\n");
					}
				}
			}
		}
		catch (IOException e) {
			System.err.println("Error opening file!");
		}
		
		try {
			br.close();
		}
		catch(IOException e){
			System.err.println("Error closing file.");
		}

	}
}
