
// Filename: RecordingSort.java
// Author: Damian Lester
// Date: 2.13.19
//Application that allows the user to enter data for 5 recordings. Then ask the user how the output of all recordings should be sorted.
//They can sort by artist, song, or playing time .   

import javax.swing.JOptionPane;

public class RecordingSort {
    public static void main(String[] args) {
        // variables and constants
        Recording[] songList = new Recording[5];
        String song, artist;
        int time;
        String order; // use this variable when you ask the user how they want the data sorted

        // for loop which will create the 5 objects that will fill our songList array
        for (int x = 0; x < songList.length; x++) {
            song = JOptionPane.showInputDialog(null, "Enter a song title for recording " + (x + 1));
            artist = JOptionPane.showInputDialog(null, "Enter an artist for recording " + (x + 1));
            time = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter a time for recording " + (x + 1)));

            // Build a recording object with the default constructor
            Recording tempSong = new Recording();
            // Use setter
            tempSong.setSongTitle(song);
            tempSong.setArtist(artist);
            tempSong.setPlayingTime(time);
            songList[x] = tempSong;
        }

        // Ask the user how they want to sort the data
        order = JOptionPane.showInputDialog(null,
                "By which field would you like to sort the data?\n You can sort by song, Artist or time");
        order = order.toUpperCase();

        // Decide which sort option they picked.
        if (order.charAt(0) == 'S') {
            sortBySong(songList);
        } else {
            if (order.charAt(0) == 'A') {
                 sortByArtist(songList);
            } else {
                // sortByTime(songList);
            }
        }

        // Sorting is done by other methods, were ready for output her in the main()
        // method
        String message = "";
        for (int x = 0; x < songList.length; x++) {
            message = message + "\nArtist: " + songList[x].getArtist() + "\nSong: " + songList[x].getSongTitle()
                    + "\nPlaying time: " + songList[x].getPlayingTime();
        }
        JOptionPane.showMessageDialog(null, message);
        // Yay main method is done.program is done
    }

    // This is the method used when the user chooses the data to be sorted by song
    public static void sortBySong(Recording[] array) {
        int a, b;
        Recording temp;
        String stringb, stringbPlus;

        for (a = 0; a < array.length - 1; a++) {
            for (b = 0; b < array.length - 1; b++) {
                stringb = array[b].getSongTitle();
                stringbPlus = array[b + 1].getSongTitle();

                if (stringb.compareTo(stringbPlus) > 0) {
                    temp = array[b];
                    array[b] = array[b + 1];
                    array[b + 1] = temp;
                }
            }
        }
    }

    //This is the method used when the user chooses to sort by the artist.
    public static void sortByArtist(Recording[] array) {
        int a, b;
        Recording temp;
        String stringb, stringbPlus;

        for (a = 0; a < array.length - 1; a++) {
            for (b = 0; b < array.length - 1; b++) {
                stringb = array[b].getArtist();
                stringbPlus = array[b + 1].getArtist();

                if (stringb.compareTo(stringbPlus) > 0) {
                    temp = array[b];
                    array[b] = array[b + 1];
                    array[b + 1] = temp;
                }
            }
        }
    }

    //This is the method used when the user chooses to sort by playing time 
    public static void sortByTime(Recording[] array) {
        int a, b;
        Recording temp;
        String stringb, stringbPlus;

        for (a = 0; a < array.length - 1; a++) {
            for (b = 0; b < array.length - 1; b++) {
                if (array[b].getPlayingTime() > array[b + 1].getPlayingTime()) {
                    temp = array[b];
                    array[b] = array[b + 1];
                    array[b + 1] = temp;
                }
            }
        }
    }
}