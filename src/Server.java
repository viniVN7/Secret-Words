import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Server {

	public static ArrayList<Match> lst = new ArrayList<Match>();

	public static void main(String[] args) {

		try {

			ServerSocket server = new ServerSocket(8000);
			while (true) {
				Socket s = server.accept();

				BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

				String resMatch = in.readLine();
				String resQunat = in.readLine();
				String codRoom = in.readLine();

				System.out.println(resMatch + " " + resQunat + " " + codRoom);

				int qntplay = Integer.parseInt(resQunat);
				int res = Integer.parseInt(resMatch);
				int room = Integer.parseInt(codRoom);
				System.out.println("resMatch" + res);
				
				if (res == 1) {
					ArrayList<Socket> lstS = new ArrayList<Socket>();
					Match match = new Match(lstS, qntplay, room, "Carro");
					lst.add(match);
					match.lst.add(s);
					System.out.println("esta aqui!!");
				} else if (res == 2) {

					for (Match l : lst) {
						if(l.getCodRoom() == room) {
							l.lst.add(s);
							if (lst.size()==l.getQntPlay()){
								l.start();
							}
						}
						for ( Socket ls: l.getLst()) {
							System.out.println("porta: " + ls.getPort());
						}
					}
				}
				
				System.out.println("salas");
				for (Match l : lst) {
					System.out.println(l.getCodRoom());
				}


				System.out.println("chegou aqui!!!");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		
		
		SelectWord sw = new SelectWord(null, null);
		
		
		sw.WordRondon();
		
		System.out.println(sw.getTheme() + " " + sw.getWord());
		
		
		
		
		
		
		
		
		
	}

}
