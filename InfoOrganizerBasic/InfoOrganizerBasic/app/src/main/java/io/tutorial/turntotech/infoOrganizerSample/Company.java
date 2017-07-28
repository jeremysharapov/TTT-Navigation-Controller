package io.tutorial.turntotech.infoOrganizerSample;

import java.util.ArrayList;

/**
 * Created by Jeremy on 7/27/2017.
 */

public class Company {
    int id;
    String company_name, logoURL, stock_ticker, stock_price;
    ArrayList<Product> products;

    public Company(String s){
        company_name = s;
        products = new ArrayList<Product>();
    }

    public Company(String s, String URL){
        company_name = s;
        logoURL = URL;
        products = new ArrayList<Product>();
    }
}
