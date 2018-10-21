package util;

public class DebitException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * DebitException :
	 * Affiche un message 'message' d'erreur entré en paramètre.
	 * @param message
	 */
	public DebitException(String message) {
        super(message);
		System.out.println(message);

        
    }
}
