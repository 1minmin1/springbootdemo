package net.proselyte.springbootdemo.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import net.proselyte.springbootdemo.model.Stud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import net.proselyte.springbootdemo.service.StudService;

import java.util.List;

@Controller
public class StudController {
    private final StudService studService;

    public static int idd;
    @Autowired
    public StudController(StudService studService) {
        this.studService = studService;
    }

    @GetMapping("/studs")
    public String findAll(Model model){
        List<Stud> studs = studService.findAll();
        model.addAttribute("studs",studs);
        return "stud-list";
    }

    @GetMapping("/stud-create")
    public String createStudForm(Stud stud){
        return "stud-create";
    }
    @PostMapping("/stud-create")
    public String createStud(Stud stud, HttpServletResponse response){
        studService.saveStud(stud);
        idd = Math.toIntExact(stud.getId());
        response.addCookie(new Cookie("id", Integer.toString(idd)));
        return "redirect:/studs";
    }
    @GetMapping("/stud-delete/{id}")
    public String deleteStud(@PathVariable("id") Long id){
        studService.deleteById(id);
        return "redirect:/studs";
    }

    @GetMapping("/stud-update/{id}")
    public String updateStudForm(@PathVariable("id") Long id, Model model){
        Stud stud = studService.findById(id);
        model.addAttribute("stud", stud);
        return "/stud-update";
    }
    @PostMapping("/stud-update")
    public String updateStud(Stud stud){
        studService.saveStud(stud);
        return "redirect:/studs";
    }
}
