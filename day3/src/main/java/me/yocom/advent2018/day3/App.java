package me.yocom.advent2018.day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class App {

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

		final Fabric fabric = new Fabric();
		final List<Claim> claims = new ArrayList<>();

		try {
			while ((line = reader.readLine()) != null) {
				Claim claim = new Claim(line);
				claims.add(claim);
				fabric.processClaim(claim);
			}
		} catch (IOException e) {
			throw new RuntimeException("could not read line", e);
		}

		Integer hasMultipleClaims = 0;

		for (Entry<Square, List<Claim>> entry : fabric.getSquares().entrySet()) {
			String output = String
				.format("%s - claims : %s", entry.getKey(), entry.getValue().size());
			if (entry.getValue().size() > 1) {
				hasMultipleClaims++;
				claims.removeAll(entry.getValue());
			}
		}
		System.out.println(hasMultipleClaims + " squares have multiple claims");
		System.out.println("clean claims: " + claims);

	}
}
