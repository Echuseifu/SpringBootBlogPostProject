package com.tts.TechTalentBlog.service;

import com.tts.TechTalentBlog.model.BlogPost;


// this service is going to serve as a contract
// for our implementation
public interface BlogPostService {


    BlogPost addNewBlogPost(BlogPost blogPost);

}
