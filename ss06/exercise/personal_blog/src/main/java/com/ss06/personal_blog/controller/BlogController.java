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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

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
        return modelAndView;
    }

    @PostMapping("/save-blog")
    public ModelAndView save(Blog blog){
        if(!blogService.findById(blog.getId()).isPresent()) {
            blogService.save(blog);
            return  new ModelAndView("/blog/createBlog",
                    "message", " New blog was created successfully!");
        }

        Blog blog1 = blogService.findById(blog.getId()).get();
        blog1.setName(blog.getName());
        blog1.setAuthor(blog.getAuthor());
        blog1.setCreatedDate(blog.getCreatedDate());
        blog1.setUpdatedDate(blog.getUpdatedDate());
        blog1.setCategory(blog.getCategory());
        blog1.setDescription(blog.getDescription());
        blog1.setContent(blog.getContent());
        blogService.save(blog1);
        return  new ModelAndView("/blog/updateBlog",
                "message", " The Blog was updated successfully!");
    }

    @GetMapping("/update-blog/{id}")
    public ModelAndView update(@PathVariable String id){
        ModelAndView modelAndView = new ModelAndView("/blog/updateBlog");
        modelAndView.addObject("blog", blogService.findById(id).get());
        modelAndView.addObject("authors", authorService.findAll());
        modelAndView.addObject("categories", categoryService.findAll());
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView delete(@PathVariable String id){
        Blog blog = blogService.findById(id).get();
        blogService.remove(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("message", "The blog" + blog.getName()  + "was deleted successfully!");
        List<Blog> blogs = (List<Blog>) blogService.findAll();
        modelAndView.addObject("blogs", blogs);
        return  modelAndView;
    }

    @GetMapping("/detail-blog")
    public ModelAndView detail(@RequestParam String id){
        Blog blog = blogService.findById(id).get();
        return new ModelAndView("/blog/detailBlog", "blog", blog);
    }
}
