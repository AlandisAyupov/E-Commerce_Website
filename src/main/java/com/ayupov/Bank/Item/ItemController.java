package com.ayupov.bank.Item;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ayupov.bank.Application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/item")
@CrossOrigin(origins = { "http://localhost:4000" }, allowedHeaders = "*", allowCredentials = "true")
public class ItemController {

    @Autowired
    private ItemService itemService;
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @PostMapping("/add")
    public int addUser(@RequestBody RequestItem item) {
        log.info("add " + item.toString());
        Item newItem = new Item();
        newItem.setName(item.getName());
        newItem.setDescription(item.getDescription());
        newItem.setPrice(item.getPrice());
        newItem.setPictureId(item.getPictureId());
        return itemService.addItem(newItem);
    }

    @GetMapping("/get")
    public Item getItem(int id) 
    {
        return itemService.getItem(id);
    }

    @PatchMapping("/update")
    public int updateUser(@RequestBody RequestItem item) {
        log.info("update " + item.toString());
        Item newItem = new Item();
        newItem.setId(item.getId());
        newItem.setName(item.getName());
        newItem.setDescription(item.getDescription());
        newItem.setPrice(item.getPrice());
        newItem.setPictureId(item.getPictureId());
        return itemService.updateItem(newItem);
    }

    @DeleteMapping("/delete")
    public int deleteItem(int id) 
    {
        return itemService.deleteItem(id);
    }

    @GetMapping("/get-all")
    public Iterable<Item> getItems() 
    {
        return itemService.getItems();
    }
}