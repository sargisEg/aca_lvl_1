package com.aca.homework.week21.post;

import com.aca.homework.week21.post.facade.CreatePostRequestDto;
import com.aca.homework.week21.post.facade.PostDto;
import com.aca.homework.week21.post.facade.PostFacade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("posts")
public class PostController {

    private final PostFacade postFacade;

    public PostController(PostFacade postFacade) {
        this.postFacade = postFacade;
    }

    @PostMapping
    public PostDto createPost(@RequestBody CreatePostRequestDto dto) {
        return postFacade.createPost(dto);
    }

    @GetMapping
    public List<PostDto> getAllPosts() {
        return postFacade.getAllPosts();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PostDto getPostById(@PathVariable Long id) {
        return postFacade.getPostById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePostById(@PathVariable Long id) {
        postFacade.deletePostById(id);
    }
}
