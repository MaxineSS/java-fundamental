package com.sejin.MusicPlayer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.time.LocalDate;

public class Album {
  private String title;
  private String artist;
  private String release;
  private ArrayList<Song> songs;

  public Album(String title, String artist, String release) {
    this.title = title;
    this.artist = artist;
    this.release = release;
    this.songs = new ArrayList<Song>();
  }

  // add song to this album
  public boolean addSong(String title, double duration) {
    // add this song to the playlist, if doesn't exist in the list
    if(findSong(title) == null) {
      this.songs.add(new Song(title, duration));
    }
    return false;
  }
  // delete song from this album

  private Song findSong(String title) {
    for (Song song : this.songs) {
      if(song.getTitle().equals(title)) {
        return song;
      }
    }
    return null;
  }

  // add a song to this playlist by track number
  public boolean addToPlayList(int trackNum, LinkedList<Song> playlist) {
    int index = trackNum - 1;
    if(index >= 0 && index <= this.songs.size()) {
      this.songs.get(index);
      return true;
    }
    System.out.println("This album does not have a track" + trackNum);
    return false;
  }
  // add a song to this playlist by track title
  public boolean addToPlayList(String title, LinkedList<Song> playlist) {
    Song foundSong = findSong(title);
    if(foundSong != null){
      playlist.add(foundSong);
      return true;
    }
    System.out.println("This song title " + title + " is not in this album");
    return false;
  }

}