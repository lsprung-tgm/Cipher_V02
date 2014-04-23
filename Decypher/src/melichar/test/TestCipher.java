package melichar.test;

import java.util.ArrayList;


import melichar.cipher.SubstitutionCipher;

import org.junit.*;

public class TestCipher {

	private final String wort = "Melichar";
	private final String wortTwo = "Melichar Daniel";
	
	private ArrayList<String> secretAlphabet;
	private ArrayList<String> encrypted;
	private ArrayList<String> decrypted;

	private SubstitutionCipher sc;
	
	@Before
	public void secretAlphabetSetup() {
		secretAlphabet = new ArrayList<String>();
		
		secretAlphabet.add("ISYVKJRUXEDZQMCTPLOFNBWGAH");
		secretAlphabet.add("NBURLXCTPQMGIDSYEZWOFVKAJH");
		secretAlphabet.add("JRSFEHZBGPNQWUIKALOXDTYCVM");
		secretAlphabet.add("IZPHKBGONUYLSRCAJDFWXQVTEM");
		secretAlphabet.add("DMEFGVQOKPTAINXWJSLYBRCUZH");
		secretAlphabet.add("CGZXENPRTABYFMWJLHISKQOUDV");
		secretAlphabet.add("MJBSAPUFNHYVOKCGLXIREQDZWT");
		secretAlphabet.add("LJTXDIBAHGOZMSWNKQCVPUERFY");
		secretAlphabet.add("VKYUPIXHQNASLTWDOGBRJZFCEM");
		secretAlphabet.add("URAECSOGFQYVTPKDBXWZJHNILM");
		
		sc = new SubstitutionCipher();
		encrypted = new ArrayList<String>();
		decrypted = new ArrayList<String>();
	}
		
	@Test
	public void test() {
		for(int x=0; x<secretAlphabet.size(); x++) {
			sc.setSecretAlphabeticCipher(secretAlphabet.get(x));
			System.out.println(sc.getSecretAlphabet());
			
			encrypted.add(sc.encrypt(wort));
			System.out.println(encrypted.get(x));
			decrypted.add(sc.decrypt(encrypted.get(x)));
			System.out.println(decrypted.get(x));
			
			System.out.println();
		}
	}
	
	@Test
	public void testTwoWords() {
		for(int x=0; x<secretAlphabet.size(); x++) {
			sc.setSecretAlphabeticCipher(secretAlphabet.get(x));
			System.out.println(sc.getSecretAlphabet());
			
			encrypted.add(sc.encrypt(wortTwo));
			System.out.println(encrypted.get(x));
			decrypted.add(sc.decrypt(encrypted.get(x)));
			System.out.println(decrypted.get(x));
			
			System.out.println();
		}
	}
}
