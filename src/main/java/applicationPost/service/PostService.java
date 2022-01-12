package applicationPost.service;

import lombok.RequiredArgsConstructor;
import applicationPost.models.PostChangeRQ;
import applicationPost.models.PostRepository;
import applicationPost.models.Post;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Post addPub(PostChangeRQ postChangeRQ){
        Post p = new Post();
        p.setText(postChangeRQ.getPostText());
        p.setTitle(postChangeRQ.getTitle());
        p.setTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        return postRepository.save(p);
    }
    public List<Post> getPub(){
        return postRepository.findAll();
    }
    public Post editPub(int id, PostChangeRQ postChangeRQ){
        Post p = postRepository.getById(id);
        p.setText(postChangeRQ.getPostText());
        p.setTitle(postChangeRQ.getTitle());
        p.setTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        return postRepository.save(p);
    }
    public Boolean deletePub(int id){
        postRepository.delete(postRepository.getById(id));
        return true;
    }
}
