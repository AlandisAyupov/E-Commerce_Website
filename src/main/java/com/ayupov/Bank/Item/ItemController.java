package com.ayupov.Bank.Item;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ayupov.Bank.Application;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/item")
@CrossOrigin(origins = { "http://localhost:4000" }, allowedHeaders = "*", allowCredentials = "true")
public class ItemController {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private ItemService itemService;

    @PostMapping("/add")
    public int addUser(@RequestBody RequestItem item) {
        log.info("add " + item.toString());
        Item newItem = new Item();
        newItem.setName(item.getName());
        newItem.setDescription(item.getDescription());
        newItem.setPrice(item.getPrice());
        newItem.setPictureName(item.getPictureName());
        UUID uuid = UUID.randomUUID();
        newItem.setPictureId(uuid.toString());
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

    @GetMapping(
        value = "/get-image",
        produces = MediaType.IMAGE_JPEG_VALUE
    )
    public byte[] getImageWithMediaType(@RequestParam String pictureName) throws IOException {
        log.info(pictureName);
        InputStream in = getClass()
        .getResourceAsStream("/com/ayupov/Bank/images/" + pictureName + ".jpeg");
        return IOUtils.toByteArray(in);
    }
}