package com.qxcmp.framework.mall;

import com.qxcmp.framework.user.User;
import com.qxcmp.framework.user.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class BaseMallTest {

    @Autowired
    private UserService userService;

    protected User getOrCreateUser(String username) {
        return userService.findByUsername(username).orElseGet(() -> userService.create(() -> {
            User user = userService.next();
            user.setUsername(username);
            user.setPassword(new BCryptPasswordEncoder().encode("12345678"));
            user.setEnabled(true);
            user.setAccountNonLocked(true);
            user.setAccountNonExpired(true);
            user.setCredentialsNonExpired(true);
            return user;
        }).orElse(null));
    }
}
