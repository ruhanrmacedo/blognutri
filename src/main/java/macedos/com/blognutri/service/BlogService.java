package macedos.com.blognutri.service;

import macedos.com.blognutri.entity.Blog;
import macedos.com.blognutri.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Blog salvarPost(Blog blog){
        blogRepository.save(blog);

        return blog;
    }

    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    public void excluirPost(Long id) {
        blogRepository.deleteById(id);
    }
}
