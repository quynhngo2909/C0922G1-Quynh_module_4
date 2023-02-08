package com.ss06.personal_blog.controller;

import com.ss06.personal_blog.model.Author;
import com.ss06.personal_blog.model.Blog;
import com.ss06.personal_blog.model.Category;
import com.ss06.personal_blog.service.IAuthorService;
import com.ss06.personal_blog.service.IBlogService;
import com.ss06.personal_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private IAuthorService authorService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("")
    public String listBLog(Model model){
        List<Blog> blogs = (List<Blog>) blogService.findAll();
        if(blogs.size() == 0) {
            model.addAttribute("message", "The blog is empty!");
        }
        model.addAttribute("blogs", blogs);
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        return "/blog/list";
    }

    @GetMapping("/create-blog")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("/blog/createBlog");
        modelAndView.addObject("authors", authorService.findAll());
        modelAndView.addObject("categories", categoryService.findAll());
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("author", new Author());
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/save-blog")
    public ModelAndView save(Blog blog){
        Blog blog1 = blogService.findById(blog.getId()).get();
        if(blog1 == null) {
            blogService.save(blog);
            return  new ModelAndView("/blog/createBlog",
                    "message", " New blog was created successfully!");
        }

        blog1.setName(blog.getName());
        blog1.setAuthor(blog.getAuthor());
        blog1.setCreatedDate(blog.getCreatedDate());
        blog1.setUpdatedDate(blog.getUpdatedDate());
        blog1.setCategory(blog.getCategory());
        blog1.setDescription(blog.getDescription());
        blog1.setContent(blog.getContent());
        blogService.save(blog1);
        return  new ModelAndView("/category/updateBlog",
                "message", " The Blog was updated successfully!");
    }
}
