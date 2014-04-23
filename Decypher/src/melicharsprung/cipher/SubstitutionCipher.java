package melicharsprung.cipher;


/**
* Klasse SubstitutionCipher erbt von der MonoalphabeticCipher Klasse die Methoden und den Parameter
* und setzt durch ein Kennwort ein geheimes Alphabet.
* @author Daniel Melichar
* @version 31.03.2014
*/
public class SubstitutionCipher extends MonoalphabeticCipher {
	
	/**
     * Konstruktor zur Klasse
     * @param keyword
    */
	public SubstitutionCipher()	{
		super("VMYWFARXIJHQBKCPDLOUNTSGEZ");
		setSecretAlphabeticCipher("VMYWFARXIJHQBKCPDLOUNTSGEZ");
	}
	
	public SubstitutionCipher(String secretAlphabeticCode) {
		 super(secretAlphabeticCode);
         setSecretAlphabeticCipher(secretAlphabeticCode);
	}
	
	 /**
     * Methode welches ein geheimes Alphabet mit einem Kennwort erstellt.
     * @param keyword
    */
	public void setSecretAlphabeticCipher(String secretAlphabeticCode) {
        secretAlphabeticCode = secretAlphabeticCode.toLowerCase();
        StringBuffer sb = new StringBuffer(secretAlphabeticCode);

        for (int z=0; z<sb.length(); z++) {
                char buchstabe = sb.charAt(z);
                for (int i=sb.length()-1; i>=0; i--) {
                        if (sb.charAt(i)==buchstabe && z!=i) {
                                sb.deleteCharAt(i);
                        }
                }
        }
        
        secretAlphabeticCode = "" + sb;
        for (int i=0; i<26; i++) {
                char buchstabe = (char) ('z' - i);
                boolean doppelt = false;
                for (int z=0; z<secretAlphabeticCode.length(); z++) {
                        if (secretAlphabeticCode.charAt(z) == buchstabe) {
                                doppelt = true;
                        }
                }
                if (doppelt == false) {
                        secretAlphabeticCode = secretAlphabeticCode + buchstabe;
                }
        }
        secretAlphabeticCode = secretAlphabeticCode.toUpperCase();
        setSecretAlphabet(secretAlphabeticCode);
	}
}
