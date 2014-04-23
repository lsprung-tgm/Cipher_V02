package melicharsprung.cipher;

public class KeywordCipher extends MonoalphabeticCipher {

	public KeywordCipher(String keyword) {
		setKeyword(keyword);
	}
	/**
	 * Der KeywordCipher funktioniert so:
	 * 
	 * Ein Codewort wird übergeben z.B. "cipher"
	 * Das gesetzte Geheimalphabet sieht dann wie folgt aus:
	 *  "cipherabdfgjklmnopqstuvwxyz"
	 *  
	 *  --> Das Codewort wird vorne drangeschrieben und dann kommen alle Buchstaben die das
	 *  Wort noch nicht beinhaltet alphabetisch sortiert hinten dran
	 * @param keyword
	 */
	public void setKeyword(String keyword) {
		String codewordal = keyword.toLowerCase();
		for(char i = 97; i < 122; i++){
			if(codewordal.contains(i+"")); else {
				codewordal+=i;
			}
		}
	}
}
