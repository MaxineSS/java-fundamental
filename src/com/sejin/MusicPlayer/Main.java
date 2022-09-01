package com.sejin.MusicPlayer;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
  private static ArrayList<Album> albums = new ArrayList<Album>();
  public static void main(String[] args) {

    // start music player
    Album album = new Album("Scenic Drive (The Tape)", "Khalid", "2021");
    album.addSong("Backseat", 2.54);
    album.addSong("Open (feat. Majid Jordan)", 3.47);
    album.addSong("Present", 2.36);
    albums.add(album);

    album = new Album("Intimacy", "Alex Kehm", "2022");
    album.addSong("Here with me", 2.23);
    album.addSong("Face", 3.22);

    albums.add(album);
    LinkedList<Song> playlist = new LinkedList<Song>();
    albums.get(0).addToPlayList("Backseat", playlist);
    albums.get(1).addToPlayList(2, playlist);
    System.out.println(playlist);
    // quit
    // skip forward to next song
    // skip backward to a previous song
    // replay current song
  }\]
}