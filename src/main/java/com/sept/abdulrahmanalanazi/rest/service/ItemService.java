package com.sept.abdulrahmanalanazi.rest.service;

import com.sept.abdulrahmanalanazi.rest.model.Item;
import java.util.List;

public interface ItemService {

    // making CRUD into DAO

    void saveItem(Item item);
    Item getItemById(String id);
    Item updateItem(Item item, String id);
    void deleteItem(String id);

}
