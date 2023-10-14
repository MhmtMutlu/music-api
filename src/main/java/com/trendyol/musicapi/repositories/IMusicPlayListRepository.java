package com.trendyol.musicapi.repositories;

import com.trendyol.musicapi.entities.MusicPlayList;

import java.util.List;

public interface IMusicPlayListRepository {
    void removeMusicById(Long musicId, Long playListId);
    void addMusicById(Long musicId, Long playListId);
    MusicPlayList getPlayListById(Long playListId);
    List<MusicPlayList> getAllPlayLists();
}
