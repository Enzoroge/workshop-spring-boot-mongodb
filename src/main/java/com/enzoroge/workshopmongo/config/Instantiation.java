package com.enzoroge.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.enzoroge.workshopmongo.domain.Post;
import com.enzoroge.workshopmongo.domain.User;
import com.enzoroge.workshopmongo.dto.AuthorDto;
import com.enzoroge.workshopmongo.dto.CommentDTO;
import com.enzoroge.workshopmongo.repository.PostRepository;
import com.enzoroge.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		postRepository.deleteAll();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post = new Post(null, sdf.parse("21/03/2018"),"partiu viagem", "vou viajar para Sao Paulo. Abraços!", new AuthorDto(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"),"Bom dia", "Acordei feliz hoje", new AuthorDto(maria));
		
		CommentDTO comment = new CommentDTO("Boa viagem, mano", sdf.parse("21/03/2018"), new AuthorDto(alex));
		CommentDTO comment2 = new CommentDTO("Aproveite!", sdf.parse("22/03/2018"), new AuthorDto(bob));
		CommentDTO comment3 = new CommentDTO("Tenha um otimo dia", sdf.parse("23/03/2018"), new AuthorDto(alex));

		post.getComments().addAll(Arrays.asList(comment, comment2));
		post2.getComments().addAll(Arrays.asList(comment3));
		
		postRepository.saveAll(Arrays.asList(post, post2));
		
		maria.getPosts().addAll(Arrays.asList(post, post2));
		userRepository.save(maria);
	}

}
