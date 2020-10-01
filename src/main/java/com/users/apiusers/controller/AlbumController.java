package com.users.apiusers.controller;

import com.users.apiusers.dto.AlbumDto;
import com.users.apiusers.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @PostMapping(value = "/album", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public @ResponseBody AlbumDto registrarAlbum(@RequestBody AlbumDto albumDto){
        return albumService.registrarAlbum(albumDto);
    }

    @PutMapping(value = "/album", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public @ResponseBody AlbumDto actualizaralbum(@RequestBody AlbumDto albumDto){
        return albumService.actualizarAlbum(albumDto);
    }

}
