package com.example.CrudProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.CrudProject.entity.Articles;
import com.example.CrudProject.service.ArticleService;


@Controller
public class ArticleController {
	@Autowired
	ArticleService service;
	
	@GetMapping("/")
	public String home(Model model) {
		return findPaginated(0, model);
	}

	@GetMapping("/")
	public String findAll(Model model) {
		model.addAttribute("books", service.findallBooks());
		return "all-books";
		
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
	public String findPaginated(@PathVariable int pageno, Model model) {

		Page<Articles> emplist = service.getEMpByPaginates(pageno, pageno);
		model.addAttribute("emp", emplist);
		model.addAttribute("currentPage", pageno);
		model.addAttribute("totalPages", emplist.getTotalPages());
		model.addAttribute("totalItem", emplist.getTotalElements());
		return "index";
	}

}