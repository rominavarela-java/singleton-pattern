package mx.iteso.singleton.chocoholic.table.impl;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import mx.iteso.singleton.chocoholic.Dish;
import mx.iteso.singleton.chocoholic.Drink;
import mx.iteso.singleton.chocoholic.table.TableOrder;

public class Table4Test {
	
	Dish dish;
	Drink drink;
	TableOrder tableOrder;
	
	@Before
	public void setup() {
		dish= new Dish();
		dish.setPrice((float) 10.0);
		dish.setName("test dish");
		dish.setWaiter("waiter1");
		dish.setDescription("");
		
		drink= new Drink();
		drink.setPrice((float) 20.0);
		drink.setName("test drink");
		drink.setWaiter("waiter2");
		drink.setDescription("");
		
		tableOrder= Table4.getInstance();
		tableOrder.addDish(dish);
		tableOrder.addDrink(drink);
	}
	
	@Test
	public void TestGetInstance() throws InterruptedException {
		ArrayList<TestGetInstanceRunnable> runnables= new ArrayList<TestGetInstanceRunnable>();
		ArrayList<Thread> threads= new ArrayList<Thread>();
		
		for(int i=0; i<5; i++) 
		{
			TestGetInstanceRunnable runnable = new TestGetInstanceRunnable();
			runnables.add(runnable);
			threads.add( new Thread(runnable));
		}
		
		for(Thread t: threads)
			t.run();
		
		for(Thread t: threads)
			t.join();
		
		for(TestGetInstanceRunnable r: runnables)
			Assert.assertEquals(tableOrder, r.order);
	}
	
	class TestGetInstanceRunnable implements Runnable{
		public TableOrder order;
		
		public void run() {
	        this.order = Table4.getInstance();
		}
	}
	
	@Test
	public void TestClearOrder() throws InterruptedException {
		ArrayList<TestClearOrderRunnable> runnables= new ArrayList<TestClearOrderRunnable>();
		ArrayList<Thread> threads= new ArrayList<Thread>();
		
		for(int i=0; i<5; i++) 
		{
			TestClearOrderRunnable runnable = new TestClearOrderRunnable(tableOrder);
			runnables.add(runnable);
			threads.add( new Thread(runnable));
		}
		
		for(Thread t: threads)
			t.run();
		
		for(Thread t: threads)
			t.join();
		
		Assert.assertNotSame(tableOrder, Table4.getInstance());
	}
	
	class TestClearOrderRunnable implements Runnable{
		public Table4 order;
		
		public TestClearOrderRunnable(TableOrder order){
			this.order= (Table4) order;
		}
		
		public void run() {
	        this.order.clearOrder();
		}
	}
	
	@Test
	public void TestClearDrinks() throws InterruptedException {
		ArrayList<TestClearDrinksRunnable> runnables= new ArrayList<TestClearDrinksRunnable>();
		ArrayList<Thread> threads= new ArrayList<Thread>();
		
		for(int i=0; i<5; i++) 
		{
			TestClearDrinksRunnable runnable = new TestClearDrinksRunnable(tableOrder);
			runnables.add(runnable);
			threads.add( new Thread(runnable));
		}
		
		for(Thread t: threads)
			t.run();
		
		for(Thread t: threads)
			t.join();
		
		Assert.assertTrue(tableOrder.getDrinks().isEmpty());
	}
	
	class TestClearDrinksRunnable implements Runnable{
		public Table4 order;
		
		public TestClearDrinksRunnable(TableOrder order){
			this.order= (Table4) order;
		}
		
		public void run() {
	        this.order.clearDrinks();
		}
	}
	
	@Test
	public void TestClearDishes() throws InterruptedException {
		ArrayList<TestClearDishesRunnable> runnables= new ArrayList<TestClearDishesRunnable>();
		ArrayList<Thread> threads= new ArrayList<Thread>();
		
		for(int i=0; i<5; i++) 
		{
			TestClearDishesRunnable runnable = new TestClearDishesRunnable(tableOrder);
			runnables.add(runnable);
			threads.add( new Thread(runnable));
		}
		
		for(Thread t: threads)
			t.run();
		
		for(Thread t: threads)
			t.join();
		
		Assert.assertTrue(tableOrder.getDishes().isEmpty());
	}
	
	class TestClearDishesRunnable implements Runnable{
		public Table4 order;
		
		public TestClearDishesRunnable(TableOrder order){
			this.order= (Table4) order;
		}
		
		public void run() {
	        this.order.clearDishes();
		}
	}
	
	@Test
	public void TestPrintCheck() throws InterruptedException {
		ArrayList<TestPrintCheckRunnable> runnables= new ArrayList<TestPrintCheckRunnable>();
		ArrayList<Thread> threads= new ArrayList<Thread>();
		
		for(int i=0; i<5; i++) 
		{
			TestPrintCheckRunnable runnable = new TestPrintCheckRunnable(tableOrder);
			runnables.add(runnable);
			threads.add( new Thread(runnable));
		}
		
		for(Thread t: threads)
			t.run();
		
		for(Thread t: threads)
			t.join();
		
	}
	
	class TestPrintCheckRunnable implements Runnable{
		public Table4 order;
		
		public TestPrintCheckRunnable(TableOrder order){
			this.order= (Table4) order;
		}
		
		public void run() {
	        this.order.printCheck();
		}
	}
}
