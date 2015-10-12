package com.csv.parser;

import java.util.List;

public class Agregator {

	public static CSVFileDescription agregate(
			List<CSVFileDescription> toAgregate) {

		CSVFileDescription agregated = new CSVFileDescription("per-cluster3");
		CSVFileDescription first = toAgregate.get(0);
		// int noNodes = toAgregate.size();

		int noRows = first.getCsv_structure().size();
		for (int row = 0; row < noRows; row++) {
			double totalmemoryUtilization = 0.0;
			double totalcpuUserUtilization = 0.0;
			double totalcpuWaitIO = 0.0;
			double totalcpuIdle = 0.0;
			double totaldiskSdaUtilization = 0.0;
			double totalnetworkKbUtilization = 0.0;
		
			DataRowStructure newRow = new DataRowStructure();
			try{
			for (CSVFileDescription csv : toAgregate) {
			
				newRow.setTime(csv.getCsv_structure().get(row).getTime());
				totalmemoryUtilization += csv.getCsv_structure().get(row)
						.getMemoryUtilization();
				totalcpuUserUtilization += csv.getCsv_structure().get(row)
						.getCpuUserUtilization();
				totalcpuWaitIO += csv.getCsv_structure().get(row)
						.getCpuWaitIO();
				totalcpuIdle += csv.getCsv_structure().get(row).getCpuIdle();
				totaldiskSdaUtilization += csv.getCsv_structure().get(row)
						.getDiskSdaUtilization();
				totalnetworkKbUtilization += csv.getCsv_structure().get(row)
						.getNetworkUtilization();
			
			}

			newRow.setCpuIdle(totalcpuIdle);
			newRow.setCpuUserUtilization(totalcpuUserUtilization);
			newRow.setCpuWaitIO(totalcpuWaitIO);
			newRow.setMemoryUtilization(totalmemoryUtilization);
			newRow.setDiskSdaUtilization(totaldiskSdaUtilization);
			newRow.setNetworkUtilization(totalnetworkKbUtilization);
			agregated.addRows(newRow);
			}
		catch (IndexOutOfBoundsException e ){
			System.out.println(e.getMessage());
		}
		}
		return agregated;

	}

}
