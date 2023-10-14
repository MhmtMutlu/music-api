package com.trendyol.musicapi.repositories;

import com.trendyol.musicapi.entities.Music;

import java.util.List;

public interface IMusicRepository {
    List<Music> findAllMusics();
    Music findById(Long id);
}
