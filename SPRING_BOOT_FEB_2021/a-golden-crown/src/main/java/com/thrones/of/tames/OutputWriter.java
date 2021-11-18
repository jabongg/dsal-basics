package com.thrones.of.tames;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class OutputWriter {
	
public static void writeToOutputFile(String fileName, List<String> list) throws IOException {
		
		//Path path = Paths.get(fileName);
		//Files.write(Paths.get(fileName), content.getBytes());

				//do something with your ArrayList 
				FileOutputStream fos =  
				new FileOutputStream(fileName); 
				ObjectOutputStream oos =  
				new ObjectOutputStream(fos) ;
				oos.writeObject(list) ;
				oos.close() ;
		
		return;
	}
}
