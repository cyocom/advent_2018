package me.yocom.advent2018.day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {

	private static final List<Integer> input = new ArrayList<Integer>();

	public static void main(String[] args){
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
			while((line = reader.readLine()) != null){
				Integer val = Integer.valueOf(line);
				input.add(val);
			}
		} catch (IOException e) {
			throw new RuntimeException("could not read line", e);
		}


		int i = 0;
		int running = 0;
		boolean firstTime = true;
		final Set<Integer> seenRunningValues = new HashSet<>();
		while(true){
			Integer inputVal = input.get(i++);
			running += inputVal;

			if(seenRunningValues.contains(running)){
				System.out.println("Found value : " + running);
				break;
			}

			seenRunningValues.add(running);
			if(i == input.size()){
				if(firstTime){
					firstTime = false;
					System.out.println("Running Total first time thru : " + running);
				}
				System.out.println("reached end - " + inputVal + ", trying again");
				i = 0;
			}
		}

	}

}
