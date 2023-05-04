import java.util.Iterator;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int te = 1223;
		
		String a = Integer.toString(te);
		
		System.out.println(a.contains("7"));
		
		

	}
	
	
	
	public static char[]  stringToArray(String palavra) {
		char[] vetorPalavra = new char[palavra.length()];
		
		char[] stringConvertida = palavra.toCharArray();
		System.arraycopy(stringConvertida, 0, vetorPalavra, 0, stringConvertida.length);

		
		return vetorPalavra;
	}

}


