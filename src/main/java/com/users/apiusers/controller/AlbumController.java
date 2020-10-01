package com.users.apiusers.controller;

import com.users.apiusers.dto.AlbumDto;
import com.users.apiusers.services.AlbumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

@RestController
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @PostMapping(value = "/album", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Servicio para registrar un nuevo album", response = AlbumDto.class, tags = "Registrar album",
            notes = "Devuelve un objeto tipo AlbumDto con todos sus valores (id, title, usuarios)")
    public @ResponseBody AlbumDto registrarAlbum(@RequestBody AlbumDto albumDto){
        return albumService.registrarAlbum(albumDto);
    }

    @ApiOperation(value = "Servicio para actualizar album", response = AlbumDto.class, tags = "Actualizar album",
            notes = "Devuelve un objeto tipo AlbumDto con todos sus valores (id, title, usuarios)")
    @PutMapping(value = "/album", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public @ResponseBody AlbumDto actualizaralbum(@RequestBody AlbumDto albumDto){
        return albumService.actualizarAlbum(albumDto);
    }

}
