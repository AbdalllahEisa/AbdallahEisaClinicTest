package com.example.test.controller;

import com.example.test.dao.Clinic;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class cont {

@RequestMapping("add")
    public String addingn(Model m) {
    m.addAttribute("clinic", new Clinic());
    return "add";
}

}
