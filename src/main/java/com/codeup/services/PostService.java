package com.codeup.services;

import com.codeup.models.Post;
import java.util.List;

public interface PostService {

    List<Post> profileShowUserPosts();

    void createPost(Post post);

    List<Post> showPosts();

    Post showById(long id);

    Post editPostById(long id);

    void editPost(Post post);

    void deletePostById(long id);

}
