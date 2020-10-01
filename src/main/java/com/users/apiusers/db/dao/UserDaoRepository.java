package com.users.apiusers.db.dao;

import com.users.apiusers.db.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDaoRepository extends JpaRepository<Usuario,Long> {
    @Query(
            value = "select * from  users_albums", nativeQuery = true
    )
    Object[] obtenerUsuariosAlbunes();
}
