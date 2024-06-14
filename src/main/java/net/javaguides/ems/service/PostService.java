package net.javaguides.ems.service;

import net.javaguides.ems.dto.PostDto;
import net.javaguides.ems.dto.PostResponse;
import net.javaguides.ems.entity.Post;

public interface PostService {
    PostDto createPost(PostDto postDto);
    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
    Post findByTitle(String title);
}
