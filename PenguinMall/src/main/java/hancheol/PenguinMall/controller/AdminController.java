package hancheol.PenguinMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody // 웹이 아닌 문자열 데이터를 리턴하도록 만듬
public class AdminController {

    @Autowired
    public AdminController()
    {}
    @GetMapping("/admin")
    public String adminP() {

        return "admin Controller";
    }
}