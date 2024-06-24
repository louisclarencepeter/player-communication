#!/bin/bash

# Run single-process version
echo "Running single-process version:"
mvn exec:java -Dexec.mainClass="com.example.Main"

# Run multi-process version
echo -e "\nRunning multi-process version:"
mvn exec:java -Dexec.mainClass="com.example.PlayerProcess" -Dexec.args="Player1 Player2" &  # Start PlayerProcess with args Player1 and Player2 in background
PID1=$!  # Store process ID of first PlayerProcess

mvn exec:java -Dexec.mainClass="com.example.PlayerProcess" -Dexec.args="Player2 Player1" &  # Start PlayerProcess with args Player2 and Player1 in background
PID2=$!  # Store process ID of second PlayerProcess

wait $PID1 $PID2  # Wait for both PlayerProcesses to finish