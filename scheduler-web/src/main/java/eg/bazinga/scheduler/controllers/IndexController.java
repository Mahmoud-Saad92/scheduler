package eg.bazinga.scheduler.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/")
    public String welcome() {
        return ("<h1>welcome</h1>");
    }
}
