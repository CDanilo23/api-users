package com.users.apiusers.dto;

import com.users.apiusers.db.entities.Album;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UserDto {

    private Long id;
    private String name;
    private String username;
    private String email;
    private boolean write;
    private boolean read;
    private List<AlbumDto> albumsByUsers;
}
