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


			DataOutputStream out = new DataOutputStream(ClientSocket.getOutputStream());
			
			//Enviar opção partida
			
			out.writeBytes("2" + "\n");
			out.flush();
			
			//Enviar quanditades de jogadores
			out.writeBytes("2" + "\n");
			out.flush();
			
			//Enviar codgo da sala
			out.writeBytes("1233" + "\n");
			out.flush();
			BufferedReader inFromClient = new BufferedReader(
					new InputStreamReader(ClientSocket.getInputStream()));
			while (true) {
				System.out.println("loop");
	
				//Recebendo confirmação do servidor
				String menssagem = inFromClient.readLine();
				
				System.out.println("esta aqui depois do loop");
				System.out.println("menssagem " + menssagem);
				if (menssagem.equals("1a")) {
					// 		
					System.out.println("Digite uma letra");
					Scanner s = new Scanner(System.in);
					String msn = s.nextLine();
					//Enviando letra para o servidor 
					out.write((msn+"\n").getBytes());
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
						
					}

				} else if(menssagem.equals("2a")){
					
					String posicao = null;
					//Enquanto não receber "fim", ficar recebendo a letra e a posição da letra
					while (!(posicao = inFromClient.readLine()).equals("fim")) {

						System.out.println("Posicao: " + posicao);
						String letra = inFromClient.readLine();
						System.out.println(letra);

					}
					
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
