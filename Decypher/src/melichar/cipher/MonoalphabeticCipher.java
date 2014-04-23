package melichar.cipher;

/**
 * Klasse MonoalphabeticCipher implementiert die Klasse Cipher. Es kann durch das Geheimalphabet
 * Wörter verschlüsseln als auch entschlüsseln.
 * @author Daniel Melichar
 * @version 31.03.2014
*/
public class MonoalphabeticCipher implements Cipher {

	private String secretAlphabet;
	
    /**
     * Konstruktor zur Klasse
     * @param secretAlphabet
    */
	public MonoalphabeticCipher(String secretAlphabet) {
		this.secretAlphabet = secretAlphabet;
	}
	

    /**
     * Getter Klasse. Gibt das geheime Alphabet zurück.
     * @return secretAlphabet
    */
	public String getSecretAlphabet() {
		return this.secretAlphabet;
	}
	
	/**
     * Setter Klasse. Setzt ein eigenes geheimes Alphabet.
     * @param secretAlphabet
    */
	protected void setSecretAlphabet(String secretAlphabet) {
		this.secretAlphabet = secretAlphabet;
	}
	
    /**
     * Klasse zum Verschlüsseln eines Textes mit Hilfe des geheimen Alphabtes
     * @param text
     * @return returntext
    */
	@Override
	public String encrypt(String text) {
        char[] bsarray = secretAlphabet.toCharArray();
        String returntext = "";
        
        for(int i=0; i<text.length(); i++) {
                char buchstabe = text.charAt(i);
                if (buchstabe >= 'a' && buchstabe <= 'z') {
                		// - 97 da a in der ASCI-Tabelle die dezimale Nummer 97 ist -> x-Stelle im Array
                		// und der geheime Buchstabe wird hinzugefügt
                        returntext = returntext + bsarray[buchstabe - 97];
                } else if (buchstabe >= 'A' && buchstabe <= 'Z') {
                		// - 65 da a in der ASCI-Tabelle die dezimale Nummer 65 ist -> x-Stelle im Array
                		// und der geheime Buchstabe wird hinzugefügt
                        returntext = returntext + bsarray[buchstabe - 65];
                } else {
                        System.err.println("Fehler: Ein Sonderzeichen oder eine Zahl war im Text.");
                        System.exit(0);
                }
        }
        returntext = returntext.toUpperCase();
        return returntext;
	}

    /**
     * Klasse zum Entschlüsseln eines Textes mit Hilfe des geheimen Alphabtes
     * @param text
     * @return returntext
    */
	@Override
	public String decrypt(String text) {
        char[] bsarray = secretAlphabet.toCharArray();
        String returntext = "";
        for (int i=0; i<text.length(); i++) {
                char buchstabe = text.charAt(i);
                if (buchstabe >= 'a' && buchstabe <= 'z') {
                        for (int a = 0; a < bsarray.length; a++) {
                        	  	// - 32 da das geheim Alphabet nur Großbuchstaben besitzt
                                if (((char) buchstabe - 32) == bsarray[a]) {
                                		// - 32 eben wie oben genannt + den ausgewählten Index des Alphabtes
                                        returntext = returntext + (char) ('a' - 32 + a);
                                }
                        }
                } else if (buchstabe >= 'A' && buchstabe <= 'Z') {
                        for (int a = 0; a < bsarray.length; a++) {
                                if (buchstabe == bsarray[a]) {
                                        returntext = returntext + (char) ('A' + a);
                                }
                        }
                } else {
                        System.err.println("Fehler: Ein Sonderzeichen oder eine Zahl war im Text.");
                        System.exit(0);
                }
        }
        returntext = returntext.toLowerCase();
        return returntext;
	}
	
}
