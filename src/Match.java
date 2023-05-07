import java.util.ArrayList;
import java.io.*;
import java.net.*;

public class Match extends Thread {

	public ArrayList<Socket> lst = new ArrayList<Socket>();
	private int qntPlay;
	private int codRoom;
	private String theme;
	private String Word;

	public Match(ArrayList<Socket> lst, int qntPlay, int codRoom, String theme, String Word) {

		this.lst = lst;
		this.qntPlay = qntPlay;
		this.codRoom = codRoom;
		this.theme = theme;
		this.Word = Word;
	}

	public ArrayList<Socket> getLst() {
		return lst;
	}

	public void setLst(ArrayList<Socket> lst) {
		this.lst = lst;
	}

	public int getQntPlay() {
		return qntPlay;
	}

	public void setQntPlay(int qntPlay) {
		this.qntPlay = qntPlay;
	}

	public int getCodRoom() {
		return codRoom;
	}

	public void setCodRoom(int codRoom) {
		this.codRoom = codRoom;
	}

	public void run() {

		try {

//			
//	        int qtdAcertos = 0;
//	        char[ ]  palavra = new char[] {'t','e','s','t','e'};
//	        char[ ] painel = new char[palavra.length];

			boolean hit = true;

			char[] vetorWord = stringToArray(this.Word);

			// while(qtdAcertos<qtdAcertos){
			// loop - faz um PARA para percorer os socket
			// loop - enquanto o jogador tiver acertando

			// se o jogador vencedor ele sai de todos os loops
			// se ele errar vai para o proximo jogador do para
			while (true) {
				for (Socket player : this.lst) {
					hit = true;
					while (hit) {

						OutputStream out = player.getOutputStream();
						out.write("1".getBytes());
						out.flush();

						InputStream in = player.getInputStream();

						byte[] b = new byte[1024];
						String letra = new String(b, 0, in.read(b));
						

						if (this.Word.contains(letra)) {
							System.out.println("entrou aqui");
							for (Socket s : this.lst) {
								out = s.getOutputStream();
								out.write("s".getBytes());
								out.flush();
							}
							
							for (Socket c : this.lst) {
								for (int i = 0; i < vetorWord.length; i++) {
									if (vetorWord[i] == letra.charAt(0)) {
										System.out.println("passou 1");
										out = c.getOutputStream();
										out.write((Integer.toString(i)+"\n").getBytes()); 
										out.flush();
									}
								}
								out.write("fim".getBytes());
								out.flush();
							}
							
							
//							for (int i = 0; i < vetorWord.length; i++) {
//								if (vetorWord[i] == letra.toUpperCase().charAt(0)) {
//									for (Socket c : this.lst) {
//										out = c.getOutputStream();
//										out.write(Integer.toString(i).getBytes()); 
//										out.flush();
//										out.write(letra.getBytes());
//										out.flush();
//										out.write("n".getBytes());
//										out.flush();
//									}
//								}
//							}
						}
						hit = false;
					}
				}
			}
			// }

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public char[] stringToArray(String palavra) {
		char[] vetorPalavra = new char[palavra.length()];

		char[] stringConvertida = palavra.toCharArray();
		System.arraycopy(stringConvertida, 0, vetorPalavra, 0, stringConvertida.length);

		return vetorPalavra;
	}
}
