package com.iins.system.services;

import com.iins.system.menuitem.MenuItem;
import com.iins.system.menuitem.MenuItemRepo;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import reactor.core.publisher.Flux;

import java.net.InetAddress;
import java.util.*;


public class CacheService {


    public HashMap<String, String> Configuration = new HashMap<>();
    //public HashMap<String, JSONObject> MenuItems = new HashMap<>();


    public CacheService() {
    }

    public void initialization() {
        this.Configuration.put("MongoDbHost", "localhost");
        this.Configuration.put("MongoDbPort", "27017");

    }


    private void initMenuItems() {

        System.out.println("Init Menu at Data==============================");
    }
}

