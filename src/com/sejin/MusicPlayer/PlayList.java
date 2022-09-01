package com.sejin.MusicPlayer;

import java.util.LinkedList;
import java.util.ListIterator;

public class PlayList {
  private String title;
  private LinkedList<Song> playlist;

  public PlayList(String title) {
    this.title = title;
    this.playlist = new LinkedList<Song>();
  }

  // list songs from this playlist
  public void listSongs() {
    ListIterator<Song> list = this.playlist.listIterator();

    while(list.hasNext()) {
      System.out.printf(
        "[%d] %s\n",
       list.nextIndex(), list.next().toString());
    }
    System.out.println("\n------End of the list\n" +
                      this.playlist.size() + " songs");
  }

  public void add(Song song) {
    this.playlist.add(song);
  }
  public void delete() {
    this.playlist.remove();
  }
  public int size() {
    return this.playlist.size();
  }

  public ListIterator<Song> traverse() {
    ListIterator<Song> listIterator = playlist.listIterator();
    return listIterator;
  }
}