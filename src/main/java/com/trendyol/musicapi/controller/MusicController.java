package com.trendyol.musicapi.controller;

import com.trendyol.musicapi.entities.Music;
import com.trendyol.musicapi.service.IMusicPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/music")
public class MusicController {
    private final IMusicPlayerService musicPlayerService;

    @Autowired
    public MusicController(IMusicPlayerService musicPlayerService) {
        this.musicPlayerService = musicPlayerService;
    }

    @GetMapping
    public List<Music> findAllMusics() {
        return musicPlayerService.findAllMusics();
    }

    @DeleteMapping("/{musicId}/{playListId}")
    public void removeMusicById(@PathVariable Long musicId, @PathVariable Long playListId) {
        musicPlayerService.removeMusicById(musicId, playListId);
    }
}
