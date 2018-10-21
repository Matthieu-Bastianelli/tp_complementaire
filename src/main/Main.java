package main;

import java.util.Collections;

import dao.ClientDao;
import dao.PizzaDao;
import objet.Pizza;
import util.EnumTypePizza;
import util.PizzaException;
import util.TriPizzaParDesignation;
import util.TriPizzaParPrix;

public class Main {

	public static void main(String[] args) {
		
		//-----------------------------------------------------------------------------------------------
		// Test et initialisation de la classe Pizza :
		//---------------------------------------------
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
//		System.out.println(pizzaDao.toString());
//		
		Pizza pizza = pizzaDao.findPizzaByCode("MAR");
//		System.out.println(pizza.toString());
//		
//		System.out.println(pizzaDao.pizzaExists("MAR"));
//		System.out.println(pizzaDao.pizzaExists("NON"));
//		
		pizzaDao.deletePizza(pizza.getCode());
//		System.out.println(pizzaDao.toString());
		
		pizzaDao.saveNewPizza(pizza);
//		System.out.println(pizzaDao.toString());
		
		try {
			Pizza pizza2 = new Pizza("CRU", "Crudités", 6.40f, EnumTypePizza.CRUDITE);
			pizzaDao.updatePizza(pizza.getCode(), pizza2);
//			System.out.println(pizzaDao.toString());
			
		} catch (PizzaException e) {
			
			e.printStackTrace();
			
			System.out.println("La pizza n'a pas pu être créée\r\n\r\n");
			System.out.println(e.getMessage());
		}
		
//
//		System.out.println("Tri des pizzas par Désignation :\r\n");
		TriPizzaParDesignation triPizzaParDesignation = new TriPizzaParDesignation();
		Collections.sort(pizzaDao.findAllPizzas(), triPizzaParDesignation);
//		System.out.println(pizzaDao.toString());
//		
		System.out.println("Tri des pizzas par prix :\r\n");
		TriPizzaParPrix triPizzaParPrix = new TriPizzaParPrix();
		Collections.sort(pizzaDao.findAllPizzas(), triPizzaParPrix);
		System.out.println(pizzaDao.toString());


		//-----------------------------------------------------------------------------------------------
		// Test de la classe Client :
		//---------------------------
		

		
//		System.out.println("Test Clients :\r\n");
//		
		//Création d'un client :		
//		Client client1 = new Client(1, "Bastianelli", "Matthieu", 30);
//
//		try{
////			client1.crediterCompte(5000);
////			client1.debiterCompte(40);
//			client1.crediterCompte(20);
//			System.out.println(client1.getSolde());
//			
//			client1.commandePizza(pizza);
//			System.out.println(client1.getSolde());
//												
//		}catch (Exception error){
//			System.out.println("Une erreur c'est produite.");
//			error.getMessage();
//			error.getCause();
//			error.printStackTrace();
//			
////		}
//
//		System.out.println(client1.toString());
		

		//Création d'un clientDao :		
		ClientDao clientDao = new ClientDao();
		
		
		//Test affichage de tous les clients de la dao :
		clientDao.afficherAllClients();


		clientDao.bilanComptes();
		


		//-----------------------------------------------------------------------------------------------
		// Test de la classe Livreur :
		//----------------------------
//		System.out.println("Test Livreurs :\r\n");
//		
//		//Création d'un Livreur
//		Livreur livreur1=new Livreur(11, "Laposte", "Jean", 25);
//		
//		System.out.println(livreur1.toString());
//		
//		//Test de débit supérieur au solde :
//		try {
//			livreur1.debiterCompte(40);
//		} catch (Exception error) {
//			System.out.println("Une erreur c'est produite.");
//			error.getMessage();
//		}
//
//		System.out.println(livreur1.toString());
//		
//				//Test de crédit aboutissant à un solde supérieur à 5000€ :
//				try {
//					livreur1.crediterCompte(5040);
//				} catch (Exception error) {
//					System.out.println("Une erreur c'est produite.");
//					error.getMessage();
//				}
//
//				System.out.println(livreur1.toString());
//
//
//				//Test de commande pour livreur :
//				try {
//					livreur1.commandePizza(pizza);
//					} catch (Exception error) {
//						System.out.println("Une erreur c'est produite.");
//						error.getMessage();
//					}
//				System.out.println(livreur1.toString());
				
				

	}

}
