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
			Socket s  = server.accept();
			
			BufferedReader in = new BufferedReader(
					new InputStreamReader(s.getInputStream()));
			String resMatch = in.readLine();
			
//			BufferedReader inQ = new BufferedReader(
//					new InputStreamReader(s.getInputStream()));
//			
//			String resQunat = inQ.readLine();
			
			String resQunat = in.readLine();
			String codRoom = in.readLine();
			System.out.println(resMatch + " "+ resQunat + " " + codRoom);
			
			
			
			
			int qntplay = Integer.parseInt(resQunat);
			
			if(qntplay == 2) {
				int cod = 123;
				if (123 == cod) {
					
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
