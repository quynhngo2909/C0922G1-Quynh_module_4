package com.ss08.song_management.service;

import com.ss08.song_management.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISongService extends  IGeneralService<Song> {
    Page<Song> findSongByArtistContaining(String artist, Pageable pageable);
}
