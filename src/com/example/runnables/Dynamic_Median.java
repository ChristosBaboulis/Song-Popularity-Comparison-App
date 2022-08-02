import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class Dynamic_Median {

    public static void main(String args[]){

        String path= null;
        String line = null;
        File f = null;
        FileReader fr = null;
        BufferedReader br = null;
        Song song = new Song();

        PQ SongList = new PQ(10);
        PQ TempList = new PQ(10);

        if (0 < args.length) {
            path = new String(args[0]);
        } else {
            System.err.println("Invalid arguments count:" + args.length);
            System.exit(1);
        }

        try {
            f = new File(path);
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            line = br.readLine();

            int index = -1;
            int index2 = -1;
            int temp = 0;
            int ID = 0;
            String Title = null;
            int Likes = 0;
            Song median = new Song();
            int sz1=0, sz2=0;
            int counter = 0;

            while(line != null) {
                index = line.indexOf(" ");
                ID = Integer.parseInt(line.substring(0, index).trim() );

                index2 = line.indexOf(" ", index + 1);
                while(index2 > 0) {
                    temp = index2;
                    index2 = line.indexOf(" ", index2 + 1);
                }

                Title = line.substring(index + 1, temp).trim();
                Likes = Integer.parseInt(line.substring(temp + 1).trim());

                song = new Song(ID, Likes, Title);


                SongList.insert(song);
                counter++;
                if (counter % 5 == 0) {
                if(SongList.size() == 1){median = song;}
                if((SongList.size() % 2) == 0){
                    sz1 = SongList.size()/2;
                    for (int i = 1; i < sz1; i++){
                        TempList.insert(SongList.getMax());
                    }
                    median = SongList.Max();
                    sz2 = TempList.size();
                    for (int i = 1; i <= sz2; i++){
                        SongList.insert(TempList.getMax());
                    }
                }
                else{
                    sz1 = SongList.size()/2;
                    for (int i = 1; i <= sz1; i++){
                        TempList.insert(SongList.getMax());
                    }
                    median = SongList.Max();
                    sz2 = TempList.size();
                    for (int i = 1; i <= sz2; i++){
                        SongList.insert(TempList.getMax());
                    }
                }

                
                
                    System.out.print("Median =  " + median.getLikes()+", achieved by Song:   " +median.getTitle());
                    System.out.print("\n\n");                
                }
                line = br.readLine();
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
