package com.csv.parser;



public class DataRowStructure {
	
	private long time;
	private double memoryUtilization;
	private double cpuUserUtilization;
	private double cpuWaitIO;
	private double cpuIdle;
	private double diskSdaUtilization;
	private double networkUtilization;
	
	
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public double getMemoryUtilization() {
		return memoryUtilization;
	}
	public void setMemoryUtilization(double memoryUtilization) {
		this.memoryUtilization = memoryUtilization;
	}
	public double getCpuUserUtilization() {
		return cpuUserUtilization;
	}
	public void setCpuUserUtilization(double cpuUserUtilization) {
		this.cpuUserUtilization = cpuUserUtilization;
	}
	public double getCpuWaitIO() {
		return cpuWaitIO;
	}
	public void setCpuWaitIO(double cpuWaitIO) {
		this.cpuWaitIO = cpuWaitIO;
	}
	public double getCpuIdle() {
		return cpuIdle;
	}
	public void setCpuIdle(double cpuIdle) {
		this.cpuIdle = cpuIdle;
	}
	public double getDiskSdaUtilization() {
		return diskSdaUtilization;
	}
	public void setDiskSdaUtilization(double diskSdaUtilization) {
		this.diskSdaUtilization = diskSdaUtilization;
	}
	public double getNetworkUtilization() {
		return networkUtilization;
	}
	public void setNetworkUtilization(double networkUtilization) {
		this.networkUtilization = networkUtilization;
	}
	@Override
	public String toString() {
		return "DataRowStructure [time=" + time + ", memoryUtilization="
				+ memoryUtilization + ", cpuUserUtilization="
				+ cpuUserUtilization + ", cpuWaitIO=" + cpuWaitIO
				+ ", cpuIdle=" + cpuIdle + ", diskSdaUtilization="
				+ diskSdaUtilization + "]";
	}
	
	
	
	
}
