package com.users.apiusers.services;

import com.users.apiusers.db.constructor.UserBuilder;
import com.users.apiusers.db.dao.UserDaoRepository;
import com.users.apiusers.db.entities.Usuario;
import com.users.apiusers.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserDaoRepository userDaoRepository;

    @Autowired
    UserBuilder userBuilder;

    public UserDto registrarUsuario(UserDto userDto) {
        return userBuilder.userEntityToDto(userDaoRepository.save(userBuilder.userDtoToEntity(userDto)));
    }
    public List<UserDto> listarUsuarios(){
        return userDaoRepository.findAll().parallelStream().map(entity -> userBuilder.userEntityToDto(entity)).collect(Collectors.toList());
    }

    public UserDto actualizarUsuario(UserDto userDto) {
        if(userDaoRepository.findById(userDto.getId()).isPresent()){
            Usuario usuario = userDaoRepository.findById(userDto.getId()).get();
            usuario.setName(userDto.getName());
            usuario.setUsername(userDto.getUsername());
            usuario.setEmail(userDto.getEmail());
            usuario.setRead(userDto.isRead());
            usuario.setWrite(userDto.isWrite());
            userDaoRepository.save(usuario);
            return userBuilder.userEntityToDto(usuario);
        }else{
            return new UserDto();
        }
    }

}

