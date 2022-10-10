package mds.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {


    @GetMapping("myself")
    @ResponseBody
    public String myself() {
        return "<h1 style=color:Red;><b>Tomas Hadwiger, 230252</b></h1>";
    }

    @GetMapping("alice")
    public String alice(Model model) {
        model.addAttribute("name", "alice");
        return "template";
    }
    @GetMapping("bob")
    public String bob(Model model) {
        model.addAttribute("name","bob");
        return "template";
    }

}
