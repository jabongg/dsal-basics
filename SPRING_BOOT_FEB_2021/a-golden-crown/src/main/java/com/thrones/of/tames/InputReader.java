package com.thrones.of.tames;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class InputReader {

	public static List<String> readInputFile(String fileName) throws IOException {
		
		Path path = Paths.get(fileName);
		//byte[] bytes = Files.readAllBytes(path);
		
		List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
		System.out.println(allLines);
		
		return allLines;
	}
}
