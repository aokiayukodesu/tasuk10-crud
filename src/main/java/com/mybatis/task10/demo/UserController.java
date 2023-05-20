package com.mybatis.task10.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers(@RequestParam(name = "user_prof", value = "user_prof") String UserProf) {
        List<User> users = userService.findByAll();
        return users;
    }

    @PostMapping("/users")
    public ResponseEntity<String> create(@RequestBody CreateForm form) {
        userService.create(form);
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/users/user_date")
                .build()
                .toUri();
        return ResponseEntity.created(url).body("your date successfully created");
    }

    @PatchMapping("/users/{id}")
    public ResponseEntity upDate(@PathVariable("id") int id, @RequestBody User user) {
        userService.update(user);
        return ResponseEntity.ok(user);
    }
}
