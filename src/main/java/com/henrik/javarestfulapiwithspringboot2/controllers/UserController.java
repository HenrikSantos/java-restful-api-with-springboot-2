package com.henrik.javarestfulapiwithspringboot2.controllers;

import com.henrik.javarestfulapiwithspringboot2.models.UserModel;
import com.henrik.javarestfulapiwithspringboot2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<Iterable<UserModel>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> findByID(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findByID(id));
    }

    @PostMapping
    public ResponseEntity<UserModel> addOne(@RequestBody UserModel newUser) {
        userService.addOne(newUser);
        return ResponseEntity.ok(newUser);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserModel> update(@PathVariable Long id, @RequestBody UserModel updatedUser) {
        userService.update(id, updatedUser);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
