package com.example.workshopmongo.services;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workshopmongo.entities.Post;
import com.example.workshopmongo.repositories.PostRepository;
import com.example.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;

	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	public List<Post> findByTitle(String text) {
		return repository.findByTitle(text);
	}
	
	public List<Post> fullSearch(String text, Instant minDate, Instant maxDate) {
		maxDate = maxDate.plus(Duration.ofHours(23)).plus(Duration.ofMinutes(59)).plus(Duration.ofSeconds(59));
		return repository.fullSearch(text, minDate, maxDate);
	}
}
