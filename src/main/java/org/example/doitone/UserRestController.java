package org.example.doitone;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserRestController {

    private Map<String, User> users = new HashMap<>();
    // key - value

    @GetMapping("/hello1")
    public String hello() {
        return "hello";
    }

    @PostMapping("/user1")
    public User createUser(@RequestBody User user) {
        // 유저를 생성하고 리턴
        users.put(user.getId(), user);
        return user;
    }

    @GetMapping("/user1")
    public Collection<User> getAllUser() {
        // 전체 유저를 리턴
        return users.values();
    }

    @GetMapping("/user1/{id}")
    public User getUser(@PathVariable String id) {
        // id에 해당하는 유저를 리턴
        return users.get(id);
    }

    @PostMapping("/user1/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user) {
        // id에 해당하는 유저를 업데이트하고 리턴
        users.put(id, user);
        return user;
    }
}
