package com.users.apiusers.services;

import com.users.apiusers.db.constructor.AlbumBuilder;
import com.users.apiusers.db.dao.AlbumDaoRepository;
import com.users.apiusers.db.entities.Album;
import com.users.apiusers.db.entities.Usuario;
import com.users.apiusers.dto.AlbumDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class AlbumService {

    @Autowired
    AlbumDaoRepository albumDaoRepository;

    @Autowired
    AlbumBuilder albumBuilder;

    public AlbumDto registrarAlbum(AlbumDto albumDto){
       return albumBuilder.userEntityToDto(albumDaoRepository.save(albumBuilder.userDtoToEntity(albumDto)));
    }

    public AlbumDto actualizarAlbum(AlbumDto albumDto){
        if(albumDaoRepository.findById(albumDto.getId()).isPresent()){
            Album album = albumDaoRepository.findById(albumDto.getId()).get();
            album.setId(albumDto.getId());
            album.setTitle(albumDto.getTitle());
            album.setUsuarios(albumDto.getUsuarios().parallelStream().map( dto -> Usuario.builder()
                    .id(dto.getId()).name(dto.getName()).username(dto.getUsername()).email(dto.getEmail())
                        .write(dto.isWrite()).read(dto.isRead()).build()).collect(Collectors.toList()));
            return albumBuilder.userEntityToDto(albumDaoRepository.save(album));
        }else {
            return new AlbumDto();
        }
    }



}
