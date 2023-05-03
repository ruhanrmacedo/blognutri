package macedos.com.blognutri.controller;

import macedos.com.blognutri.dto.BlogDTO;
import macedos.com.blognutri.entity.Blog;
import macedos.com.blognutri.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/gerenciamento")
public class GerenciamentoController {

    private final BlogService blogService;

    public GerenciamentoController(BlogService blogService) {
        this.blogService = blogService;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/posts")
    public ResponseEntity<List<Blog>> findAll(){
        try {
            List<Blog> blog = blogService.findAll();
                return new ResponseEntity<>(blog, HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/post")
    public ResponseEntity<String> newPost(@RequestBody Blog blog){
        try {
            blogService.salvarPost(blog);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao tentar inserir novo post", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Post enviado com sucesso!", HttpStatus.CREATED);
    }

    @DeleteMapping("/excluirPost/{id}")
    public ResponseEntity<String> excluirPost(@PathVariable("id") Long id){
        try {
            blogService.excluirPost(id);
        }catch (Exception exception){
            return new ResponseEntity<>("Erro ao excluir post", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Post excluido com sucesso", HttpStatus.OK);
    }

}
