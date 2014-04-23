package melicharsprung.cipher;

/**
 * Transposition Cipher
 * 
 * @author Daniel Melichar
 * @version 23-04-2014
 *
 */
public class TranspositionCipher implements Cipher {

	private int transpositionLevel;
	
	public TranspositionCipher() {
		this.transpositionLevel = 5;
	}
	
	public void setTranspositionLevel(int level) {
		this.transpositionLevel = level;
	}
	
	private String processInput(String text) {
		text = text.toUpperCase();
		text = text.replaceAll("\\s+","");
		return text;
	}
	
	@Override
	public String encrypt(String plainText) {
		String text = processInput(plainText);
		
		int r = transpositionLevel;
		int length = text.length();
		int c=length/transpositionLevel;
		char mat[][] = new char[r][c];
		int k=0;
		   
		String cipherText="";
		   
		for(int i=0;i< c;i++) {
			for(int j=0;j< r;j++) {
				if(k!=length)
					mat[j][i]=text.charAt(k++);
				else
					mat[j][i]='X';
			}
		}
		 
		for(int i=0;i< r;i++) {
			for(int j=0;j< c;j++) {
				cipherText+=mat[i][j];
			}
		}
		
		return cipherText;
	}

	@Override
	public String decrypt(String cipherText) {
		String text = processInput(cipherText);
		
		int r = transpositionLevel;
		int length = text.length();
		int c=length/transpositionLevel;
		char mat[][]=new char[r][c];
		int k=0;
		   
		String plainText="";
		   
		   
		for(int i=0;i< r;i++) {
			for(int j=0;j< c;j++) {
				mat[i][j]=text.charAt(k++);
			}
		}
		  
		for(int i=0;i< c;i++) {
			for(int j=0;j< r;j++) {
				plainText+=mat[j][i];
			}
		}
  
		return plainText;
	}
}