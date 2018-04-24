package Class;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UpdateLogFile {

	private String path;
	
	public void checkExistingFile() {
		
		//File file = new File("C:\\Users\\Abdoul Mohamed\\Desktop\\Repo_S8Banque\\Projet_S8_Banque\\Logs.txt");
		File file = new File("Logs.txt");
		this.path = file.getAbsolutePath();
		//System.out.print(path);
		if (!(file.exists())) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Cannot create file");
			}
		}
	}

	public void editFile(String newEntry) {
		String oldLogs = "";
		try {
			//File file = new File("C:\\Users\\Abdoul Mohamed\\Desktop\\Repo_S8Banque\\Projet_S8_Banque\\Logs.txt");
			File file = new File(this.path);

			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
		    while ((line = br.readLine()) != null) {
		    	oldLogs= oldLogs+"\n"+line;
		    }
			
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("-"+newEntry+"\n"+oldLogs);
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		UpdateLogFile uFile = new UpdateLogFile();
//		uFile.checkExistingFile();
//		uFile.editFile("Un test texte");
	}

}
