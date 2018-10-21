package objet;

import util.CreditException;
import util.DebitException;

public class Livreur extends Client{

	
	/**
	 * Constructeur de la class Livreur.
	 * Hérite du super constructeur Client. 
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param solde
	 */
	public Livreur(int id, String nom, String prenom, double solde) {
		super(id, nom, prenom, solde);
	}
	
	/**
	 * Override de la méthode debiterCompte pour les livreurs,
	 * leur permet ainsi un découvert (solde négatif).
	 * @param montant
	 */
	@Override
	public void debiterCompte(double montant) throws DebitException {
		if(montant < 0){
			String errorMsg = "Montant négatif, utilisez plutôt la méthode crediterCompte.";
			throw new DebitException(errorMsg);
			
		}else{
			solde -= montant; // Le solde est débiter du montant en paramètre
//			soldeDeTousLesComptes -= montant;
//			moyenneSoldes = soldeDeTousLesComptes/nombreDeCompte;
//			soldeMisAJour(solde);
		}
	}


	/**
	 * Override de la méthode crediterCompte pour les livreurs,
	 * leur permet de créditer plus de 5000€
	 * @param montant
	 */
	@Override
	public void crediterCompte(double montant) throws CreditException {

		if(montant < 0){
			String errorMsg = "Montant négatif, utilisez plutôt la méthode debiterCompte.";
			throw new CreditException(errorMsg);
			
		} else{
			solde += montant; // Le solde est alimenté du montant en paramètre
//			soldeDeTousLesComptes += montant;
//			moyenneSoldes = soldeDeTousLesComptes/nombreDeCompte;
//			soldeMisAJour(solde);
		}
	}

}
