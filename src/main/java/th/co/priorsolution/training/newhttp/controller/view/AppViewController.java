package th.co.priorsolution.training.newhttp.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.co.priorsolution.training.newhttp.model.PersonModel;

@Controller
@RequestMapping("/app")
public class AppViewController {

    @GetMapping("/")
    public String index(Model model){
        PersonModel personModel = new PersonModel();
        personModel.setAge(15);
        personModel.setNickName("Mao");

        model.addAttribute("person", personModel);
        return "index";
    }
}
