package com.lengolyte.service;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public interface RowService {
	
	Dataset<Row> countRows();
	

}
