import java.util.ArrayList;
import java.io.*;
import java.net.*;

public class Match extends Thread {

	public ArrayList<Socket> lst = new ArrayList<Socket>();
	private int qntPlay;
	private int codRoom;
	private String theme;
	private String word;

	public Match(ArrayList<Socket> lst, int qntPlay, int codRoom, String theme, String word) {

		this.lst = lst;
		this.qntPlay = qntPlay;
		this.codRoom = codRoom;
		this.theme = theme;
		this.word = word;
	}


	public void run() {

		try {

			boolean hit = true;
			char[] vetorWord = stringToArray(this.word);

			for (Socket c : this.lst) {
				OutputStream outL = c.getOutputStream();
				outL.write((this.word + "\n").getBytes());
				outL.flush();
				outL.write((this.theme + "\n").getBytes());
			}

			while (true) {
				for (Socket player : this.lst) {
					hit = true;
					while (hit) {

						// Envia confirmação para o cliente
						DataOutputStream out = new DataOutputStream(player.getOutputStream());

						System.out.println("Porta :" + player.getPort());
						System.out.println("enviando");
						out.write(("1a" + "\n").getBytes());
						System.out.println("enviada");
						out.flush();
						// sleep(500);
						// Recebe letra do do cliente
						BufferedReader inFromMatch = new BufferedReader(new InputStreamReader(player.getInputStream()));

						// sleep(1000);

						String letra = inFromMatch.readLine();
						System.out.println("Letra recebida: " + letra);
						if (this.word.contains(letra)) {
							out.write(("s" + "\n").getBytes());
							out.flush();

							for (Socket c : this.lst) {
								OutputStream outC = c.getOutputStream();
								if (player != c) {
									outC.write(("2a" + "\n").getBytes());
									outC.flush();
								}
								for (int i = 0; i < vetorWord.length; i++) {
									if (vetorWord[i] == letra.charAt(0)) {
										outC.write((Integer.toString(i) + "\n").getBytes());
										outC.flush();
										outC.write((letra + "\n").getBytes());
										outC.flush();
									}
								}
								outC.write(("fim" + "\n").getBytes());
								outC.flush();
							}
	
							//System.out.println("esta aqui");
							String campeao = inFromMatch.readLine();
							System.out.println("mensagem do cliente :" + campeao);
							
							if (campeao.equals("Venci")) {
								for (Socket d : this.lst) {
									OutputStream outCa = d.getOutputStream();
									if (d == player) {
										outCa.write(("Campeao" + "\n").getBytes());
										outCa.flush();
									} else {
										outCa.write(("Perdeu" + "\n").getBytes());
										outCa.flush();
									}
								}
								stop();
							} else {
								for (Socket d : this.lst) {
									OutputStream outCa = d.getOutputStream();
									//System.out.println("esta aqui");
									outCa.write(("Continua" + "\n").getBytes());
									outCa.flush();
								}
							}

						} else {

							if (this.word.contains(letra)) {
								//System.out.println("esta aqui no if");
								hit = true;
							} else {
								out.write(("n" + "\n").getBytes());
								out.flush();
								hit = false;
							}
						}
						//inFromMatch = new BufferedReader(new InputStreamReader(player.getInputStream()));
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
}
