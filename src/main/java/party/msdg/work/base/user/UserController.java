package party.msdg.work.base.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Wow! Sweet moon.
 */
@RestController
@RequestMapping("/api/acc")
public class UserController {
  
    @Autowired
    private UserService accountService;
    
    @PostMapping("/register")
    void register(
        @RequestParam("account") String account,
        @RequestParam("password") String password
    ) {
        accountService.add(account, password);
    }
    
    @GetMapping("/login")
    void login(
        @RequestParam("account") String account,
        @RequestParam("password") String password
    ) {
        accountService.doLogin(account, password);
    }
}
