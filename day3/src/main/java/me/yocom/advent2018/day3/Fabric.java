package me.yocom.advent2018.day3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fabric {

	private final Map<Square, List<Claim>> squares = new HashMap<>();

	public Fabric(){

		for(int i = 0; i < 1000; i++){
			for(int j = 0; j < 1000; j++){
				Square square = new Square(i,j);
				List<Claim> claims = new ArrayList<>();
				squares.put(square, claims);
			}
			if(i%100 == 0){
				System.out.println("working on i = " + i);
			}
		}

	}

	public Map<Square, List<Claim>> getSquares() {
		return squares;
	}

	public void processClaim(Claim claim) {
		for(int i = claim.getXOffset(); i < claim.getXOffset() + claim.getWidth(); i++){
			for(int j = claim.getYOffset(); j < claim.getYOffset() + claim.getHeight(); j++){
				Square square = new Square(i,j);
				List<Claim> claims;
				if(!squares.containsKey(square)){
					claims = new ArrayList<>();
				} else {
					claims = squares.get(square);
				}
				claims.add(claim);
				squares.put(square,claims);
			}
		}
	}
}
