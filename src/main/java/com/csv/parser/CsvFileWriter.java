package com.csv.parser;



import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author rroman
 * 
 */
public class CsvFileWriter {
	
	//Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ";";
	private static final String NEW_LINE_SEPARATOR = "\n";
	
	//CSV file header
	private static final String FILE_HEADER = "date,memoryUtilization,cpuUserUtilization,cpuWaitIO,cpuIdle,diskSdaUtilization,networkUtilization";
	private CSVFileDescription csv;
	private int noNodes;
	//private static final double BANDWIDTH = 1250.0;
	
	public CsvFileWriter(CSVFileDescription csv, int noNodes){
		this.csv = csv;
		this.noNodes=noNodes;
		
	}

	public void writeCsvFile(String fileName) {
		
		FileWriter fileWriter = null;
				
		try {
			fileWriter = new FileWriter(fileName);

			//Write the CSV file header
			fileWriter.append(FILE_HEADER.toString());
			
			//Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);
			
			//Write a new student object list to the CSV file
			for (DataRowStructure row :csv.getCsv_structure()) {
//				Calendar calendar = Calendar.getInstance();
//				calendar.setTime(row.getTime());
//				int hours = calendar.get(Calendar.HOUR_OF_DAY);
//				int minutes = calendar.get(Calendar.MINUTE);
//				int seconds = calendar.get(Calendar.SECOND);
				fileWriter.append(row.getTime()+"" );
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(row.getMemoryUtilization()/noNodes));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(row.getCpuUserUtilization()/noNodes));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(row.getCpuWaitIO()/noNodes));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(row.getCpuIdle()/noNodes));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(row.getDiskSdaUtilization()/noNodes));
				fileWriter.append(COMMA_DELIMITER);
				double mB = row.getNetworkUtilization()/1000.0;
				//double totalBandCluster = noNodes * BANDWIDTH;
				//fileWriter.append(String.valueOf((mB*100.0)/totalBandCluster));
				fileWriter.append(String.valueOf((mB)));
				fileWriter.append(NEW_LINE_SEPARATOR);
			}

			
			
			System.out.println("CSV file was created successfully !!!");
			
		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
			}
			
		}
	}
}
