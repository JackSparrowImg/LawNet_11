package dao;

import entity.Blog;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BlogsDaoTest {

    BlogsDao blogsDao= new BlogsDao();
    @Test
    void getAllBlogs() {
        List<Blog> blogs = blogsDao.getAllBlogs();
        for(int i = 0; i < blogs.size(); i++){
            System.out.println(blogs.get(i).getTitle());
        }
    }

    @Test
    void getAllPublishedBlogs() {
    }

    @Test
    void getMyselfBlogByUsername() {
    }

    @Test
    void getBlogDetailsByID() {
    }

    @Test
    void getBlogDetailsByIDConvert() {
    }

    @Test
    void creatNewBlogByUser() {
    }

    @Test
    void updateBlog() {
    }

    @Test
    void delBlogById() {
    }

    @Test
    void updateViewsById() {
    }
}