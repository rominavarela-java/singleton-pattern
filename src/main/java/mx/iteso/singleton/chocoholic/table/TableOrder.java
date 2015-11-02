package mx.iteso.singleton.chocoholic.table;

import java.util.ArrayList;

import mx.iteso.singleton.chocoholic.Dish;
import mx.iteso.singleton.chocoholic.Drink;

public abstract class TableOrder {
    public String tableName;
    public ArrayList<Dish> dishes;
    public ArrayList<Drink> drinks;

    public synchronized void clearDrinks(){
    	this.getDrinks().clear();
    }

    public synchronized void clearDishes(){
        this.getDishes().clear();
    }

    public synchronized void addDrink (Drink drink) {
        this.getDrinks().add(drink);
    }
    public synchronized void addDish (Dish dish) {
        this.getDishes().add(dish);
    }

    public synchronized void printCheck(){
        float total = 0;
        
        System.out.println("Check for " + this.getTableName());
        System.out.println("Drinks:");
        for(Drink dr: this.getDrinks()){
            System.out.println(dr.getWaiter() + ": " + dr.getName()+ " " + dr.getPrice());
            total += dr.getPrice();
        }
        
        System.out.println("Dishes:");
        for(Dish ds: this.getDishes()){
            System.out.println(ds.getWaiter() + ": " + ds.getName()+ " " + ds.getPrice());
            total += ds.getPrice();
        }
        
        System.out.println("Total: $" + total);
    }

    //getters and setters
    public String getTableName() {
    	return this.tableName;
    }
    public ArrayList<Dish> getDishes() {
    	return this.dishes;
    }
    public ArrayList<Drink> getDrinks() {
    	return this.drinks;
    }
    
    public void setTableName(String tn) {
    	this.tableName= tn;
    }
    public void setDishes(ArrayList<Dish> ds) {
    	this.dishes= ds;
    }
    public void setDrinks(ArrayList<Drink> dr) {
    	this.drinks= dr;
    }
    
}

