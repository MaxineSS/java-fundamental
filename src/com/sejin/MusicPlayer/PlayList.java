package com.sejin.MusicPlayer;

import java.util.LinkedList;
import java.util.ListIterator;

public class PlayList {
  private String title;
  private LinkedList<Song> playList;

  public PlayList(String title, LinkedList<Song> playList) {
    this.title = title;
    this.playList = playList;
  }

  // add song to this playlist
  public boolean addSong(Song song) {

  }
  // delete song from this playlist
  public boolean removeSong(Song song){

  }
  // list songs from this playlist
  public void listSongs(LinkedList<Song> myPlayList) {
    ListIterator<Song> list = myPlayList.listIterator();

    while(list.hasNext()) {
      System.out.printf(
        "[%d] Title: %s, Duration: %d",
       list.nextIndex(), list.next().getTitle(), list.next().getDuration());
    }
    System.out.println("------End of the list");
  }
}