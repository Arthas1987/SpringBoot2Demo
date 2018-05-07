package jp.test.exp.demo;

import jp.test.exp.demo.action.CRUDTestAction;
import jp.test.exp.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class CRUDTestController {
    @Autowired
    private CRUDTestAction cRUDTestAction;

    @GetMapping("/")
    @ResponseBody
    public List<User> getUsers() {
        return cRUDTestAction.getUsers();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public User getUserById(@PathVariable(value = "id") Long userId) {
        return cRUDTestAction.getUserById(userId);
    }

    @PostMapping("/")
    public User createUsers(@RequestBody User user) {
        return cRUDTestAction.createUser(user);
    }

    @PutMapping("/")
    public User changeUserName(@RequestBody User user) {
        return cRUDTestAction.updateUserName(user);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public List<User> deleteUser(@PathVariable(value = "id") Long userId) {
        return cRUDTestAction.deleteUser(userId);
    }

    @GetMapping("/name/{name}")
    public List<User> getUsersByName(@PathVariable(value = "name") String userName) {
        return cRUDTestAction.findUsersByName(userName);
    }
}
