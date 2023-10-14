package com.trendyol.musicapi.repositories;

import com.trendyol.musicapi.entities.Music;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MusicRepository implements IMusicRepository {
    private static Map<Long, Music> musicMap = new HashMap<>();
    public MusicRepository() {
        musicMap.put(1L, new Music(1L, "Rastgele"));
        musicMap.put(2L, new Music(2L, "Rastgele2"));
        musicMap.put(3L, new Music(3L, "Rastgele3"));
    }
    @Override
    public List<Music> findAllMusics() {
        return musicMap.values().stream().toList();
    }

    @Override
    public Music findById(Long id) {
        if (musicMap.containsKey(id)) {
           return musicMap.get(id);
        }
        return null;
    }
}
