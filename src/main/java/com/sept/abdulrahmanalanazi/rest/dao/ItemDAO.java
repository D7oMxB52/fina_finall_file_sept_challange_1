package com.sept.abdulrahmanalanazi.rest.dao;

import com.sept.abdulrahmanalanazi.rest.model.Item;
import com.sept.abdulrahmanalanazi.rest.model.Items;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDAO {

    private static Items list = new Items();

    static{

        list.getItemList().add(new Item("01", "CPU", "intel I5 12400", 299.99));
        list.getItemList().add(new Item("02", "GPU", "MSI NVIDIA RTX GeForce 3070 GAMING Z TRIO 8G LHR", 959.99));
        list.getItemList().add(new Item("03", "CPU Cooler", "MSI MAG CORE LIQUID 240R V2 ARGB LIQUID COOLER", 108.18));
        list.getItemList().add(new Item("04", "MOTHERBOARD", "ASUS ROG STRIX B660-A GAMING WIFI D4 LGA1700", 326.36));
        list.getItemList().add(new Item("05", "M.2", "SAMSUNG 970 EVO PLUS 1TB NVME M.2 SSD", 153.64));
        list.getItemList().add(new Item("06", "DDR4 RAM", "CORSAIR VENGEANCE RGB PRO 32GB (2X16GB) DDR4 3600MHZ C18 DESKTOP RAM - BLACK", 199.09));
        list.getItemList().add(new Item("07", "POWER SUPPLY", "MSI MPG A750GF 80+ GOLD FULLY MODULAR 750W PSU", 99.09));
        list.getItemList().add(new Item("08", "M.2", "SAMSUNG 970 EVO PLUS 1TB NVME M.2 SSD", 153.64));
        list.getItemList().add(new Item("09", "PC CASE", "Lian Li PC-O11 Dynamic White ATX Case", 209.0));

    }

    public Items getAllItems() {
        return list;
    }

    public void addItem(Item item) {
        list.getItemList().add(item);

    }
}
