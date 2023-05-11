import java.net.*;
import java.util.Iterator;
import java.util.Scanner;
import java.io.*;

public class Client {

	public static void main(String[] args) {

		try {


			Socket ClientSocket = new Socket("localhost", 8000);


			DataOutputStream out = new DataOutputStream(ClientSocket.getOutputStream());
			
			//Enviar opção partida
			Scanner p = new Scanner(System.in);
			System.out.println("Criar partida privada: Digite 1");
			System.out.println("Entrar em partida existente: Digite 2");
			String partida = p.nextLine();
			String player ;
			String qntPlay =  "7";
			String codRoom = null;
			if (partida.equals("1")) {
				System.out.println("Digite o numero de jogadores");
				qntPlay = p.nextLine();

				System.out.println("Digite o codigo da sala");
				codRoom = p.nextLine();

			}else if(partida.equals("2")){
				System.out.println("Digite o codigo da sala");
				codRoom = p.nextLine();
			}
			
			out.writeBytes(partida + "\n");
			out.flush();
			
			//Enviar quanditades de jogadores
			out.writeBytes(qntPlay + "\n");
			out.flush();
			
			//Enviar codgo da sala
			out.writeBytes( codRoom + "\n");
			out.flush();
			
			BufferedReader inFromClient = new BufferedReader(
					new InputStreamReader(ClientSocket.getInputStream()));
			// Aguardando tamanho da String da palavra;
			System.out.println("Aguardando o tamanho da palavra ");
			String receiveWord = inFromClient.readLine();
			int cont = 0;
			System.out.println("palavra recebida :" + receiveWord);
			char[] WordPosintion = new char [receiveWord.length()];
			char[] letrasSelecting = new char[50];
			for(int i = 0; i < letrasSelecting.length; i++) {
				letrasSelecting[i] = '*';
			}
			System.out.println(WordPosintion.length);
			for(int i = 0; i < WordPosintion.length; i++) {
				WordPosintion[i] = '*';
			}
			
			for (char c : WordPosintion) {
				System.out.println(c);
			}
			System.out.println();
			
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
					String Exist = null;
					for (int i = 0; i < letrasSelecting.length; i++) {

						if (letrasSelecting[i] == msn.charAt(0)) {
							System.out.println("letra repetida");
							Exist = "0";
						}
					}
					
					//Enviando letra para o servidor 
					if(Exist != "0") {
					out.write((msn.toUpperCase()+"\n").getBytes());
					out.flush();
					}else {
						out.write(("#" + "\n").getBytes());
						out.flush();
					}
					//Recebendo confirmação do servidor
					String acept = inFromClient.readLine();


					if (acept.equals("s")) {
						System.out.println("ta na parte dois");
						char b = ' ';
						String posicao = null;
						//Enquanto não receber "fim", ficar recebendo a letra e a posição da letra
						while (!(posicao = inFromClient.readLine()).equals("fim")) {

							System.out.println("Posicao: " + posicao);
							
							String letra = inFromClient.readLine();
							System.out.println(letra);
							char[] aux = letra.toCharArray();
							
							WordPosintion[Integer.parseInt(posicao)] = aux[0];
							b = aux[0];
						}
						
						letrasSelecting[cont] = b;
						cont ++;
						
						for (char c : WordPosintion) {
							System.out.print(" "+c + " ");
						}
						String str = new String(WordPosintion);
						
						if(receiveWord.equals(str)) {
							System.out.println("temos um vencedor");
							out.write(("Venci" + "\n").getBytes());
							out.flush();
						}
						else {
							System.out.println("Continua");
							out.write(("nao" + "\n").getBytes());
							out.flush();
						}
						System.out.println("esperando msn do servidor");
						// Receber confirmação de vitoria ou continuação de partida
						String endMatch = inFromClient.readLine();
						if(endMatch.equals("Campeao")) {
							ClientSocket.close();
						}
						System.out.println("Menssagem de fim partida :" + endMatch);

					}
					
					
				} else if(menssagem.equals("2a")){
					
					String posicao = null;
					char b = ' ';
					//Enquanto não receber "fim", ficar recebendo a letra e a posição da letra
					while (!(posicao = inFromClient.readLine()).equals("fim")) {

						System.out.println("Posicao: " + posicao);
						String letra = inFromClient.readLine();
						System.out.println(letra);
						char[] aux = letra.toCharArray();
						WordPosintion[Integer.parseInt(posicao)] = aux[0];
						b = aux[0];
					}
					for (char c : WordPosintion) {
						System.out.print(" "+c + " ");
					}
					
					letrasSelecting[cont] = b;
					cont ++;
					String endMatch = inFromClient.readLine();
					if(endMatch.equals("Perdeu")) {
						ClientSocket.close();
					}
					System.out.println("Menssagem de fim partida :" + endMatch);
					
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
