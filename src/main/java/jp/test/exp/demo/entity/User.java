package jp.test.exp.demo.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Spring Data JPA Entity
 */
@Entity
@Table(name="user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="username")
    private String userName;

    @Column(name="password")
    private String password;

    /* Getter and Setter */
    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /* Constructor */
    public User(Long id, String userName, String password) {
        this.id = id;

        this.userName = userName;
        this.password = password;
    }

    public User(Long id) {
        this.id = id;
    }

    public User() {

    }

    public User(@NotNull User anotherUser) {
        this.password = anotherUser.password; //Are You F**king Serious??!!!
        this.userName = anotherUser.userName;
    }
}
