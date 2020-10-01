package com.users.apiusers.controller;

import com.users.apiusers.dto.UserDto;
import com.users.apiusers.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/user", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public @ResponseBody UserDto registrarUsuario(@RequestBody UserDto userDto){
        return userService.registrarUsuario(userDto);
    }

    @GetMapping(value = "/user", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public @ResponseBody List<UserDto> listarUsuarios(){
        return userService.listarUsuarios();
    }

    @PutMapping(value = "/user", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public @ResponseBody UserDto actualizarUsuario(@RequestBody UserDto userDto){
        return userService.actualizarUsuario(userDto);
    }

}
