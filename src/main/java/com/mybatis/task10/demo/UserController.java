package com.mybatis.task10.demo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public User update(@PathVariable("id") int id, @RequestBody UpdateForm form) {
        User user = userService.update(id, form.getName(), form.getAddress());
        return ResponseEntity.ok(user).getBody();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity delete(@PathVariable("id") int id, String name, String address) {
        userService.delete(id, name, address);
        return ResponseEntity.ok("Delete success");
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoResourceFound(
            ResourceNotFoundException e, HttpServletRequest request) {
        Map<String, String> body = Map.of(
                "timestamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
                "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
                "message", e.getMessage(),
                "path", request.getRequestURI());
        return new ResponseEntity(body, HttpStatus.NOT_FOUND);
    }
}
