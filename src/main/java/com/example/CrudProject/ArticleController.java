package com.example.CrudProject;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.CrudProject.entity.Articles;
import com.example.CrudProject.service.ArticleService;

import org.springframework.data.domain.Page;
@Controller
public class ArticleController {
	@Autowired
	ArticleService service;
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("books", service.findallBooks());
		return "all-books"; 
	}
	

	@GetMapping("/")
	public String findAll(Model model) {
		model.addAttribute("books", service.findallBooks());
		return findPaginated(0, model);
		
		//return "all-books";
		
	}

	@GetMapping("/add")
	public String lunchAddBookPage(Model model) {
		model.addAttribute("book", new Articles());
		return "add-book";
	}

	@PostMapping("/addbook")
	public String createBook(Articles book) {
		service.addBook(book);
		return "redirect:/";

	}

	@GetMapping("/edit/{id}")
	public String lunchEditPage(Model model, @PathVariable("id") int id) {
		model.addAttribute("book", service.findBookById(id));
		return "edit-book";

	}

	@PostMapping("/updatebook")
	public String upadteBook(Articles book) {
		service.updateBook(book);
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/";
	}

	@GetMapping("/test")
	public String test() {
		Articles st = new Articles();
		st.setId(1);
		st.setAuthor("Rajanikanta");
		st.setName("Java");
		st.setNoOfPages("hhe");
		st.setPublication("Ptradhan");
		service.addBook(st);
		return "index";

	}
	
	@GetMapping("/page/{pageno}")
	public String findPaginated(@PathVariable int pageno, Model m) {

		Page<Articles> emplist = service.getEMpByPaginate(pageno, 3);
		m.addAttribute("books", service.findallBooks());
		m.addAttribute("books", emplist);
		m.addAttribute("currentPage", pageno);
		m.addAttribute("totalPages", emplist.getTotalPages());
		m.addAttribute("totalItem", emplist.getTotalElements());
		return "all-books";
	}
	

}