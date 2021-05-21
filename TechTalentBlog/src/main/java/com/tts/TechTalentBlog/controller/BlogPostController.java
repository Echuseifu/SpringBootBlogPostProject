package com.tts.TechTalentBlog.controller;

import com.tts.TechTalentBlog.model.BlogPost;
import com.tts.TechTalentBlog.repository.BlogPostRepository;
import com.tts.TechTalentBlog.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

// this help send the output to a template, rather than write output directly from the controller
@Controller
public class BlogPostController {

    @Autowired
    BlogPostService blogPostService;

//    public BlogPostController(BlogPostService blogPostService){
//        this.blogPostService = blogPostService;
//    }


    // this annotation will be used for our index method,
    // which will return the template specified- a template called 'index'
    // this return value is a reference to a template
    // it will not literally return a string value
    @GetMapping(value = "/")
    public String index(BlogPost blogPost) {
        return "blogpost/index";
    }

    private BlogPost blogPost;

    // this method will post the data which entered and post to the db
    // and display a confirmation page on result page
    @PostMapping(value = "/")
    public String addNewBlogPost(BlogPost blogPost, Model model) {

        blogPostService.addNewBlogPost(blogPost);

        model.addAttribute("title", blogPost.getTitle());
        model.addAttribute("author", blogPost.getAuthor());
        model.addAttribute("blogEntry", blogPost.getBlogEntry());
        return "blogpost/result";
    }



}


