import java.net.*;
import java.util.Scanner;
import java.io.*;
public class Clinte {

	public static void main(String[] args) {
		
		try {
			System.out.println("Criar partida privada");
			System.out.println("Entrar em partida existente");
			System.out.println("Entrar em partida");
			
			Socket ClientSocket = new Socket("localhost", 8000);
			
			String msn = "1";
			
			DataOutputStream outType = new DataOutputStream(
					ClientSocket.getOutputStream());
			outType.writeBytes(msn + "\n");			
			
			DataOutputStream outQ = new DataOutputStream(
					ClientSocket.getOutputStream());
			msn = "1";
			outQ.writeBytes(msn + "\n");
			
			DataOutputStream codRoom = new DataOutputStream(
					ClientSocket.getOutputStream());
			codRoom.writeBytes("1233"+"\n");
			
			while(true) {
				System.out.println("loop");
				
				InputStream in = ClientSocket.getInputStream();

				byte[] b = new byte[1024];
				
				String menssagem = new String(b,0,in.read(b));
				String txt2 = new String(b,0,in.read(b));
				System.out.println(menssagem +" "+ txt2);
				
				
				OutputStream out = ClientSocket.getOutputStream();
				
				out.write("chegou".getBytes());
				out.flush();
				
				
				
			}
			
					
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
