package mx.iteso.singleton.chocoholic.table.impl;

import mx.iteso.singleton.chocoholic.Dish;
import mx.iteso.singleton.chocoholic.Drink;
import mx.iteso.singleton.chocoholic.table.TableOrder;

import java.util.ArrayList;

public class Table4 extends TableOrder{

    private static TableOrder uniqueInstance;

    private Table4(){
    	this.setTableName("Table 4");
        this.setDishes(new ArrayList<Dish>());
        this.setDrinks(new ArrayList<Drink>());
    }

    public static synchronized TableOrder getInstance(){
        if(uniqueInstance== null){
            uniqueInstance = new Table4();
        }
        return uniqueInstance;
    }
    public static synchronized void clearOrder(){
        uniqueInstance = null;
    }

}
