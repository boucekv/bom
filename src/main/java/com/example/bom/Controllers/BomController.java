package com.example.bom.Controllers;

import com.example.bom.Data.Bom;
import com.example.bom.Data.BomServise;
import com.example.bom.Data.Item;
import com.example.bom.Data.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class BomController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private BomServise bomService;

    @RequestMapping({"/bom"})///bom{id}
    String bom(Model model) {
        Map<String, String> map = new HashMap<>();
        map.put("spring", "mvc");
        model.addAttribute("message", "Baeldung");
        model.mergeAttributes(map);
        return "bomdetail";
    }

    @RequestMapping("/bom/{id}")
    public String showBomByItemId(@PathVariable String id, Model model){
        Optional<Item> optional = itemService.findById(Long.valueOf(id));
        if (optional.isPresent()) {
            Item item = optional.get();
            List<Bom> boms = item.getBoms();
            if (boms.size()>0) {
                model.addAttribute("boms", boms);
                return "bomdetail";
            }
            else {
                return "notfound";
            }
        }
        else {
            return "notfound";
        }

    }
}
