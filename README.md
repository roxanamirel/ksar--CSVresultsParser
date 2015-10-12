# ksar--CSVresultsParser
Supposes having monitored with sar each node belonging to a cluster and an agregation of these results for 
the whole cluster is wanted.(e.g. Total memory utilization in a cluster)
Given the ksar CSV results (for more nodes) it parses all the csv files and creates a csv output 
containg the agregated values for the entire cluster for:
%Memory Utilization
%CPU Utilization
%CPU Wait I/O
%CPU Idle
%Disk Utilization
Network Utilization (MB)
Attached is a sample of the input files and an output file
