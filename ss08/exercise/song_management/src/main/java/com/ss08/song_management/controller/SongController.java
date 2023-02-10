package com.ss08.song_management.controller;

import com.ss08.song_management.dto.SongDto;
import com.ss08.song_management.model.Song;
import com.ss08.song_management.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    ISongService songService;

    @GetMapping("")
    public String list(Model model,
                       @RequestParam(required = false, defaultValue = "") String artist,
                       @PageableDefault(size = 2, sort = "artist", direction = Sort.Direction.ASC) Pageable pageable){
        model.addAttribute("songs", songService.findSongByArtistContaining(artist, pageable) );
        model.addAttribute("artist", artist );
        return "/song/list";
    }

    @GetMapping("/song-create")
    public String create(Model model){
        model.addAttribute("songDto", new SongDto());
        return "/song/create";
    }
    @PostMapping("/song-save")
    public String save(Model model, @Validated @ModelAttribute SongDto songDto,
                       BindingResult result, RedirectAttributes redirectAttributes){
        new SongDto().validate(songDto, result);
        if(result.hasErrors()){
            model.addAttribute("songDto", songDto);
            return "/song/create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.save(song);
        redirectAttributes.addFlashAttribute("message","New song was added in: " + song.getName() );
        return "redirect:/song";
    }
}
