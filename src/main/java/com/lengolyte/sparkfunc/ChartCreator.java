//package com.lengolyte.sparkfunc;
//
//import org.apache.spark.sql.Dataset;
//import org.apache.spark.sql.Row;
////import org.apache.spark.sql.SparkSession;
//import org.apache.spark.sql.SparkSession;
//
//import com.lengolyte.config.ApplicationConfig;
//import org.apache.spark.SparkContext;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
////import org.springframework.jdbc.core.JdbcTemplate;
//
//import javax.sql.*;
//
//@Component
//public class ChartCreator {
//	
//	@Autowired
//	private SparkSession sparkSession;
//	
//	public Dataset<Row> groupby()
//	{
//		Dataset<Row> jdbcDF = sparkSession.read()
//				  .format("jdbc")
//				  .option("url", "jdbc:mysql://127.0.0.1/Lengo")
//				  .option("dbtable", "onlinesales")
//				  .option("user", "root")
//				  .option("password", "k3yb0@rd")
//				  .load();
//		
//		jdbcDF.show();
//		return jdbcDF;
//	}
//
//}
