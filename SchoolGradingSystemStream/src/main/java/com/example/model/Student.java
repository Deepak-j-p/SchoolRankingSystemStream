package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Student {
	
	private int rank;
	private int id;
	private String name;
	@JsonIgnore
	private int mathMarks;
	@JsonIgnore
	private int chemMarks;
	@JsonIgnore
	private int phyMarks;
	private int totalMarks;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMathMarks() {
		return mathMarks;
	}
	public void setMathMarks(int mathMarks) {
		this.mathMarks = mathMarks;
	}
	public int getChemMarks() {
		return chemMarks;
	}
	public void setChemMarks(int chemMarks) {
		this.chemMarks = chemMarks;
	}
	public int getPhyMarks() {
		return phyMarks;
	}
	public void setPhyMarks(int phyMarks) {
		this.phyMarks = phyMarks;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks() {
		this.totalMarks = this.mathMarks + this.chemMarks + this.phyMarks;
	}
	

}
