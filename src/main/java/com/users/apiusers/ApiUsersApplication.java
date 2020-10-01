package com.users.apiusers;

import com.users.apiusers.db.dao.AlbumDaoRepository;
import com.users.apiusers.db.dao.UserDaoRepository;
import com.users.apiusers.db.entities.Album;
import com.users.apiusers.db.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ApiUsersApplication implements CommandLineRunner {

	@Autowired
	UserDaoRepository userDaoRepository;

	@Autowired
	AlbumDaoRepository albumDaoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiUsersApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		userDaoRepository.save(Usuario.builder().name("Cristian").email("algo@algo").username("ElCdo").albumsByUsers(Arrays.asList(Album.builder().title("Cien años ..").build())).build());

		userDaoRepository.findAll().forEach(user -> {
			System.out.println("Id:" +user.getId());
			System.out.println("Email: " +user.getEmail());
			System.out.println("Name: " +user.getName());
			System.out.println("Username: " +user.getUsername());
			user.getAlbumsByUsers().forEach(album -> {
				System.out.println("Albunes por usuario: " + album.getId() + " Titulo: " + album.getTitle());
			});
		});
	}
}
