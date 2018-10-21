package util;

public class CreditException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * CreditException :
	 * Affiche un message 'message' d'erreur entré en paramètre
	 * ainsi que le StackTrace, le message et la cause de l'erreur (héritage de la Class Exception).
	 * @param message
	 */
	public CreditException(String message) {
        super(message);
        System.out.println(message);
        
    }
}