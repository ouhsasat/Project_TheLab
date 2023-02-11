package com.example.CrudProject.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CrudProject.entity.Articles;

@Repository
public interface ArticleRepository extends JpaRepository<Articles,Integer>{
	
}
