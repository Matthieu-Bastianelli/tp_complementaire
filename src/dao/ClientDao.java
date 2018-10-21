package dao;

import java.util.ArrayList;
import java.util.List;

import objet.Client;
import objet.Livreur;


public class ClientDao {

	private List<Client> listClient = null;
	
	/**
	 * Constructeur de la liste de client.
	 */
	public ClientDao(){
		super();
		
		listClient = new ArrayList<Client>();
		
		listClient.add(new Client(1, "Bastianelli", "Matthieu", 30));		
		listClient.add(new Client(2, "PresseLes", "Elvis", 100));		
		listClient.add(new Client(3, "Maurice", "Noel", 1050));		
		
		//Les livreurs sont des clients particuliers (héritage) :
		listClient.add(new Livreur(11, "Gary", "Romain", 5075));
		
		listClient.add(new Client(4, "de LaFontaine", "Jean", 30));
		
		
		//Les livreurs sont des clients particuliers (héritage) :
		listClient.add(new Livreur(12, "Laposte", "Jean", -25));
	}
	
	
	/**
	 * Affichage de tous les clients de ClientDao :
	 */
	public void afficherAllClients(){
		
		for (Client client : listClient){
			System.out.println(client.toString());
		}
		System.out.println("\r\n");
	}
	
	

	/**
	 * Méthode Static permettant d'afficher le nombre de compte,
	 * la somme de tous les comptes, le solde moyen,
	 * le solde minimum et le solde maximum.
	 */
	public void bilanComptes(){
		

		int nombreDeCompte=listClient.size();
		double soldeDeTousLesComptes=0;
		double moyenneSoldes=0;
		double soldeMin=listClient.get(0).getSolde();
		double soldeMax=listClient.get(0).getSolde();
		
		if(nombreDeCompte>0){
			// Parcours de la liste des clients lorsqu'elle n'est pas vide
			for(Client client : listClient){
				double solde = client.getSolde();
				
				soldeDeTousLesComptes += solde;
				
				soldeMin = (soldeMin <= solde)? soldeMin : solde ;
				soldeMax = (soldeMax >= solde)? soldeMax : solde ;
			}
			
			moyenneSoldes = soldeDeTousLesComptes/nombreDeCompte;
		}

		StringBuffer result = new StringBuffer();
		result.append("\r\n\r\n************* BILAN DES COMPTES EXISTANTS *************\r\n\r\n");
		result.append("Nombre de comptes = "+nombreDeCompte+"\r\n");
		result.append("Total Solde de tous les comptes = "+soldeDeTousLesComptes+"\u20ac\r\n");
		result.append("Moyenne Solde = "+moyenneSoldes+"\u20ac\r\n");
		result.append("Solde le plus faible ="+soldeMin+"\u20ac\r\n");
		result.append("Solde le plus élevé ="+soldeMax+"\u20ac\r\n");
		System.out.println(result);
	}

}
