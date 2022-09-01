package com.sejin.MusicPlayer;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
  private static final String HEADPHONE = "\uD83C\uDFA7";
  private static ArrayList<Album> albums = new ArrayList<Album>();
  public static void main(String[] args) {

    Album album = new Album("Scenic Drive (The Tape)", "Khalid", "2021");
    album.addSong("Backseat", 2.54);
    album.addSong("Open (feat. Majid Jordan)", 3.47);
    album.addSong("Present", 2.36);

    albums.add(album);

    album = new Album("Intimacy", "Alex Kehm", "2022");
    album.addSong("Here with me", 2.23);
    album.addSong("Face", 3.22);
    albums.add(album);

    PlayList current_playlist = new PlayList("Discover Weekely");

    albums.get(0).addToPlayList("Backseat", current_playlist);
    albums.get(0).addToPlayList("Open (feat. Majid Jordan)", current_playlist);
    albums.get(0).addToPlayList("Present", current_playlist);
    albums.get(1).addToPlayList(1, current_playlist);
    albums.get(1).addToPlayList(2, current_playlist);

    play(current_playlist);
  }
  public static boolean play(PlayList playlist) {
    try (Scanner scanner = new Scanner(System.in)) {
      ListIterator<Song> t = playlist.traverse();
      boolean quit = false;
      boolean forward = true;

      if(playlist.size() == 0) {
        System.out.println("No songs in the playlist");
        return false;
      } else {
        System.out.println("Now playing " + t.next().toString());
        printMenu();
      }
      while(!quit) {
        int action = scanner.nextInt();
        scanner.nextLine();

        switch (action) {
          case 0:
            // quit
            System.out.println("Stopping player...");
            quit = true;
            break;
          case 1:
            // skip forward to next song
            if(!forward) {
              t.next();
              forward = true;
            }
            if(t.hasNext()) {
              System.out.println("Now playing " + t.next().toString());
            } else {
              System.out.println("We are at the end of the playlist");
              forward = false;
            }
            break;
          case 2:
            // skip backward to a previous song
            if(forward) {
              t.previous();
              forward = false;
            }
            if(t.hasPrevious()){
              System.out.println("Now playing " + t.previous().toString());
            } else {
              System.out.println("We are at the start of the playlist");
              forward = true;
            }
            break;
          case 3:
          // replay current song
            if(forward) {
              if(t.hasPrevious()) {
                System.out.println("Now replaying " + t.previous().toString());
                forward = false;
              } else {
                System.out.println("We are at the start of the playlist");
              }
            } else {
              if(t.hasNext()){
                System.out.println("Now replaying " + t.next().toString());
                forward = true;
              } else {
                System.out.println("We are at the end of the playlist");
              }
            }
            break;
          case 4:
            // List songs in the playlist
            playlist.listSongs();
            break;
          case 5:
            // Delete current song from playlist
            if(playlist.size() > 0) {
              t.remove();
              if(t.hasNext()) {
                System.out.println("Now playing " + t.next());
              } else if(t.hasPrevious()) {
                  System.out.println("Now playing " + t.previous());
              }
            }
            break;
          case 6:
            // Print available actions1
            printMenu();
            break;
          case 7:
          // shuffle play
            break;
        }
      }
    } catch (Exception e) {
      System.out.println("Error message: " + e);
    }
    return true;
  }
  private static void printMenu() {
    System.out.println("Available actions: \n<Press>");
    System.out.println(
    "0\tQuit\n" +
    "1\tPlay next song\n" +
    "2\tPlay previous song\n" +
    "3\tReplay current song\n" +
    "4\tList songs in the playlist\n" +
    "5\tDelete current song from playlist\n" +
    "6\tPrint available actions\n" +
    "7\tShuffle play\n"
    );
  }
}