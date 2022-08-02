# Song-Popularity-Comparison-App
USE:


- This Java program takes as an input a list of songs with Id, Name, Likes and sorts and prints to the user the selected number of songs sorted by popularity using custom lists, merge sort method and custom priority queues.
- I also uses priority queues to find the median value of a queue dynamically
- Runnables: 
 
Top_k: Finds the top k songs from a list of songs (where k defined by input)
Top_k_with_PQ: Uses priority queues and finds in real time the top song from the list up to the line that it has read
Dynamic_Median: Finds dynamically every 5 songs added to the list the median song sorted by popularity

INFO:

- It takes the list as an input from a txt file named "Songs.txt". File format has to be strictly like this:

ID Name Likes

114 Fuego 51

313 Despacito 63

22 Bitter Sweet Symphony 71

812 The Passenger 63

9 Daddy Cool 78

- It contains to runnable classes

Top_k which shows the k selected songs but has to save first the whole file with the songs to do so
Top_k_with_PQ which knows dynamically the top k selected songs up to the line that has been read from the file using priority queue

HOW TO RUN:

Intellij: You have to pass the txt file as an argument on the main method: Run -> Edit Configurations -> + -> Application -> Give a name -> Give main class name (Top_k/Top_k_with_PQ) -> Give program arguments (Files\Songs.txt) -> OK File "Songs.txt" has to be in Files folder (outside of src file)

CMD: "Songs.txt" file must be in src folder

Go to java files folder through cmd navigation ( cd ) -> javac *.java -> java Top_k/Top_k_with_PQ Songs.txt


![Screenshot_2](https://user-images.githubusercontent.com/48126722/182360632-bbea735c-9a20-4b06-8cf8-1dd2760d4b6b.png)


![Screenshot_3](https://user-images.githubusercontent.com/48126722/182360639-a8706968-6143-41b2-ab3c-d38f5a4c7f0e.png)

Running on: jdk-11.0.11
