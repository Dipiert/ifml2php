package services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
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

public void shift(String array, String item, String path) {
	String file = this.getFile(path);
	file = file.trim();
}

}
