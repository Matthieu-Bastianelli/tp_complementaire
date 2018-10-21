package main;

import java.util.Collections;
import java.util.Comparator;

import dao.PizzaDao;
import objet.Pizza;
import util.EnumTypePizza;
import util.PizzaException;
import util.TriPizzaParDesignation;
import util.TriPizzaParPrix;

public class Main {

	public static void main(String[] args) {
		
		PizzaDao pizzaDao = null;
		
		try
		{
			pizzaDao = new PizzaDao();
		} catch (PizzaException e) {
			e.printStackTrace();
			
			// le DAO n'est pas correct : le programme est arrêté
			System.out.println("Erreur lors de la création du DAO : le programme ne peut pas continuer");
			System.exit(-1);
		}
		System.out.println(pizzaDao.toString());
		
		Pizza pizza = pizzaDao.findPizzaByCode("MAR");
		System.out.println(pizza.toString());
		
		System.out.println(pizzaDao.pizzaExists("MAR"));
		System.out.println(pizzaDao.pizzaExists("NON"));
		
		pizzaDao.deletePizza(pizza.getCode());
		System.out.println(pizzaDao.toString());
		
		pizzaDao.saveNewPizza(pizza);
		System.out.println(pizzaDao.toString());
		
		try {
			Pizza pizza2 = new Pizza("CRU", "Crudités", 6.40f, EnumTypePizza.CRUDITE);
			pizzaDao.updatePizza(pizza.getCode(), pizza2);
			System.out.println(pizzaDao.toString());
			
		} catch (PizzaException e) {
			
			e.printStackTrace();
			
			System.out.println("La pizza n'a pas pu être créée\r\n\r\n");
			System.out.println(e.getMessage());
		}
		
		

		System.out.println("Tri des pizzas par Désignation :\r\n");
		TriPizzaParDesignation triPizzaParDesignation = new TriPizzaParDesignation();
		Collections.sort(pizzaDao.findAllPizzas(), triPizzaParDesignation);
		System.out.println(pizzaDao.toString());
		
		System.out.println("Tri des pizzas par prix :\r\n");
		TriPizzaParPrix triPizzaParPrix = new TriPizzaParPrix();
		Collections.sort(pizzaDao.findAllPizzas(), triPizzaParPrix);
		System.out.println(pizzaDao.toString());
		
		
	}

}
