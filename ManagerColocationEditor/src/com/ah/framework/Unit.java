package com.ah.framework;

public class Unit {

	private int spot;
	private final Rack rack;

	public Unit(Rack rack, int spot) {
		this.rack = rack;
		this.spot = spot;
	}
	
	public Rack getRack() {
		return rack;
	}
	
	public int getSpot() {
		return spot;
	}

}
