package com.dashboard.to;

import com.amazon.webservices.awsecommerceservice.DecimalWithUnits;

public class ItemHeightTO {

	private DecimalWithUnits height;
	private DecimalWithUnits length;
	private DecimalWithUnits weight;
	private DecimalWithUnits width;
	public DecimalWithUnits getHeight() {
		return height;
	}
	public void setHeight(DecimalWithUnits height) {
		this.height = height;
	}
	public DecimalWithUnits getLength() {
		return length;
	}
	public void setLength(DecimalWithUnits length) {
		this.length = length;
	}
	public DecimalWithUnits getWeight() {
		return weight;
	}
	public void setWeight(DecimalWithUnits weight) {
		this.weight = weight;
	}
	public DecimalWithUnits getWidth() {
		return width;
	}
	public void setWidth(DecimalWithUnits width) {
		this.width = width;
	}
}
