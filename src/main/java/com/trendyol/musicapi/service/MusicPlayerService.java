package com.trendyol.musicapi.service;

import com.trendyol.musicapi.entities.Music;
import com.trendyol.musicapi.entities.MusicPlayList;
import com.trendyol.musicapi.repositories.IMusicPlayListRepository;
import com.trendyol.musicapi.repositories.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicPlayerService implements IMusicPlayerService{
    private final IMusicRepository musicRepository;
    private final IMusicPlayListRepository musicPlayListRepository;

    @Autowired
    public MusicPlayerService(IMusicRepository musicRepository, IMusicPlayListRepository musicPlayListRepository) {
        this.musicRepository = musicRepository;
        this.musicPlayListRepository = musicPlayListRepository;
    }

    @Override
    public void removeMusicById(Long musicId, Long playListId) {
        musicPlayListRepository.removeMusicById(musicId, playListId);
    }

    @Override
    public void addMusicById(Long musicId, Long playListId) {
        musicPlayListRepository.addMusicById(musicId, playListId);
    }

    @Override
    public MusicPlayList getPlayListById(Long playListId) {
       return musicPlayListRepository.getPlayListById(playListId);
    }

    @Override
    public List<MusicPlayList> getAllPlayLists() {
       return musicPlayListRepository.getAllPlayLists();
    }

    @Override
    public List<Music> findAllMusics() {
        return musicRepository.findAllMusics();
    }

    @Override
    public Music findById(Long id) {
       return musicRepository.findById(id);
    }
}
