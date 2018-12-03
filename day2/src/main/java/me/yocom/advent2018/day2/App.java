package me.yocom.advent2018.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class App {

	private static final List<String> input = new ArrayList<String>();

	public static void main(String[] args) {
		final String filePath = args[0];
		final File inputFile = new File(filePath);
		final BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(inputFile));
		} catch (FileNotFoundException e) {
			throw new RuntimeException("could not read file", e);
		}

		String line;

		try {
			while ((line = reader.readLine()) != null) {
				input.add(line);
			}
		} catch (IOException e) {
			throw new RuntimeException("could not read line", e);
		}

		Integer itemsThatHaveThreeOfAKind = 0;
		Integer itemsThatHaveTwoOfAKind = 0;


		HashMap<String, List<String>> stringSubsets = new HashMap<>();

		for (String inputString : input) {
			List<String> characters = new ArrayList<>();
			Integer max = inputString.length();
			HashMap<String,Integer> mapOfCharacters = new HashMap<>();
			for(int i = 0; i < max; i++){
				String character = String.valueOf(inputString.charAt(i));
				characters.add(character);

				if(mapOfCharacters.containsKey(character)){
					Integer numberOfInstances = mapOfCharacters.get(character);
					numberOfInstances++;
					mapOfCharacters.put(character,numberOfInstances);
				} else {
					mapOfCharacters.put(character, 1);
				}
			}

			boolean hadTwo = false;
			boolean hadThree = false;

			for (Entry<String, Integer> entry : mapOfCharacters.entrySet()) {
				if (entry.getValue() == 3 && !hadThree) {
					System.out.println("String : " + inputString + " - has three of a kind of : " + entry.getKey());
					itemsThatHaveThreeOfAKind++;
					hadThree = true;
				} else if(entry.getValue() == 2 && !hadTwo){
					System.out.println("String : " + inputString + " - has two of a kind of : " + entry.getKey());
					itemsThatHaveTwoOfAKind++;
					hadTwo = true;
				}
			}

			for(int i = 0;  i < max; i++){
				int j = 0;
				String newString = "";
				for(String character : characters){
					if(j != i){
						newString += character;
					}
					j++;
				}

				System.out.println("original : " + inputString + " - new: " + newString);
				List<String> originalStrings;

				if(stringSubsets.containsKey(newString)){
					originalStrings = stringSubsets.get(newString);
				} else {
					originalStrings = new ArrayList<>();
				}
				if(originalStrings.contains(inputString)){
					continue;
				}
				originalStrings.add(inputString);
				stringSubsets.put(newString, originalStrings);
			}
		}

		for (Entry<String, List<String>> entry : stringSubsets.entrySet()) {
			if(entry.getValue().size() > 1){
				System.out.println("found similar : " + entry.getKey() + " - originals : " + entry.getValue());
			}
		}

		System.out.println("# of Items that have two of a kind : " + itemsThatHaveTwoOfAKind);
		System.out.println("# of Items that have three of a kind : " + itemsThatHaveThreeOfAKind);
		System.out.println("checksum : " + (itemsThatHaveTwoOfAKind * itemsThatHaveThreeOfAKind));
	}
}
