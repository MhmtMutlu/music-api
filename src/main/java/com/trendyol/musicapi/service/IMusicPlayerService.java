package com.trendyol.musicapi.service;

import com.trendyol.musicapi.entities.Music;
import com.trendyol.musicapi.entities.MusicPlayList;

import java.util.List;

public interface IMusicPlayerService {
    void removeMusicById(Long musicId, Long playListId);
    void addMusicById(Long musicId, Long playListId);
    MusicPlayList getPlayListById(Long playListId);
    List<MusicPlayList> getAllPlayLists();
    List<Music> findAllMusics();
    Music findById(Long id);
}
