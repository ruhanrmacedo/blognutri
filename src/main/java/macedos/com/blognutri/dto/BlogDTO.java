package macedos.com.blognutri.dto;

import macedos.com.blognutri.entity.Blog;

public record BlogDTO (Long id, String title, String image, String description) {
    public BlogDTO(Blog blog){
        this(blog.getId(), blog.getTitle(), blog.getImage(), blog.getDescription());
    }
}
