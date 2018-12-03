package me.yocom.advent2018.day3;

public class Claim {
	private Integer id;
	private Integer xOffset;
	private Integer yOffset;
	private Integer width;
	private Integer height;


	public Claim(String claimString){
		String[] splitClaim = claimString.split(" ");
		String id = splitClaim[0];
		id = id.substring(1);
		this.id = Integer.valueOf(id);
		String offsetString = splitClaim[2];
		offsetString = offsetString.replace(":","");
		String[] offsets = offsetString.split(",");
		String xOffset = offsets[0];
		String yOffset = offsets[1];
		this.xOffset = Integer.valueOf(xOffset);
		this.yOffset = Integer.valueOf(yOffset);
		String sizeString = splitClaim[3];
		String[] sizes = sizeString.split("x");
		String width = sizes[0];
		String height = sizes[1];
		this.width = Integer.valueOf(width);
		this.height = Integer.valueOf(height);
	}


	public boolean intersects(Claim otherClaim){

		Integer myBottom = this.height + yOffset;
		Integer myRight = this.width + xOffset;
		Integer theirBottom = otherClaim.getYOffset() +  otherClaim.getHeight();
		Integer theirRight = otherClaim.getXOffset() + otherClaim.getWidth();

		if(myBottom >= otherClaim.getYOffset() && yOffset <= theirBottom){
			// y values in range

			if(myRight >= otherClaim.getXOffset() && xOffset <= theirRight){
				// x values in range
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Claim{" +
			"id=" + id +
			", xOffset=" + xOffset +
			", yOffset=" + yOffset +
			", height=" + height +
			", width=" + width +
			'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getXOffset() {
		return xOffset;
	}

	public void setXOffset(Integer xOffset) {
		this.xOffset = xOffset;
	}

	public Integer getYOffset() {
		return yOffset;
	}

	public void setYOffset(Integer yOffset) {
		this.yOffset = yOffset;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}
}
