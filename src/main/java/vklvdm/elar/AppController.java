package vklvdm.elar;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import vklvdm.elar.model.User;

/**
 * Created by vikulov.d on 20.07.2017.
 */
@Controller
public class AppController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/success")
    public String success(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        model.addAttribute("username", user.getName());
        return "success";
    }
}
