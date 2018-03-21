package com.lengolyte.repository.impl;

import com.lengolyte.repository.RowDataRepository;
import org.springframework.stereotype.Repository;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

//import java.util.Map;
//import java.util.HashMap;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class RowDataRepoImpl implements RowDataRepository{
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 2933608854531306739L;
	@Autowired
	private SparkSession sparkSession;
	
	@Override
	public Dataset<Row> getAllRows()
	{
		Dataset<Row> jdbcDF = sparkSession.read()
				  .format("jdbc")
				  .option("url", "jdbc:mysql://127.0.0.1/Lengo")
				  .option("dbtable", "onlinesales")
				  .option("user", "root")
				  .option("password", "k3yb0@rd")
				  .load();
		
		//jdbcDF.show();
		
		return jdbcDF;
		
	}
	
	

}
