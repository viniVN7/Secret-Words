import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Clinte {

	public static void main(String[] args) {

		try {
			System.out.println("Criar partida privada");
			System.out.println("Entrar em partida existente");
			System.out.println("Entrar em partida");

			Socket ClientSocket = new Socket("10.50.164.168", 8000);

			String msn = "1";

			DataOutputStream outType = new DataOutputStream(ClientSocket.getOutputStream());
			outType.writeBytes(msn + "\n");

			DataOutputStream outQ = new DataOutputStream(ClientSocket.getOutputStream());
			msn = "1";
			outQ.writeBytes(msn + "\n");

			DataOutputStream codRoom = new DataOutputStream(ClientSocket.getOutputStream());
			codRoom.writeBytes("1233" + "\n");

			while (true) {
				System.out.println("loop");

				InputStream in = ClientSocket.getInputStream();

				byte[] b = new byte[1024];

				String menssagem = new String(b, 0, in.read(b));
				//System.out.println("menssagem "+ menssagem);
				if (menssagem.equals("1")) {
					//System.out.println("ta aqui");
					String a = null;
					OutputStream out = ClientSocket.getOutputStream();
					out.write("r".getBytes());
					out.flush();

					String acept = new String(b, 0, in.read(b));
					
					
					BufferedReader inFromClient = new BufferedReader(
							new InputStreamReader(ClientSocket.getInputStream()));
					
					
					
					if (acept.equals("s")) {
						System.out.println("ta na parte dois");
					
						String posicao;
						while (( posicao = inFromClient.readLine())!= "fim") {
							
							System.out.println("Posicao: " + posicao);
						}
						
						
//						while (a != "fim") {
//							byte[] r = new byte[1024];
//
//							String posicao = new String(r, 0, in.read(r));
//							String letra = new String(r, 0, in.read(r));
//							String hit = new String(r, 0, in.read(r));
//
//							System.out.println(posicao + " " + letra + " " + hit);
//
//						}
					}
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
