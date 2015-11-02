package mx.iteso.singleton;

import java.util.ArrayList;

import mx.iteso.singleton.chocoholic.Dish;
import mx.iteso.singleton.chocoholic.Drink;
import mx.iteso.singleton.chocoholic.table.TableOrder;
import mx.iteso.singleton.chocoholic.table.impl.Table1;
import mx.iteso.singleton.chocoholic.table.impl.Table4;

public class Main {
    public static void main (String[] args){   	
    	ArrayList<Thread> waiters= new ArrayList<Thread>();
    	
    	waiters.add(new Thread(new Runnable() {
			public void run() {
				TableOrder order;
				Drink drink;
		        Dish dish;

		        order = Table4.getInstance();
		        drink = new Drink();
		        drink.setName("Coke");
		        drink.setWaiter("Waiter A");
		        drink.setPrice(10);
		        order.addDrink(drink);

		        order = Table4.getInstance();
		        dish = new Dish();
		        dish.setName("Quesadilla Chicharron");
		        dish.setPrice(18);
		        dish.setWaiter("Waiter A");
		        order.addDish(dish);
		        
		        order.printCheck();
			}
		}));
    	
    	waiters.add(new Thread(new Runnable() {
			public void run() {
				TableOrder order;
				Drink drink;
		        Dish dish;

		        order = Table1.getInstance();
		        drink = new Drink();
		        drink.setName("Coke");
		        drink.setWaiter("Waiter B");
		        drink.setPrice(10);
		        order.addDrink(drink);

		        order = Table4.getInstance();
		        drink = new Drink();
		        drink.setName("Coke");
		        drink.setWaiter("Waiter B");
		        drink.setPrice(10);
		        order.addDrink(drink);

		        order = Table4.getInstance();
		        dish = new Dish();
		        dish.setName("Chicken Pozole");
		        dish.setPrice(45);
		        dish.setWaiter("Waiter B");
		        order.addDish(dish);
		        
		        order.printCheck();
			}
		}));
    	
    	waiters.add(new Thread(new Runnable() {
			public void run() {
				TableOrder order;
		        Dish dish;

		        order = Table4.getInstance();
		        dish = new Dish();
		        dish.setName("Enchilada");
		        dish.setPrice(8);
		        dish.setWaiter("Waiter C");
		        order.addDish(dish);

		        dish = new Dish();
		        dish.setName("Enchilada");
		        dish.setPrice(8);
		        dish.setWaiter("Waiter C");
		        order.addDish(dish);
		        
		        order.printCheck();
			}
		}));
    	
    	for(Thread waiter: waiters)
    		waiter.start();
    	
    }
    
}

