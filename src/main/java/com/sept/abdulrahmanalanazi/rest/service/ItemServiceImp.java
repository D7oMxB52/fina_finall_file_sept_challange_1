package com.sept.abdulrahmanalanazi.rest.service;

import com.sept.abdulrahmanalanazi.rest.dao.ItemDAO;
import com.sept.abdulrahmanalanazi.rest.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ItemServiceImp implements ItemService{

    private final ItemDAO itemDAO;


    @Autowired
    public ItemServiceImp(ItemDAO itemDAO){
        super();
        this.itemDAO = itemDAO;
    }

    //saving item into itemDAO
    @Override
    public void saveItem(Item item) {
        itemDAO.addItem(item);
    }

    @Override
    public Item getItemById(String id) {
        for (int i = 0; i < itemDAO.getAllItems().getItemList().size(); i++){
            if (itemDAO.getAllItems().getItemList().get(i).getId().equals(id)){
                return itemDAO.getAllItems().getItemList().get(i);
            }
        }
        return null;
    }

    @Override
    public Item updateItem(Item item, String id) {

        Item existingItem = getItemById(id) ;
        if (item.getTitle() == null){
            item.setTitle(existingItem.getTitle());
        }
        if (item.getDesc() == null){
            item.setDesc(existingItem.getDesc());
        }
        if (item.getImagePath() == null){
            item.setImagePath(existingItem.getImagePath());
        }
        if (item.getPrice() == 0.0){
            item.setPrice(existingItem.getPrice());

        }
        existingItem.setDesc(item.getDesc());
        existingItem.setTitle(item.getTitle());
        existingItem.setImagePath(item.getImagePath());
        existingItem.setPrice(item.getPrice());
        int index = itemDAO.getAllItems().getItemList().indexOf(existingItem);
        itemDAO.getAllItems().getItemList().set(index , existingItem);

        return existingItem;
    }

    @Override
    public void deleteItem(String id) {
        Item existingItem = getItemById(id);
        int index = itemDAO.getAllItems().getItemList().indexOf(existingItem);
        itemDAO.getAllItems().getItemList().remove(index);


    }
}
