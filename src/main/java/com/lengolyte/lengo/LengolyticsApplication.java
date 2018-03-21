package com.lengolyte.lengo;

//import org.apache.spark.sql.Dataset;
//import org.apache.spark.sql.Row;
//import org.apache.spark.sql.SparkSession;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"com.lengolyte.config","com.lengolyte.controller","com.lengolyte.sparkfunc"})
public class LengolyticsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LengolyticsApplication.class, args);
	}
	
}
