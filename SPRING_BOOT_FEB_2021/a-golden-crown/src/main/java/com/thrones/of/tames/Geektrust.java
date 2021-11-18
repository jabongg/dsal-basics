package com.thrones.of.tames;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// jdk 1.8 compatible
public class Geektrust {

	// storing the kingdom and its emblem in a hashmap
	private static Map<String, String> kingdomEmblemMap = new HashMap<>();
	private static List<String> allegianceList = new ArrayList<>();

	public static void main(String[] args) {

		try {

			/*
			 * file read logic
			 */
			String[] filePath = args;
			List<String> inputList = readInputFile(filePath[0]);

			// main allegiance logic
			for (String input : inputList) {
				String[] kingdomMessage = input.split(" ", 2);
				String kingdom = kingdomMessage[0];
				String cipher = kingdomMessage[1];

				checkForAllegianceWithOtherKingDoms(kingdom, cipher);

			}

			if (allegianceList.size() >= 3) { // minimum number of kingdom's alliance needed
				allegianceList.add(0, "SPACE"); // it can be hardcoded as King Shan is from SPACE and allegiance will
												// always
				// be initiated from his side
				// System.out.println(allegianceList);

			} else {
				allegianceList.clear();
				allegianceList.add("NONE"); // this is the required output in case of allegiance failure
			}

			// Create the file
			String output = writeToOutputFile(allegianceList);
			System.out.print(output);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// write to output file logic
	public static String writeToOutputFile(List<String> list) throws IOException {
		// get string from the list
		String allegienceString = ""; // since size of allegiance string will be small.. at max six objects will be
										// created in SCP. so choosing String otherwise will choose StringBuilder.
		for (int i = 0; i < list.size(); i++) {
			if (i != list.size() - 1)
				allegienceString = allegienceString.concat(list.get(i) + " ");
		}

		allegienceString = allegienceString.concat(list.get(list.size() - 1));
		return allegienceString;
	}

	// read from the input file logic
	public static List<String> readInputFile(String fileName) throws IOException {

		Path path = Paths.get(fileName);
		List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
		return allLines;
	}

	private static void initializekingdomEmblemMap() {

		// store the emblems of the kingdoms as given in question
		kingdomEmblemMap.put("SPACE".toUpperCase(), "Gorilla".toUpperCase());
		kingdomEmblemMap.put("LAND".toUpperCase(), "Panda".toUpperCase());
		kingdomEmblemMap.put("AIR".toUpperCase(), "Owl".toUpperCase()); // later create a dedicated class Kingdom :
																		// kingdom and emblem properties
		kingdomEmblemMap.put("FIRE".toUpperCase(), "Dragon".toUpperCase());
		kingdomEmblemMap.put("ICE".toUpperCase(), "Mammoth".toUpperCase());
		kingdomEmblemMap.put("WATER".toUpperCase(), "Octopus".toUpperCase());

	}

	private static void checkForAllegianceWithOtherKingDoms(String kingdom, String cipher) {
		initializekingdomEmblemMap(); // initialization order is important
	
		// no need to handle null pointer exception
		String emblem = kingdomEmblemMap.get(kingdom);
		int secretKey = emblem.length(); // it will throw null pointer exception if emblem is null
	
		String decryptedMessage = decrypt(cipher, secretKey);
	
		// now check if decryptedMessage contains all the emblem characters or not
		// logic for kingdom-win by king Shan starts from here
		boolean containsEmblem = containsEmblem(decryptedMessage, emblem);
	
		if (containsEmblem) {
			// look for duplicate inputs
			if (!allegianceList.contains(kingdom)) {
				allegianceList.add(kingdom);
			}
		}
	}

	public static String decrypt(String cipher, int secretKey) {
		String decryptedMessage = "";

		for (int i = 0; i < cipher.length(); ++i) {
			char ch = cipher.charAt(i);

			if (ch >= 'a' && ch <= 'z') {
				ch = (char) (ch - secretKey);

				if (ch < 'a') {
					ch = (char) (ch + 'z' - 'a' + 1);
				}

				decryptedMessage += ch;
			} else if (ch >= 'A' && ch <= 'Z') {
				ch = (char) (ch - secretKey);

				if (ch < 'A') {
					ch = (char) (ch + 'Z' - 'A' + 1);
				}

				decryptedMessage += ch;
			} else {
				decryptedMessage += ch;
			}
		}

		return decryptedMessage;
	}

	private static boolean containsEmblem(String decryptedMessage, String emblem) {
		Map<Character, Integer> hm = new HashMap<>();

		for (int i = 0; i < decryptedMessage.length(); i++) {
			Character key = decryptedMessage.charAt(i);
			int count = 0;

			if (hm.containsKey(key)) {
				count = hm.get(key);
			}
			hm.put(key, ++count);
		}

		for (int i = 0; i < emblem.length(); i++) {
			Character key = emblem.charAt(i);

			if (hm.containsKey(key)) {
				int count = hm.get(key);

				if (count > 0) {
					hm.put(key, --count);
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	}

}
