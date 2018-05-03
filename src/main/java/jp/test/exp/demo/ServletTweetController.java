package jp.test.exp.demo;

import jp.test.exp.demo.repository.ServletTweetRepository;
import jp.test.exp.flux.viewmodel.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Stream;

@RestController
public class ServletTweetController {
    @Autowired
    private ServletTweetRepository servletTweetRepository;

    @GetMapping("/sTweets")
    public List<Tweet> getAllTweets() {
        return servletTweetRepository.findAll();
    }

    @PostMapping("/sTweets")
    public Tweet createTweets(@Valid @RequestBody Tweet tweet) {
        return servletTweetRepository.save(tweet);
    }

    @GetMapping("/sTweets/{id}")
    public ResponseEntity<Tweet> getTweetById(@PathVariable(value = "id") String tweetId) {
        return servletTweetRepository.findById(tweetId)
                .map(savedTweet -> ResponseEntity.ok(savedTweet))
                .get();
                //.defaultIfEmpty(ResponseEntity.notFound().build());
    }

/*     @PutMapping("/sTweets/{id}")
    // FIXME
    public ResponseEntity<Tweet> updateTweet(@PathVariable(value = "id") String tweetId,
                                                     @Valid @RequestBody Tweet tweet) {
       return servletTweetRepository.findById(tweetId)
                .flatMap(existingTweet -> {
                    existingTweet.setText(tweet.getText());
                    return servletTweetRepository.save(existingTweet);
                })
                .map(updatedTweet -> new ResponseEntity<>(updatedTweet, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }*/

 /*    @DeleteMapping("/sTweets/{id}")
    // FIXME
     public ResponseEntity<Void> deleteTweet(@PathVariable(value = "id") String tweetId) {

      return servletTweetRepository.findById(tweetId)
                .flatMap(existingTweet ->
                        servletTweetRepository.delete(existingTweet)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    } */

    // Tweets are Sent to the client as Server Sent Events
    @GetMapping(value = "/stream/sTweets", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public List<Tweet> streamAllTweets() {
        return servletTweetRepository.findAll();
    }
}
