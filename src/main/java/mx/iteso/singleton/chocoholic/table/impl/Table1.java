package mx.iteso.singleton.chocoholic.table.impl;

import mx.iteso.singleton.chocoholic.Dish;
import mx.iteso.singleton.chocoholic.Drink;
import mx.iteso.singleton.chocoholic.table.TableOrder;

import java.util.ArrayList;

public class Table1 extends TableOrder{

    private static TableOrder uniqueInstance;

    private Table1(){
    	this.setTableName("Table 1");
        this.setDishes(new ArrayList<Dish>());
        this.setDrinks(new ArrayList<Drink>());
    }

    public static synchronized TableOrder getInstance(){
        if(uniqueInstance== null){
            uniqueInstance = new Table1();
        }
        return uniqueInstance;
    }
    
    public synchronized void clearOrder(){
        uniqueInstance = null;
    }

}
