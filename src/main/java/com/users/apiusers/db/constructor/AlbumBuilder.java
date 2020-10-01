package com.users.apiusers.db.constructor;

import com.users.apiusers.db.entities.Album;
import com.users.apiusers.db.entities.Usuario;
import com.users.apiusers.dto.AlbumDto;
import com.users.apiusers.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AlbumBuilder {

    public AlbumDto userEntityToDto(Album album){
        return AlbumDto.builder().id(album.getId()).title(album.getTitle()).usuarios(album.getUsuarios().parallelStream()
                .map( user -> UserDto.builder().id(user.getId()).name(user.getName()).username(user.getUsername())
                        .email(user.getEmail()).write(user.isWrite()).read(user.isRead()).build()).collect(Collectors.toList())).build();
    }

    public Album userDtoToEntity(AlbumDto albumDto){
        return Album.builder().id(albumDto.getId()).title(albumDto.getTitle()).usuarios(albumDto.getUsuarios().parallelStream()
        .map(userDto -> Usuario.builder().id(userDto.getId()).name(userDto.getName()).email(userDto.getEmail()).write(userDto.isWrite())
                .read(userDto.isRead()).username(userDto.getUsername()).build()).collect(Collectors.toList())).build();
    }

}
