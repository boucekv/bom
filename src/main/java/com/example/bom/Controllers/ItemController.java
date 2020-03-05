package com.example.bom.Controllers;

import com.example.bom.Data.Item;
import com.example.bom.Data.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

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

    @RequestMapping("/item/{id}")
    public String showById(@PathVariable String id, Model model){
        Optional<Item> optional = itemService.findById(Long.valueOf(id));
        if (optional.isPresent()) {
            Item item = optional.get();
            model.addAttribute("my_item", item);
            return "item";
        }
        else {
            return "notfound";
        }

    }
}
