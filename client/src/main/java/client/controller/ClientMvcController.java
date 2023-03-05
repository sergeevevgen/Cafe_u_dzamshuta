package client.controller;

import data.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ClientMvcController {
    private final UserService clientService;

    public ClientMvcController(UserService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public String login(Model model) {

        return "login";
    }
}
