package com.ayupov.Bank.Item;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ayupov.Bank.Application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ItemService {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository)
    {
        // this keyword refers to current instance
        this.itemRepository = itemRepository;
    }

    public int addItem(Item item)
    {
        itemRepository.save(item);
        return 200;
    }

    public List<Item> getUsers()
    {
        return new ArrayList<>();
    }   

    public Item getItem(int id)
    {
        log.info("logging");
        Optional<Item> opt = itemRepository.findById(id);
        if(opt.isPresent())
        {
            log.info("item exists");
            Item cmp = opt.get();
            return cmp;
        }
        return null;
    }
    public Iterable<Item> getItems()
    {
        log.info("logging");
        Iterable<Item> opt = itemRepository.findAll();
        return opt;
    }
    public int deleteItem(int id)
    {
        Optional<Item> opt = itemRepository.findById(id);
        if(opt.isPresent())
        {
            itemRepository.deleteById(id);
            return 200;
        }
        else
            return 404;
    }
    public int updateItem(Item item)
    {
        Optional<Item> opt = itemRepository.findById(item.getId()); // returns Optional<User>
        if(opt.isPresent())
        {
            Item item1 = opt.get();
            item1.setName(item.getName());
            item1.setDescription(item.getDescription());
            item1.setPrice(item.getPrice());
            item1.setPictureId(item.getPictureId());
            itemRepository.save(item1);
            return 200;
        }
        else
            return 404;
    }
}
