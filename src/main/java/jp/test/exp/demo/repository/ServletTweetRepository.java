package jp.test.exp.demo.repository;

import jp.test.exp.flux.viewmodel.Tweet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServletTweetRepository extends MongoRepository<Tweet, String> {
}
