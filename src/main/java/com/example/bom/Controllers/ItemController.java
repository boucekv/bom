package com.example.bom.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemController {

    @RequestMapping({"","/","/item"})
    String firstPage()
    {
        return "itemslistpage";
    }
}
