package com.sept.abdulrahmanalanazi.rest.controller;

import java.net.URI;

import com.sept.abdulrahmanalanazi.rest.exception.CustomExceptionHandler;
import com.sept.abdulrahmanalanazi.rest.model.Item;
import com.sept.abdulrahmanalanazi.rest.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.sept.abdulrahmanalanazi.rest.dao.ItemDAO;
import com.sept.abdulrahmanalanazi.rest.model.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path = "/item")
public class ItemController {


    @Autowired
    private ItemDAO itemDAO;
    @Autowired
    private ItemService itemService;

    public ItemController(){
        super();
        this.itemService = itemService;
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Item> createItem(@RequestBody Item item){

        Integer id = itemDAO.getAllItems().getItemList().size() + 1;
        String idToString;
        if (id >= 0 && id <10){
            idToString = '0' + String.valueOf(id);
            item.setId(idToString);
        }
        else{
            item.setId(id.toString());
        }

        itemService.saveItem(item);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/item{id}")
                .buildAndExpand(item.getId())
                .toUri();



        return ResponseEntity.created(location).build();
    }


    // getting all items in itemDAO.
    // link:  http://localhost:8080/item/item
    @GetMapping(path = "/item", produces = "application/json")
    public Items getItemList() {
        return itemDAO.getAllItems();
    }

    // getting specific item using id.
    // for example: getting Motherboard (which is 4th item)
    // like:    http://localhost:8080/item/item04
    @GetMapping(path = "/item{id}", produces = "application/json")
    public ResponseEntity<Item> getItemById(@PathVariable("id") String id) throws CustomExceptionHandler {
        if (itemService.getItemById(id) != null){
            return new ResponseEntity<Item>(itemService.getItemById(id), HttpStatus.OK);
        }
        else{
            throw new CustomExceptionHandler();
        }
    }

    // changing an existed item
    // for example: changing the price of GPU (from 959.99 to 1600. thx for crypto :( )
    // note: you can change one or all things in this item.
    // link:    http://localhost:8080/item/item02
    @PutMapping(path = "/item{id}", consumes =  "application/json", produces = "application/json")
    public ResponseEntity<Item> updateItem(@PathVariable("id") String id
            ,@RequestBody Item item){
        return new ResponseEntity<Item>(itemService.updateItem(item, id), HttpStatus.OK);
    }

    // delete specific item using id
    // for example: deleting GPU (which is 2nd item) from itemDAO
    // link: http:://localhost:8080/item/item03
    @DeleteMapping(path = "/item{id}", consumes = "application/json")
    public ResponseEntity<Item> deleteItem(@PathVariable("id") String id){
        itemService.deleteItem(id);
        return new ResponseEntity<Item>( HttpStatus.OK);
    }


}