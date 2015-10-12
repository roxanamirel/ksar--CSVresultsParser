package com.csv.parser;

import java.util.ArrayList;
import java.util.List;

public class CSVFileDescription {

	private List<DataRowStructure> csv_structure;
    private String name;
	public CSVFileDescription(String name) {
		this.name = name;
		this.csv_structure = new ArrayList<DataRowStructure>();
	}
	public List<DataRowStructure> getCsv_structure() {
		return csv_structure;
	}
	public String getName() {
		return name;
	}
	public void setCsv_structure(List<DataRowStructure> csv_structure) {
		this.csv_structure = csv_structure;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void addRows(DataRowStructure row){
		this.csv_structure.add(row);
		
	}
	@Override
	public String toString() {
		
		return "CSVFileDescription [csv_structure=" + csv_structure + ", name="
				+ name + "]";
	}
	
	
	
	
	
	
}
