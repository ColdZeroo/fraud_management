# fraud_management
This application is a fraud management sample! It aims to detect the fraudulent advertisements within a vehicles seller website!

The application is a Spring Boot application that takes a json file describing the advertisement as input and tells whether the ad is fraudulent or not based on a set of rules.

What can complete this work, is a configuration file (yaml for example) where the rules can be defined and be the single place we change, that would make the code stable and open for extension. 

I displayed the result in the standard output. We could use log4j to log the results into a file. An example of a response (for the given json file): 

{"reference":"B300053623","scam":true,"rules":["rule::price::quotation_rate","rule::registernumber::blacklist"]}

You can create the jar using: mvn package 

You can launch the program using the command line: java -jar fraud-management-1.0-SNAPSHOT.jar

Java Version: 8

Duration: 4 hours. 
