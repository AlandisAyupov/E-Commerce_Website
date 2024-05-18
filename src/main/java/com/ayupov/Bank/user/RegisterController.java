// package com.ayupov.Bank.user;

// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;
// import org.springframework.http.ResponseEntity;
// import javax.validation.Valid;

// import java.time.LocalDate;
// import java.util.List;
// import java.util.Optional;

// @RestController
// public class RegisterController {
// @Autowired
//     UserRepository userRepository;

//     @GetMapping("/users")
//     public List<User> getAllUsers() {
//         return userRepository.findAll();
//     }

//     @GetMapping("/users/{email}")
//     public List<User> getUser(@PathVariable(value = "email") String email) {
//         return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(email));
//     }

//     @PostMapping("/users")
//     public Book createUser(@Valid @RequestBody User user) {
//         return userRepository.save(user);
//     }
// }