import java.util.Iterator;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String a = "teste";
		char c;
		
		char[] oux = a.toCharArray();
		
		c = oux[0];
		
		
		System.out.println(c);
		// System.out.println(a.length());
		char[] b = new char[5];
		b[0] = 't';
		b[1] = 'e';
		b[2] = 's';
		b[3] = 't';
		b[4] = 'e';
		
//		String str = new String(b);
//		if(a.equals(str)) {
//			System.out.println("entrou no if");
//		}
//		System.out.println(b.length);
//
//		for (char c : b) {
//			System.out.println(c);
//		}
		
		//int c = b.length;
		
		//System.out.println(c);

	}

	public static char[] stringToArray(String palavra) {
		char[] vetorPalavra = new char[palavra.length()];

		char[] stringConvertida = palavra.toCharArray();
		System.arraycopy(stringConvertida, 0, vetorPalavra, 0, stringConvertida.length);

		return vetorPalavra;
	}

}
