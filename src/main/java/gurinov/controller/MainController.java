package gurinov.controller;

import gurinov.MavenVersion;
import gurinov.WorkWithDate;
import gurinov.model.Birthday;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping(value = "/**", method = RequestMethod.GET)
    public ModelAndView setBirthdayFromInput(ModelMap model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModelMap().addAttribute("version", MavenVersion.getVersion());
        modelAndView.getModelMap().addAttribute("author", "Евгений Гуринов");
        modelAndView.addObject("dateFromInput", new Birthday());
        modelAndView.setViewName("main_page");
        return modelAndView;
    }

    @RequestMapping(value = "/dateInfo", method = RequestMethod.POST)
    public String getInfoAboutDate(@ModelAttribute("dateFromInput") Birthday birthday, ModelMap model){
        model.addAttribute("age", WorkWithDate.calculateAge(birthday.getDate()));
        model.addAttribute("dayBeforeBirthday", WorkWithDate.calculateDaysBeforeBirthday(birthday.getDate()));
        return "birthday_info_page";
    }

}

