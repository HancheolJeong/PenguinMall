package hancheol.PenguinMall.controller;

import hancheol.PenguinMall.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class MainController {

    @Autowired
    public MainController()
    {}
    @GetMapping("/")
    public String mainP() {

        return "main Controller";
    }
}