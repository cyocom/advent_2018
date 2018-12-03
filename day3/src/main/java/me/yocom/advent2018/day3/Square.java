package me.yocom.advent2018.day3;

import java.util.Objects;

public class Square {

	private final Integer x;
	private final Integer y;

	public Square(Integer x, Integer y){
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Square{" +
			"x=" + x +
			", y=" + y +
			'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Square square = (Square) o;
		return x.equals(square.x) &&
			y.equals(square.y);
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	public Integer getX() {
		return x;
	}

	public Integer getY() {
		return y;
	}
}
