package io.tutorial.turntotech.infoOrganizerSample;

/**
 * Created by Jeremy on 7/27/2017.
 */

public class Product {
    int id, company_id;
    String product_name, logoURL, productURL;

    public Product(String s){
        product_name = s;
    }

    public Product(String s, String URL){
        product_name = s;
        logoURL = URL;
    }

    public Product(String s, String URL, String web){
        product_name = s;
        logoURL = URL;
        productURL = web;
    }
}
