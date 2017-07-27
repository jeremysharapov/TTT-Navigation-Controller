package io.tutorial.turntotech.infoOrganizerSample;

import java.util.ArrayList;

/**
 * Created by Jeremy on 7/27/2017.
 */

public class DAO {

    private static ArrayList<Company> companyList;

    static DAO instance;
    public static DAO getInstance(){
        if (instance == null){
            instance = new DAO();
        }
        return instance;
    }

    public static ArrayList<Company> getcompanyList(){
        return companyList;
    }

    private DAO(){
        companyList = new ArrayList<Company>();
        Company Apple = new Company("Apple");
        Apple.products.add(new Product("iPhone"));
        Apple.products.add(new Product("iPad"));
        Apple.products.add(new Product("Macbook"));

        Company Samsung = new Company("Samsung");
        Samsung.products.add(new Product("Galaxy S"));
        Samsung.products.add(new Product("Galaxy Note"));
        Samsung.products.add(new Product("Galaxy Tab"));

        Company Motorola = new Company("Motorola");
        Motorola.products.add(new Product("Moto Z"));
        Motorola.products.add(new Product("Moto G"));
        Motorola.products.add(new Product("Moto E"));

        Company Microsoft = new Company("Microsoft");
        Microsoft.products.add(new Product("Xbox One"));
        Microsoft.products.add(new Product("Surface Pro"));
        Microsoft.products.add(new Product("Surface Laptop"));

        companyList.add(Apple);
        companyList.add(Samsung);
        companyList.add(Motorola);
        companyList.add(Microsoft);
    }

}
