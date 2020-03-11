package com.example.bom.Controllers;

import com.example.bom.Data.Item;
import com.example.bom.Data.ItemService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

    @RequestMapping("/item/new")
    public String newItem(Model model){
        model.addAttribute("item", new Item());
        return "newitem";
    }
    @PostMapping("item")
    public String saveOrUpdate(@ModelAttribute Item item){
        Item savedItem = (Item) itemService.save(item);
        return "redirect:/item/" + savedItem.getId();
    }

    @RequestMapping("/item/update/{id}")
    public String updateItem(@PathVariable String id, Model model){
        Optional<Item> optional = itemService.findById(Long.valueOf(id));
        if (optional.isPresent()) {
            Item item = optional.get();
            model.addAttribute("item", item);
            return "newitem";
        }
        else {
            return "notfound";
        }
    }

    @RequestMapping("/item/delete/{id}")
    public String deleteItem(@PathVariable String id, Model model){
        itemService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }


}
