package com.users.apiusers.db.dao;

import com.users.apiusers.db.entities.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumDaoRepository extends JpaRepository<Album, Long> {

}
