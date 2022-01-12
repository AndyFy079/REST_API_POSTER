package applicationPost.controller;

import applicationPost.models.PostChangeRQ;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import applicationPost.service.PostService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/post")
public class PostController {
    private final PostService service;

    @GetMapping("/wall")
    public ResponseEntity<?> getPubs() {
        return ResponseEntity.ok(service.getPub());
    }

    @PutMapping("/wall")
    public ResponseEntity<?> addPub(@RequestBody PostChangeRQ postChangeRQ) {
        return ResponseEntity.ok(service.addPub(postChangeRQ));
    }

    @PostMapping("/wall/{id}")
    public ResponseEntity<?> editPub(@RequestBody PostChangeRQ postChangeRQ,
                                     @PathVariable int id){
        return ResponseEntity.ok(service.editPub(id, postChangeRQ));
    }

    @DeleteMapping("/wall/{id}")
    public ResponseEntity<?> deletePub(@PathVariable int id){
        return ResponseEntity.ok(service.deletePub(id));
    }
}
