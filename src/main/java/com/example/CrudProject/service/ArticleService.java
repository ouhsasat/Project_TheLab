package com.example.CrudProject.service;


import java.util.List;
import java.util.Optional;
//import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import com.example.CrudProject.entity.Articles;
import com.example.CrudProject.repository.ArticleRepository;


@Service
public class ArticleService {
	@Autowired
	ArticleRepository repository;

	public List<Articles> findallBooks() {
		return (List<Articles>) repository.findAll();
	}

	public Articles findBookById(int id) {
		Optional<Articles> result = repository.findById(id);
		if (result.isPresent()) {
			return result.get();
		}
		return new Articles();
	}

	public Articles addBook(Articles book) {
		return repository.save(book);
	}

	public Articles updateBook(Articles book) {
		Optional<Articles> result = repository.findById(book.getId());
		Articles existing = result.get();
		existing.setAuthor(book.getAuthor());
		existing.setName(book.getName());
		existing.setNoOfPages(book.getNoOfPages());
		existing.setPublication(book.getPublication());
		return repository.save(existing);
	}

	public void deleteById(int id) {
		repository.deleteById(id);
	}
	
	
	
	public Page<Articles> getEMpByPaginates(int currentPage, int size) {
		Pageable p = PageRequest.of(currentPage, size);
		return repository.findAll(p);
	}

}
