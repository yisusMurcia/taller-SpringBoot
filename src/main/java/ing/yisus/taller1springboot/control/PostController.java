package ing.yisus.taller1springboot.control;

import ing.yisus.taller1springboot.services.IUserService;
import ing.yisus.taller1springboot.services.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class PostController {
    private final UserServiceImpl userService;

    @GetMapping
    public ResponseEntity<?> getAllPosts() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getPostById(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }
}
