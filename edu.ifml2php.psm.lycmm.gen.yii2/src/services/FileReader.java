package services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileReader {

public String getFile(String path) {
   String ret = "";
   try {
      FileInputStream fStream = new FileInputStream(path);
      BufferedReader in = new BufferedReader(new InputStreamReader(fStream));
      while (in.ready()) {
         ret += in.readLine()+"\n";         
       }
      in.close();
   }
   catch (IOException e) {
      System.out.println("File input error " + e.getMessage());
   }
	return ret;
}

public String getFile(String path, String keyword) {
   String ret = "";
   try {
      FileInputStream fStream = new FileInputStream(path);
      BufferedReader in = new BufferedReader(new InputStreamReader(fStream));
      while (in.ready()) {
         if(in.readLine().contains(keyword)){
            ret += in.readLine()+"\n";   
         }         
       }
      in.close();
   }
   catch (IOException e) {
      System.out.println("File input error " + e.getMessage());
   }
   return ret;
}

public void makeFolder(String path){
   new File(path).mkdirs();
}

public void removeReturnStmt(String varReturn, String path) {
	String lineToRemove= "return $" + varReturn + ";";
	String currentLine;
	File inputFile = new File(path);
	File tempFile = new File(path+"_temp");
	try {
		BufferedReader reader = new BufferedReader(new java.io.FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		while((currentLine = reader.readLine()) != null) {
		    //String trimmedLine = currentLine.trim();
		    if(currentLine.equals(lineToRemove)) continue;
		    writer.write(currentLine + System.getProperty("line.separator"));
		}
		writer.close(); 
		reader.close(); 
		tempFile.renameTo(inputFile);
	} catch (IOException e) {
		e.printStackTrace();
	}
}

}
