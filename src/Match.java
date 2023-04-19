import java.util.ArrayList;
import java.io.*;
import java.net.*;

public class Match extends Thread{
	
	public ArrayList<Socket> lst = new ArrayList<Socket>();
	private int qntPlay;
	private int codRoom;
	
	Match(int qntplay, int codRoom){
		this.qntPlay = qntplay;
		this.codRoom = codRoom;
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
	
}
