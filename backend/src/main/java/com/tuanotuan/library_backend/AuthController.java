package com.tuanotuan.library_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        // Mật khẩu gửi lên sẽ được "xay nát" ở đây trước khi lưu
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        userRepository.save(user);
        return "Đăng ký thành công cho user: " + user.getUsername();
    }
    @Autowired
    private JwtUtil jwtUtil; // Gọi xưởng in thẻ bài ra

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        // 1. Tìm thằng User trong DB theo Username
        User dbUser = userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new RuntimeException("Đéo tìm thấy User!"));

        // 2. Kiểm tra xem mật khẩu gửi lên có khớp với mật khẩu "đã xay" trong DB không
        if (passwordEncoder.matches(user.getPassword(), dbUser.getPassword())) {
            // 3. Nếu khớp thì in Thẻ bài (Token) trả về cho nó đi bar
            return jwtUtil.generateToken(dbUser.getUsername());
        } else {
            return "Sai mật khẩu rồi mày ơi!";
        }
    }
}