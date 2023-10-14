package com.trendyol.musicapi.repositories;

import com.trendyol.musicapi.entities.Music;
import com.trendyol.musicapi.entities.MusicPlayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MusicPlayListRepository implements IMusicPlayListRepository {
    private static Map<Long, MusicPlayList> musicPlayListMap = new HashMap<>();
    private final IMusicRepository musicRepository;

    @Autowired
    public MusicPlayListRepository(IMusicRepository musicRepository) {

        this.musicRepository = musicRepository;
    }

    @Override
    public void removeMusicById(Long musicId, Long playListId) {
        if (musicPlayListMap.containsKey(playListId)) {
            MusicPlayList musicPlayList = musicPlayListMap.get(playListId);
            List<Music> musicList = musicPlayList.getMusicList().stream().filter(music -> !music.getId().equals(musicId)).toList();
            musicPlayList.setMusicList(musicList);
            musicPlayListMap.put(playListId, musicPlayList);
        }
    }

    @Override
    public void addMusicById(Long musicId, Long playListId) {
        if (musicPlayListMap.containsKey(playListId)) {
            MusicPlayList musicPlayList = musicPlayListMap.get(playListId);
            List<Music> musicList = musicPlayList.getMusicList();
            musicList.add(musicRepository.findById(musicId));
            musicPlayList.setMusicList(musicList);
            musicPlayListMap.put(playListId, musicPlayList);
        }
    }

    @Override
    public MusicPlayList getPlayListById(Long playListId) {
        return musicPlayListMap.get(playListId);
    }

    @Override
    public List<MusicPlayList> getAllPlayLists() {
        return musicPlayListMap.values().stream().toList();
    }
}
