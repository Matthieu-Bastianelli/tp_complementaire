package objet;

import util.CompteStat;
import util.CreditException;
import util.DebitException;

public class Client implements CompteStat {
	/**
	 * Attributs de la class Client : 
	 * id, nom, prenom, solde.
	 */
	protected int id = Integer.MIN_VALUE;
	protected String nom = null;
	protected String prenom = null;
	protected double solde = Double.MIN_VALUE;
	
	/**
	 * Attributs statics (communs à client et classe héritantes : Livreur)
	 * nombreDeCompte, soldeDeTousLesComptes, moyenneSoldes, soldeMin, soldeMax
	 */
	
//	public static int nombreDeCompte=0;
//	public static double soldeDeTousLesComptes=0;
//	public static double moyenneSoldes=0;
//	public static double soldeMin=0;
//	public static double soldeMax=0;

	//-----------------------------------------------------------------------------------------------
	// Constructeurs :
	//----------------
	/**
	 * Constructeur de class Client : 
	 * Renvoie un CreditException si le solde dépasse les 5000€.
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param solde
	 */
	public Client(int id, String nom, String prenom, double solde)  {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		
//		if (solde > 5000){
//			String errorMsg = "Le solde atteint la limite maximale de 5000\u20ac.\n "
//					+ "Êtes vous entrain d'essayer de blanchir de l'argent?";
//			throw new CreditException(errorMsg);
//		} else if (solde < 0){
//				String errorMsg = "Montant négatif, utilisez plutôt la méthode crediterCompte.";
//				throw new DebitException(errorMsg);
//		}else{
			this.solde = solde;
			
//			//Permet d'initialiser les valeurs minimales de solde Min et soldeMax lors de la création du premier Client
//			if (nombreDeCompte == 0){ 
//				soldeMin=solde;
//				soldeMax=solde; 
//			}
			
//			ajoutCompte(solde);
//		}
	}

	//-----------------------------------------------------------------------------------------------
	// Méthodes :
	//-----------

	/**
	 * Méthode permettant de créditer le solde d'un objet Client.
	 * Renvoie un CreditException si le solde devait dépasser les 5000€ à l'issue de l'opération 
	 * ou si le montant du crédit est négatif.
	 * @param montant
	 */
	public void crediterCompte(double montant) throws CreditException{
		
		if(montant < 0){
			String errorMsg = "Montant négatif, utilisez plutôt la méthode debiterCompte.";
			throw new CreditException(errorMsg);
			
		}else if (solde+montant > 5000){
			String errorMsg = "Le solde atteint la limite maximale de 5000\u20ac.\n "
					+ "Êtes vous entrain d'essayer de blanchir de l'argent?";
			throw new CreditException(errorMsg);
			
		}else{
			solde += montant; // Le solde est alimenté du montant en paramètre
//			soldeDeTousLesComptes += montant;
//			moyenneSoldes = soldeDeTousLesComptes/nombreDeCompte;
//			soldeMisAJour(solde);
		}
	}


	/**
	 * Méthode permettant de débiter le solde d'un objet Client.
	 * Renvoie un DeditException si le solde devait devenir strictement négatif à l'issue de l'opération 
	 * ou si le montant du débit est négatif.
	 * @param montant
	 */
	public void debiterCompte(double montant) throws DebitException{

		if(montant < 0){
			String errorMsg = "Montant négatif, utilisez plutôt la méthode crediterCompte.";
			throw new DebitException(errorMsg);
			
		}else if (solde-montant < 0){
				String errorMsg = "Le solde du Client est insuffisant. La maison ne fait pas crédit";
				throw new DebitException(errorMsg);
			
		}else{
			solde -= montant; // Le solde est débiter du montant en paramètre
//			soldeDeTousLesComptes -= montant;
//			moyenneSoldes = soldeDeTousLesComptes/nombreDeCompte;
//			soldeMisAJour(solde);
		}
		
	}
	
	/**
	 * Opération de commande d'une pizza par le client.
	 * Si le solde du client est insuffisant pour payer le prix de la pizza, 
	 * la DebitException générée est renvoyée lors de la commande.
	 * @param pizza
	 * @throws DebitException
	 */
	public void commandePizza(Pizza pizza) throws DebitException{
		this.debiterCompte(pizza.getPrix());
	}
	
	/**
	 * Méthode to String pour générer une chaine de caractère présentant les attributs
	 * de l'objet Client considéré.
	 */
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", solde=" + solde + "]";
	}

	/**
	 * Implementation de la méthode getSolde de l'interface CompteStat
	 */
	@Override
	public double getSolde() {
		return solde;
	}

//	/**
//	 * Méthode permettant lors de l'ajout d'un compte
//	 * de mettre à jours les attributs statics de la classe client
//	 * @param montantSolde
//	 */
//	protected static void ajoutCompte(double soldeNouveauCompte) {
//		nombreDeCompte++;
//		soldeDeTousLesComptes += soldeNouveauCompte;
//		moyenneSoldes = soldeDeTousLesComptes/nombreDeCompte;
//		soldeMisAJour(soldeNouveauCompte);
//	}
	
	
//	/**
//	 * Méthode permettant de mettre à jour les attributs statics
//	 *  soldeMin et soldeMax lorsqu'un compte à était mis à jour.
//	 * @param nouveauSolde
//	 */
//	protected static void soldeMisAJour(double nouveauSolde) {
//		soldeMin = (soldeMin <= nouveauSolde)? soldeMin : nouveauSolde ;
//		soldeMax = (soldeMax >= nouveauSolde)? soldeMax : nouveauSolde ;
//	}
	

//	/**
//	 * Méthode Static permettant d'afficher le nombre de compte,
//	 * la somme de tous les comptes, le solde moyen,
//	 * le solde minimum et le solde maximum.
//	 */
//	public static void bilanComptes(){
//		StringBuffer result = new StringBuffer();
//
//		result.append("\r\n\r\n************* BILAN DES COMPTES EXISTANTS *************\r\n\r\n");
//
//		result.append("Nombre de comptes = "+Client.nombreDeCompte+"\r\n");
//		result.append("Total Solde de tous les comptes = "+Client.soldeDeTousLesComptes+"\u20ac\r\n");
//		result.append("Moyenne Solde = "+Client.moyenneSoldes+"\u20ac\r\n");
//		result.append("Solde le plus faible ="+Client.soldeMin+"\u20ac\r\n");
//		result.append("Solde le plus élevé ="+Client.soldeMax+"\u20ac\r\n");
//		System.out.println(result);
//	}
	

}
