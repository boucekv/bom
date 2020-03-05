package com.example.bom.Controllers;

import com.example.bom.Data.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping({"","/","/item"})
    String firstPage(Model model)
    {
        model.addAttribute("items", itemService.findAll());
        return "itemslistpage";
    }
}
