package com.example.bom.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemController {

    @RequestMapping({"/my_items"})
    String firstPage()
    {
        return "my_items";
    }
}
