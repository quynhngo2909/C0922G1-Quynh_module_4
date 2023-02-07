package com.ss06.personal_blog.controller;

import com.ss06.personal_blog.model.Author;
import com.ss06.personal_blog.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    IAuthorService authorService;

    @GetMapping("")
    public String listAuthors(Model model){
        List<Author> authors = (List<Author>) authorService.findAll();
        if(authors.size() == 0) {
            model.addAttribute("message", "The author list is empty!");
        }
        model.addAttribute("authors", authors);
        return "/author/listAuthor";
    }

    @GetMapping("/create-author")
    public ModelAndView createAuthor(){
        return new ModelAndView("/author/createAuthor", "author", new Author("1", "Author"));
    }

    @PostMapping("/create-author")
    public ModelAndView save(Author author){
        Optional<Author> author1 = authorService.findById(author.getId());
        if(!author1.isPresent()) {
            authorService.save(author);
            return  new ModelAndView("/author/createAuthor",
                    "message", " New author was created successfully!");
        }

        Author author2 = author1.get();
        author2.setName(author.getName());
        authorService.save(author2);
        return  new ModelAndView("/author/createAuthor",
                "message", " The author was updated successfully!");
    }
}
