package com.ss08.song_management.repository;

import com.ss08.song_management.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISongRepository extends JpaRepository<Song, Integer> {
    Page<Song> findSongByArtistContaining(String artist, Pageable pageable);
}
