package com.users.apiusers.controller;

import com.users.apiusers.dto.AlbumDto;
import com.users.apiusers.dto.UserDto;
import com.users.apiusers.services.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Servicio para registrar un nuevo usuario", response = UserDto.class, tags = "Registrar usuario",
            notes = "Devuelve un objeto tipo UserDto con todos sus valores (id, name, username, email, permits, albumsByUsers)")
    @PostMapping(value = "/user", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public @ResponseBody UserDto registrarUsuario(@RequestBody UserDto userDto){
        return userService.registrarUsuario(userDto);
    }

    @ApiOperation(value = "Servicio para listar usuarios con sus albunes ", response = UserDto.class, tags = "Listar usuarios",
            notes = "Devuelve una lista usuarios con sus albunes y sus permisos")
    @GetMapping(value = "/user", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public @ResponseBody List<UserDto> listarUsuarios(){
        return userService.listarUsuarios();
    }

    @ApiOperation(value = "Servicio para actualizar un nuevo usuario ", response = UserDto.class, tags = "Actualizar usuario",
            notes = "Devuelve un objeto tipo UserDto con todos sus valores actualizados (id, name, username, email, permits, albumsByUsers)")
    @PutMapping(value = "/user", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public @ResponseBody UserDto actualizarUsuario(@RequestBody UserDto userDto){
        return userService.actualizarUsuario(userDto);
    }

}
