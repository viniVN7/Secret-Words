import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server {

	public static final int CRIAR_SALA = 1;
	public static final int ENTRAR_SALA = 2;
	
	public static ArrayList<Match> matches = new ArrayList<Match>();

	public static void main(String[] args) {

		// Apenas para testar o m�todo criado
		/*
		SelectWord themeWord = new SelectWord(null, null);		
		themeWord.WordRondon();
		System.out.println(themeWord.getTheme() + " " + themeWord.getWord());

		Match.stringToArray(themeWord.getWord());
		*/
		try {

			ServerSocket server = new ServerSocket(8000);
			while (true) {
				Socket s = server.accept();

				BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

				String optionMatchResponse = in.readLine();
				String numberPlayersResponse = in.readLine();
				String codeRoomResponse = in.readLine();

				System.out.println(optionMatchResponse + " " + numberPlayersResponse + " " + codeRoomResponse);
				int qntplay = Integer.parseInt(numberPlayersResponse);
				int opcaoPartida = Integer.parseInt(optionMatchResponse);
				int room = Integer.parseInt(codeRoomResponse);
				System.out.println("resMatch" + opcaoPartida);
				
				if (opcaoPartida == CRIAR_SALA) {
					ArrayList<Socket> lstS = new ArrayList<Socket>();
					SelectWord sw = new SelectWord(null, null);
					sw.WordRondon();
					
					Match match = new Match(lstS, qntplay, room, sw.getTheme(),sw.getWord());
					matches.add(match);
					match.lst.add(s);
					
					
					if (match.lst.size() == qntplay) {
						match.start();
					}
				} else if (opcaoPartida == ENTRAR_SALA) {

					for (Match partida : matches) {
						if(partida.getCodRoom() == room) {
							partida.lst.add(s);
							
							System.out.println("quantidade de jogadores" + partida.lst.size() + "quantidade da sala" + qntplay);
							if (partida.lst.size() == partida.getQntPlay()){
								partida.start();
							}
						}
						for (Socket socketMatch: partida.getLst()) {
							System.out.println("porta: " + socketMatch.getPort());
						}
					}
				}
				
				System.out.println("salas");
				for (Match match : matches) {
					System.out.println(match.getCodRoom());
				}


				System.out.println("chegou aqui!!!");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
