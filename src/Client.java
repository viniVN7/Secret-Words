import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Client {

	public static void main(String[] args) {

		try {
			System.out.println("Criar partida privada");
			System.out.println("Entrar em partida existente");
			System.out.println("Entrar em partida");

			Socket ClientSocket = new Socket("localhost", 8000);


			DataOutputStream outOptionMatch = new DataOutputStream(ClientSocket.getOutputStream());
			
			//Enviar opção partida
			outOptionMatch.flush();
			outOptionMatch.writeBytes("1" + "\n");
			outOptionMatch.flush();
			
			//Enviar quanditades de jogadores
			outOptionMatch.writeBytes("1" + "\n");
			outOptionMatch.flush();
			
			//Enviar codgo da sala
			outOptionMatch.writeBytes("1233" + "\n");
			outOptionMatch.flush();
			
			while (true) {
				System.out.println("loop");

				BufferedReader inFromClient = new BufferedReader(
						new InputStreamReader(ClientSocket.getInputStream()));
				//Recebendo confirmação do servidor
				String menssagem = inFromClient.readLine();
				System.out.println("esta aqui depois do loop");
				System.out.println("menssagem " + menssagem);
				if (menssagem.equals("1")) {
					// 
					DataOutputStream out = new DataOutputStream(ClientSocket.getOutputStream());
					out.flush();
					//Enviando letra para o servidor 
					out.write(("r"+"\n").getBytes());
					out.flush();
					
					//Recebendo confirmação do servidor
					String acept = inFromClient.readLine();


					if (acept.equals("s")) {
						System.out.println("ta na parte dois");

						String posicao = null;
						//Enquanto não receber "fim", ficar recebendo a letra e a posição da letra
						while (!(posicao = inFromClient.readLine()).equals("fim")) {

							System.out.println("Posicao: " + posicao);
							String letra = inFromClient.readLine();
							System.out.println(letra);

						}
						inFromClient = new BufferedReader(new InputStreamReader(ClientSocket.getInputStream()));
				

					}
				} else {

					String posicao = null;
					while (!(posicao = inFromClient.readLine()).equals("fim")) {

						System.out.println("Posicao: " + posicao);
						String letra = inFromClient.readLine();
						System.out.println(letra);

					}
					inFromClient = new BufferedReader(new InputStreamReader(ClientSocket.getInputStream()));
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
