package jp.test.exp.flux.viewmodel;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 参考ページ：
 * <ul>
 *     <li>https://www.callicoder.com/reactive-rest-apis-spring-webflux-reactive-mongo/</li>
 *     <li>https://github.com/callicoder/spring-webflux-reactive-rest-api-demo</li>
 * </ul>
 * <p>
 *     LocalのMongoDBは必要
 *     <br/> $docker pull mongo
 *     <br/> $docker run -d --name any-mongo -p 27017:27017 mongo
 * </p>
 *
 * TODO: Cosmos / DynamoDBに移行
 */
@Document(collection = "tweets")
public class Tweet {
    @Id
    private String id;

    @NotBlank
    @Size(max = 140)
    private String text;

    @NotNull
    private Date createdAt = new Date();

    public Tweet() {

    }

    public Tweet(String text) {
        this.id = id;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
