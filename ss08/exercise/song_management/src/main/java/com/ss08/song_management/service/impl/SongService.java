package com.ss08.song_management.service.impl;

import com.ss08.song_management.model.Song;
import com.ss08.song_management.repository.ISongRepository;
import com.ss08.song_management.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SongService implements ISongService {
    @Autowired
    ISongRepository songRepository;
    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public Page<Song> findSongByArtistContaining(String artist, Pageable pageable) {
        return songRepository.findSongByArtistContaining(artist, pageable);
    }
}
