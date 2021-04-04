package studyhelper.com.controller;

import studyhelper.com.models.User;
import study.com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody
    String addNewUser (@RequestParam String login, @RequestParam String password) {

        User n = new User();
        n.setLogin(login);
        n.setPassword(password);
        userRepository.save(n);
        return "Saved";
    }

}
