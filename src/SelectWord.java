import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class SelectWord {
	private String Word;
	private String theme;
	private int id;

	public SelectWord(String word, String theme) {
		Word = word;
		this.theme = theme;
	}

	public String WordRondon() {
		ArrayList<Word> lst = new ArrayList<Word>();
		
		try {
			File arquivoXlsx = new File("./File/FileWord.csv");
			
			if(arquivoXlsx.exists()) {
				System.out.println("existe");
			}
			String line = new String();
			Scanner read = new Scanner(arquivoXlsx);
			read.nextLine();
			
			while(read.hasNext()) {
				Word word = new Word();
				line = read.nextLine();
				
				String []value = line.split(";");
				

					word.setId(value[0]);
					word.setTheme(value[1]);
					word.setP1(value[2]);
					word.setP2(value[3]);
					word.setP3(value[4]);
					word.setP4(value[5]);
					word.setP5(value[6]);
					
					lst.add(word);
				
			}
			int contW = 3;
			for (Word word : lst) {
				if(Integer.parseInt(word.getId()) == 2) {
					this.theme = word.getTheme();
					if(contW == 3) {
						this.Word = word.getP3();
					}
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return "a";
	}

	public String getWord() {
		return Word;
	}

	public void setWord(String word) {
		Word = word;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
