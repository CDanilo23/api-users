package com.users.apiusers.db.constructor;

import com.users.apiusers.db.entities.Album;
import com.users.apiusers.db.entities.Usuario;
import com.users.apiusers.dto.AlbumDto;
import com.users.apiusers.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserBuilder {

    public UserDto userEntityToDto(Usuario usuario){
        return UserDto.builder().id(usuario.getId()).name(usuario.getName()).email(usuario.getEmail()).username(usuario.getUsername())
                .albumsByUsers(usuario.getAlbumsByUsers().parallelStream().map(albumDto -> AlbumDto.builder().title(albumDto.getTitle()).build()).collect(Collectors.toList())).build();
    }

    public Usuario userDtoToEntity(UserDto userDto){
        return Usuario.builder().name(userDto.getName()).email(userDto.getEmail()).username(userDto.getUsername())
                .albumsByUsers(userDto.getAlbumsByUsers().parallelStream().map(albumEntity -> Album.builder().title(albumEntity.getTitle()).build()).collect(Collectors.toList())).build();
    }
}
