package com.csv.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Hello world!
 *
 */
public class ReadCVS {
	private static int noNodes = 0;

	public static void main(String[] args) {

		ReadCVS obj = new ReadCVS();
		List<CSVFileDescription> toAgregate = obj.run(
				"PATH_TO_/results-csv-from-ksar");
		CSVFileDescription agregatedResults = Agregator.agregate(toAgregate);
		System.out.println(noNodes);
		CsvFileWriter writer = new CsvFileWriter(agregatedResults, noNodes);
		writer.writeCsvFile(agregatedResults.getName());

	}

	public List<CSVFileDescription> run(String directory_path) {
		List<CSVFileDescription> toAgregate = new ArrayList<CSVFileDescription>();
		File dir = new File(directory_path);
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
			System.out.println(directoryListing.length);
			for (File csvFile : directoryListing) {
				System.out.println("Now processing file " + csvFile.getName());
				noNodes++;
				BufferedReader br = null;
				String line = "";
				String cvsSplitBy = ";";
				boolean isFirstLine = true;

				CSVFileDescription csv = new CSVFileDescription(csvFile.getName());
				Date previousDate = null;
				long passedSec = 0;
				try {
					br = new BufferedReader(new FileReader(csvFile));
					while ((line = br.readLine()) != null) {

						DataRowStructure row = new DataRowStructure();
						String[] data = line.split(cvsSplitBy);
						if (data.length > 16) {
							if (!isFirstLine) {
								

								row.setMemoryUtilization(Double.parseDouble(data[1]));
								row.setCpuIdle(Double.parseDouble(data[5]));
								row.setCpuUserUtilization(Double.parseDouble(data[9]));
								row.setCpuWaitIO(Double.parseDouble(data[10]));
								row.setDiskSdaUtilization(Double.parseDouble(data[15]));
								if(data[66].isEmpty() || data[74].isEmpty()){
									//row.setNetworkUtilization(0);
									System.out.println("Found empty string in network utilization");
								}
							
								row.setNetworkUtilization(Double.parseDouble(data[66]) + Double.parseDouble(data[74]));
								
								try {
									Date date = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy").parse(data[0]);
									if(previousDate == null){
										previousDate=date;
										row.setTime(0);
									}
									else{
										long time = (date.getTime() - previousDate.getTime())/1000;
										row.setTime(time);
									}
									
								} catch (ParseException e) {

									e.printStackTrace();
								}

								csv.addRows(row);
							}
							isFirstLine = false;

						}
					}

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (br != null) {
						try {
							br.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				toAgregate.add(csv);

				System.out.println("Done");
			}
			for (CSVFileDescription csvIT : toAgregate) {
				System.out.println(csvIT);
			}
			System.out.println(toAgregate.size());

		} else {
			System.out.println("The argument you provided is not a valid directory path");

		}

		return toAgregate;

	}

}
