package com.ss08.song_management.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SongDto implements Validator {
    private int id;
    @NotEmpty(message = "Name must be filled")
    @Size(min = 1, max = 800,message = "Max 800 characters")
    private String name;
    @NotNull(message = "Name must be filled")
    @Size(min = 1, max = 300, message = "Max 300 characters")
    private String artist;
    @NotNull(message = "Name must be filled")
    @Size(min = 1, max = 1000, message = "Max 1000 characters")
    private String type;

    public SongDto() {
    }

    public SongDto(int id, String name, String artist, String type) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;
        String name = songDto.getName();
        if (!name.matches("^[a-zA-Z0-9]+$")) {
            errors.rejectValue("name", "name.matches", "Song's name must not contain special character, such as: @ ; , . = - + , ….");
        }
        String artist = songDto.getArtist();
        if (!artist.matches("^[a-zA-Z0-9]+$")) {
            errors.rejectValue("artist", "artist.matches", "Artist's name must not contain special character, such as: @ ; , . = - + , ….");
        }
        String type = songDto.getType();
        if (!artist.matches("^[a-zA-Z0-9,]+$")) {
            errors.rejectValue("type", "type.matches", "Except comma ',', song type must not contain special character, such as: @ ; . = - + , ….");
        }
    }
}
