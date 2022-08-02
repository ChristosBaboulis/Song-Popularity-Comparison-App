package com.example.runnables;

import com.example.objects.Song;
import com.example.structures.PQ;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Top_k_withPQ {
	
	public static void main(String[] args){

        String path= null;
        String line;
        File f;
        FileReader fr;
        BufferedReader br = null;

        Song song;

        int k = 0;
        boolean flag = true;
        while (flag){
            try{
                System.out.println("Enter number of top songs you want to see: ");
                Scanner in = new Scanner(System.in);
                k = in.nextInt();
                while (k <= 0)
                {
                    //Scanner in = new Scanner(System.in);
                    System.out.println("Invalid number, please enter a positive Integer: ");
                    k = in.nextInt();
                    //in.close();
                }
                flag = false;
                in.close();
            }catch (java.util.InputMismatchException e) {
                System.err.println("No number inserted\n");
                flag = true;
            }
        }

		PQ SongList = new PQ(2*k);

        if (0 < args.length) {
            path = args[0];
        } else {
            System.err.println("\nInvalid arguments count:" + args.length);
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
                ID = Integer.parseInt(line.substring(0, indexFirstSpace).trim() );

                indexSecondSpace = line.indexOf(" ", indexFirstSpace + 1);
                while(indexSecondSpace > 0) {
                    indexSecondSpaceFinal = indexSecondSpace;
                    indexSecondSpace = line.indexOf(" ", indexSecondSpace + 1);
                }

                Title = line.substring(indexFirstSpace + 1, indexSecondSpaceFinal).trim();
                Likes = Integer.parseInt(line.substring(indexSecondSpaceFinal + 1).trim());

                song = new Song(ID, Likes, Title);

                line = br.readLine();
                
                if(SongList.size() < k)
                {
                	SongList.insert(song);
                }
                else
                {
                	if(SongList.check(song) > 0){
                		
                		SongList.insert(song);
                		
                	}
                }
            }

            Song maxS;

            if(k > SongList.size()) {
                k = SongList.size();
                System.out.println("Size longer than list, showing all list...\n");
            }
            System.out.print("The top " + k + " songs are:\n\n");
            for (int i = 0; i < k; i++) {
                maxS = SongList.getMax();
                System.out.print(maxS);
            }

        }
        catch (IOException e) {
            System.err.println("Error opening file!"+k);
        }

        try {
            if(br != null) {
                br.close();
            }
        }
        catch(IOException e){
            System.err.println("Error closing file.");
        }

    }
}
