import java.util.ArrayList;
import java.io.*;
import java.net.*;

public class Match extends Thread{
	
	public ArrayList<Socket> lst = new ArrayList<Socket>();
	private int qntPlay;
	private int codRoom;
	private String theme;
	
	
	
	public Match(ArrayList<Socket> lst, int qntPlay, int codRoom, String theme) {

		this.lst = lst;
		this.qntPlay = qntPlay;
		this.codRoom = codRoom;
		this.theme = theme;
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
	
	public void run()
    {
		
		try {
			
			
			
//			
//	        int qtdAcertos = 0;
//	        char[ ]  palavra = new char[] {'t','e','s','t','e'};
//	        char[ ] painel = new char[palavra.length];
	        
	        boolean hit = true;
	        
	        
	        
	  //     while(qtdAcertos<qtdAcertos){
	              // loop - faz um PARA para percorer os socket
	                   //loop - enquanto o jogador tiver acertando
	                   
	                        // se o jogador vencedor ele sai de todos os loops
	                        // se ele errar vai para o proximo jogador do para
	    	   while(true) {   
	    		   for (Socket player : this.lst) {
					while(hit) {
						
						OutputStream out = player.getOutputStream();
						out.write("teste".getBytes());
						out.flush();
						out.write("teste2".getBytes());
						
						InputStream in = player.getInputStream();
						
						byte[] b = new byte[1024];
						
						System.out.println(new String(b,0,in.read(b)));
						
						
						
					}
				}
	    	   }


	     //  }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		

    }
	
	public static void stringToArray(String palavra) {
		char[] vetorPalavra = new char[palavra.length()];
		
		char[] stringConvertida = palavra.toCharArray();
		System.arraycopy(stringConvertida, 0, vetorPalavra, 0, stringConvertida.length);

		for (char letra : vetorPalavra) {
			System.out.println(letra);
		}
	}
}
