package client.controller;


import client.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@Controller
@RequestMapping("/")
public class ClientMvcController {
    private final UserService clientService;

    public ClientMvcController(UserService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/a")
    public String login(Model model) {

        return "zhopa";
    }
}
