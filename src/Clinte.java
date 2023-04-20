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
			msn = "2";
			outQ.writeBytes(msn + "\n");
			
			DataOutputStream codRoom = new DataOutputStream(
					ClientSocket.getOutputStream());
			codRoom.writeBytes("1233"+"\n");
			
			
			
						
			System.out.println("chegou");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
