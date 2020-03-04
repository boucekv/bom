package com.example.bom.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BomController {
    @RequestMapping({"/bom"})///bom{id}
    String bom()
    {
        return "bomdetail";
    }
}
