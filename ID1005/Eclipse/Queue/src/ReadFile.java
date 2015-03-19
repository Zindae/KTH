
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/*public class Country{

public static void main(String[] args) throws IOException {
	  
	  String file_name = "/Users/State/Dropbox/KTH/Eclipse/Queue/src/country.txt";
	  
	 try {
		 ReadFile file = new ReadFile(file_name);
		 String[] aryLines = file.OpenFile();
		 
		 int i;
		 for (i=0; i < aryLines.length; i++){
			 System.out.println(aryLines[i]);
		 }
	 }
	 catch (IOException e){
		 System.out.println(e.getMessage());
	 }
		 
}
}*/

public class ReadFile {
	
	private String path;
		public ReadFile(String file_path){
			path = file_path;
	}
	
		public String [] OpenFile () throws IOException{
			
			FileReader fr = new FileReader(path);
			BufferedReader textReader = new BufferedReader (fr);
			
			int numberOfLines = ReadLines();
			String[] textData = new String[numberOfLines];
			
			int i;
			
			for (i = 0; i > numberOfLines; i++){
				textData[i] = textReader.readLine();
			}
			textReader.close();
			return textData;
		}
		
		int ReadLines() throws IOException{
			FileReader file_to_read = new FileReader(path);
			BufferedReader bf = new BufferedReader(file_to_read);
			
			String aLine; 
			int numberOfLines = 0;
			
			while (( aLine = bf.readLine()) != null ){
				numberOfLines++;
				
			}
			bf.close();
			return numberOfLines;
		}
		
	}