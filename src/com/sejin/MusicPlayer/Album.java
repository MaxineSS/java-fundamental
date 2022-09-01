package com.sejin.MusicPlayer;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
  private String title;
  private String artist;
  private String release;
  private ArrayList<Song> songs;
  private int numberOfSongs;

  public Album(String title, String artist, String release) {
    this.title = title;
    this.artist = artist;
    this.release = release;
    this.songs = new ArrayList<Song>();
  }

  @Override
  public String toString() {
    return this.songs.size() + " songs";
  }

  // add song to this album
  public boolean addSong(String title, double duration) {
    if(findSong(title) == null) {
      this.songs.add(new Song(title, duration));
    }
    return false;
  }

  private Song findSong(String title) {
    for (Song song : this.songs) {
      if(song.getTitle().equals(title)) {
        return song;
      }
    }
    return null;
  }

  // delete song from this playlist by track number
  public boolean removeFromPlayList(int trackNum, LinkedList<Song> playlist){
    int index = trackNum - 1;
    if(index >= 0 && index <= this.songs.size()){
      playlist.remove(this.songs.get(index));
      return true;
    }
    return false;
  }
  // delete song from this playlist by track title
  public boolean removeFromPlayList(String title, LinkedList<Song> playlist){
    Song foundSong = findSong(title);
    if(foundSong != null) {
      playlist.remove(foundSong);
      return true;
    }
    System.out.println("This song title " + title + " is not in this album");
    return false;
  }

  // add a song to this playlist by track number
  public boolean addToPlayList(int trackNum, PlayList playlist) {
    int index = trackNum - 1;
    if(index >= 0 && index <= this.songs.size()) {
      playlist.add(this.songs.get(index));
      return true;
    }
    System.out.println("This album does not have a track" + trackNum);
    return false;
  }
  // add a song to this playlist by track title
  public boolean addToPlayList(String title, PlayList playlist) {
    Song foundSong = findSong(title);
    if(foundSong != null){
      playlist.add(foundSong);
      return true;
    }
    System.out.println("This song title " + title + " is not in this album");
    return false;
  }

}