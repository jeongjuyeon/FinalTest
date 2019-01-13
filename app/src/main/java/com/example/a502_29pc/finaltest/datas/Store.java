package com.example.a502_29pc.finaltest.datas;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Store implements Serializable {

    private int id;
    private String name;
    private String logo;


    public static Store getStoreFromJson(JSONObject storeJson) {
        Store store = new Store();

        try {
            store.setId(storeJson.getInt("id"));
            store.setName(storeJson.getString("name"));
            store.setLogo(storeJson.getString("logo"));
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return store;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
