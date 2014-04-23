package melicharsprung.cipher;

public class ShiftCipher extends MonoalphabeticCipher{

	public ShiftCipher(int value) {
		super();
		setShiftAmmount(value);
	}
	
	/**
	 * Der Shift Cipher generiert ein Geheimalphabet. Dazu wird eine Zahl �bergebn, anschlie�end 
	 * werden alle Buchstaben von einem NORMALEN Alphabet um die Zahl versetz dass zum Beispiel
	 * bei einer Zahl von 3 aus 'a' ein 'd' wird aus einem 'b' ein 'e' usw.....
	 * @param shiftvalue
	 */
	public void  setShiftAmmount(int shiftvalue) {
		char[] normalphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		String geheimalphabet = "";
		for(int i = 0; i < normalphabet.length; i++) {
			char stellez = 'a';
			for(int j = 1; 1 <= shiftvalue; j++) {
				stellez = normalphabet[i]+=j;
				if(stellez > 122) stellez = 97; else{stellez+=1;}
			}
			geheimalphabet+=stellez;
		}
	}
}
